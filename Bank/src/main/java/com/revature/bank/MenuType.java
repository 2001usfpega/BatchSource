package com.revature.bank;

import java.util.function.Consumer;
import java.util.stream.Collectors;

public enum MenuType {
    /**
     * Login Menu to either create a new user or login.
     */
    LOGIN(new Element[]{
            new Element("Create a user.", bank -> {
                System.out.print("Enter your name: ");
                String name;

                while (!User.validName(name = Bank.SCANNER.nextLine())) {
                    System.out.println("Invalid Name, please try again.");
                }

                if (bank.getUsers().containsKey(name)) {
                    System.out.println("That user already exists!");
                    return;
                }

                System.out.print("Enter a password: ");

                bank.getUsers().put(name, new User(name, Bank.readPassword()));
                bank.save();
            }),

            new Element("Login to a user.", bank -> {
                System.out.print("Name: ");

                String name = Bank.SCANNER.nextLine();
                User user = bank.getUsers().get(name);

                if (user == null) {
                    System.out.println("Unknown user '" + name + "'");
                    return;
                }

                System.out.print("Password: ");

                if (user.correctPassword(Bank.readPassword())) {
                    bank.login(user);
                } else {
                    System.out.println("Access Denied!");
                }
            })
    }),

    /**
     * User settings menu containing options to edit the logged in user
     */
    USER(new Element[]{new Element("Change Password", bank -> {
        System.out.println("Please enter a new password: ");
        String password = Bank.readPassword();

        if (User.validPassword(password)) {
            byte[] salt = User.genSalt();

            bank.getLoggedIn().setSalt(salt);
            bank.getLoggedIn().setPasswordHash(User.hashPassword(password, salt));
        } else {
            System.out.println("Invalid password. Make sure you have at least 1 letter, number, and symbol and 4-16 characters long");
        }
    })}),

    /**
     * Account menu containing actions to manipulate accounts
     */
    ACCOUNT(new Element[]{
            new Element("Open a new account", bank -> {
                Account account = new Account(Bank.ACCOUNT_ID.getAndIncrement());

                account.getHolders().add(bank.getLoggedIn().getName());
                bank.getLoggedIn().getAccounts().add(account.getId());
                bank.getAccounts().put(account.getId(), account);
                bank.save();

                System.out.println("New account has been created, awaiting admin approval.");
            }),

            new Element("Deposit to an account", bank -> {
                Account selected = bank.readAccount();

                if (selected == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    System.out.println("That account doesn't exist");
                    return;
                }

                System.out.println("Please Enter the Amount you would like to deposit.");
                selected.setAmount(selected.getAmount() + bank.readDouble());
            }),

            new Element("Withdraw from an account", bank -> {
                Account selected = bank.readAccount();

                if (selected == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    System.out.println("That account doesn't exist");
                    return;
                }

                System.out.println("Please Enter the Amount you would like to withdraw.");

                double withdrawal = bank.readDouble();

                while (selected.getAmount() < withdrawal) {
                    System.out.println("Please enter a positive amount. We're a bank, not a charity.");
                    withdrawal = bank.readDouble();
                }

                selected.setAmount(selected.getAmount() - withdrawal);
            }),

            new Element("Add an authorized user to an account", bank -> {
                for (Integer id : bank.getLoggedIn().getAccounts()) {
                    System.out.println("Account ID: " + id + ", Account Balance: " + bank.getAccounts().get(id));
                }

                System.out.println("Please Select which account you are adding an authorized user.");

                int ID = Bank.readInt();

                System.out.println("Please enter the username of the person to which you are authorizing access.");

                String jointUser = Bank.SCANNER.nextLine();
                User newUser = bank.getUsers().get(jointUser);
                Account newAccount = bank.getAccounts().get(ID);

                newAccount.getHolders().add(newUser.getName());
                newUser.getAccounts().add(newAccount.getId());
                System.out.println("We've authorized user" + jointUser + " your account. We hope this was a wise choice. ");
            }),

            new Element("Transfer money between accounts", bank -> {
                Account selected = bank.readAccount();

                if (selected == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    System.out.println("That account doesn't exist");
                    return;
                }

                System.out.println("Please select which account to which you would like to transfer. ");
                int id = Bank.readInt();
                Account selected2 = bank.getAccounts().get(bank.getLoggedIn().getAccounts().stream().filter(accId -> accId == id).findAny().orElse(null));

                if (selected2 == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    System.out.println("That account doesn't exit!");
                    return;
                }

                System.out.println("Please Enter the Amount you would like to transfer.");
                double transferAmount = bank.readDouble();

                while (transferAmount < 0) {
                    System.out.println("Please enter a positive amount.");
                    transferAmount = bank.readDouble();
                }

                while (selected.getAmount() - transferAmount < 0) {
                    System.out.println("Not enough funds. Get your bread up.");
                    transferAmount = bank.readDouble();
                }

                selected.setAmount(selected.getAmount() - transferAmount);
                selected2.setAmount(selected2.getAmount() + transferAmount);

                System.out.println("Your transfer has been completed, " + bank.getLoggedIn().getName() + "!");
            })
    }),

    /**
     * The main menu after a user logs in
     */
    MAIN(new Element[]{
            new Element("User settings", bank -> bank.openMenu(USER)),

            new Element("Account options", bank -> bank.openMenu(ACCOUNT)),

            new Element("List all users", User.Permission.EMPLOYEE, bank -> {
                for (User user : bank.getUsers().values()) {
                    System.out.println(user.getName() + "");
                }
            }),

            new Element("List accounts needing approval", User.Permission.EMPLOYEE,
                    bank -> bank.getLoggedIn().getAccounts().stream().map(integer -> bank.getAccounts().get(integer))
                            .filter(acc -> !acc.isApproved()).forEach(account -> {
                                System.out.println(account.getId() + " - " + account.getHolders().stream()
                                        .map(name -> bank.getUsers().get(name).getName()).collect(Collectors.joining(", ")));
                            })
            ),

            new Element("Approve an account", User.Permission.EMPLOYEE, bank -> {
                System.out.println("What account would you like to get approved today?");
                int ID = Bank.readInt();
                Account account = bank.getAccounts().get(ID);
                account.setApproved(true);
                System.out.println("Your account has been approved");
            }),

            new Element("Cancel an account", User.Permission.ADMIN, bank -> {
                System.out.println("Please tell us what account you would like to cancel today.");
                int ID = Bank.readInt();
                Account account = bank.getAccounts().remove(ID);
                System.out.println("The requested account has been canceled.");
            })
    });

    private final Element[] elements;

    MenuType(Element[] elements) {
        this.elements = elements;
    }

    public Element[] getElements() {
        return elements;
    }
}

class Element {
    private final String action;
    private final User.Permission permission;
    private final Consumer<Bank> usage;

    public Element(String action, Consumer<Bank> usage) {
        this(action, User.Permission.CUSTOMER, usage);
    }

    public Element(String action, User.Permission permission, Consumer<Bank> usage) {
        this.action = action;
        this.permission = permission;
        this.usage = usage;
    }

    public String getAction() {
        return action;
    }

    public User.Permission getPermission() {
        return permission;
    }

    public void select(Bank bank) {
        usage.accept(bank);
    }
}
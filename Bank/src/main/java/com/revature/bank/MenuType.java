package com.revature.bank;

import com.revature.bank.data.Account;
import com.revature.bank.data.User;
import com.revature.bank.storage.StorageService;

import java.util.function.Consumer;

public enum MenuType {
    /**
     * Login Menu to either create a new user or login.
     */
    LOGIN(new Element[]{
            new Element("Create a user.", bank -> {
                System.out.print("Enter your name: ");
                String name;

                while (!User.validName(name = Bank.SCANNER.nextLine())) {
                    Bank.printError("Invalid Name, please try again: ");
                }

                if (bank.getStorage().getUser(name, "Validating") != null) {
                    Bank.printError("That user already exists!");
                    return;
                }

                System.out.print("Enter a password: ");
                String pass;

                while (!User.validPassword(pass = Bank.readPassword())) {
                    Bank.printError("Invalid password. Make sure you have at least 1 letter, number, and symbol and 4-16 characters long");
                }

                User user = new User(name, pass);

                StorageService.databaseAction("Creating user", () -> {
                    bank.getStorage().insertUser(user);
                    return null;
                });
            }),

            new Element("Login to a user.", bank -> {
                System.out.print("Name: ");

                String name = Bank.SCANNER.nextLine();
                User user = bank.getStorage().getUser(name, "Pulling user info");

                if (user == null) {
                    Bank.printError("Unknown user '" + name + "'");
                    return;
                }

                System.out.print("Password: ");

                if (user.correctPassword(Bank.readPassword())) {
                    bank.login(user);
                } else {
                    Bank.printError("Access Denied!");
                }
            })
    }),

    /**
     * User settings menu containing options to edit the logged in user
     */
    USER(new Element[]{
            new Element("Change Password", bank -> {
                System.out.print("Please enter a new password: ");
                String password = Bank.readPassword();

                if (User.validPassword(password)) {
                    byte[] salt = User.genSalt();

                    bank.getLoggedIn().setSalt(salt);
                    bank.getLoggedIn().setPasswordHash(User.hashPassword(password, salt));
                    bank.getStorage().updateUser(bank.getLoggedIn());
                } else {
                    Bank.printError("Invalid password. Make sure you have at least 1 letter, number, and symbol and 4-16 characters long");
                }
            }),

            new Element("Change Address", bank -> {
                System.out.print("Please enter a new address: ");

                bank.getLoggedIn().setAddress(Bank.SCANNER.nextLine());
                bank.getStorage().updateUser(bank.getLoggedIn());
            })
    }),

    /**
     * Account menu containing actions to manipulate accounts
     */
    ACCOUNT(new Element[]{
            new Element("Open a new account", bank -> {
                Account account = bank.getStorage().createAccount(bank.getLoggedIn());

                account.getHolders().add(bank.getLoggedIn().getName());
                bank.getLoggedIn().getAccounts().add(account.getId());

                Bank.printMessage("New account has been created, awaiting admin approval.");
            }),

            new Element("Deposit to an account", bank -> {
                Account selected = bank.readAccount();

                if (selected == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    Bank.printError("That account doesn't exist");
                    return;
                }

                System.out.print("Please Enter the Amount you would like to deposit: ");
                selected.setBalance(selected.getBalance() + Bank.readDouble());
                bank.getStorage().updateAccount(selected);
            }),

            new Element("Withdraw from an account", bank -> {
                Account selected = bank.readAccount();

                if (selected == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    Bank.printError("That account doesn't exist");
                    return;
                }

                System.out.print("Please Enter the Amount you would like to withdraw: ");

                double withdrawal = Bank.readDouble();

                while (selected.getBalance() < withdrawal) {
                    Bank.printError("Please enter a positive amount. We're a bank, not a charity.");
                    withdrawal = Bank.readDouble();
                }

                selected.setBalance(selected.getBalance() - withdrawal);
                bank.getStorage().updateAccount(selected);
            }),

            new Element("Add an authorized user to an account", bank -> {
                for (int id : bank.getLoggedIn().getAccounts()) {
                    Bank.printMessage("  Account ID: " + id + ", Account Balance: " + bank.getStorage().getAccount(id).getBalance());
                }

                System.out.print("Please Select which account you are adding an authorized user: ");

                int id = Bank.readInt();

                System.out.print("Please enter the username of the person to which you are authorizing access: ");

                String jointUser = Bank.SCANNER.nextLine();
                User newUser = bank.getStorage().getUser(jointUser);
                Account newAccount = bank.getStorage().getAccount(id);

                newAccount.getHolders().add(newUser.getName());
                newUser.getAccounts().add(newAccount.getId());
                bank.getStorage().updateAccount(newAccount);

                Bank.printMessage("We've authorized user" + jointUser + " your account. We hope this was a wise choice.");
            }),

            new Element("Transfer money between accounts", bank -> {
                Account selected = bank.readAccount();

                if (selected == null || !selected.getHolders().contains(bank.getLoggedIn().getName())) {
                    Bank.printError("That account doesn't exist");
                    return;
                }

                System.out.print("Please select which account to which you would like to transfer: ");
                int id = Bank.readInt();

                if (!bank.getLoggedIn().getAccounts().contains(id)) {
                    Bank.printError("That account doesn't exit!");
                    return;
                }

                Account selected2 = bank.getStorage().getAccount(id);

                System.out.print("Please Enter the Amount you would like to transfer: ");
                double transferAmount = Bank.readDouble();

                while (transferAmount < 0) {
                    Bank.printError("Please enter a positive amount.");
                    transferAmount = Bank.readDouble();
                }

                while (selected.getBalance() - transferAmount < 0) {
                    Bank.printError("Not enough funds. Get your bread up.");
                    transferAmount = Bank.readDouble();
                }

                selected.setBalance(selected.getBalance() - transferAmount);
                selected2.setBalance(selected2.getBalance() + transferAmount);
                bank.getStorage().updateAccount(selected);
                bank.getStorage().updateAccount(selected2);

                Bank.printMessage("Your transfer has been completed, " + bank.getLoggedIn().getName() + "!");
            }),

            new Element("Delete an account", bank -> {
                Account account = bank.readAccount();

                if (account == null || !account.getHolders().contains(bank.getLoggedIn().getName())) {
                    Bank.printError("That account doesn't exist");
                } else {
                    if (account.getBalance() > 0) {
                        Bank.printError("You can't delete an account that still has a balance!");
                    } else {
                        bank.getStorage().deleteAccount(account.getId());
                        Bank.printMessage("That account has been deleted.");
                    }
                }
            })
    }),

    /**
     * The main menu after a user logs in
     */
    MAIN(new Element[]{
            new Element("User settings", bank -> bank.openMenu(USER)),

            new Element("Account options", bank -> bank.openMenu(ACCOUNT)),

            new Element("List users", User.Permission.EMPLOYEE, bank -> {
                for (User user : bank.getStorage().getAllUsers()) {
                    Bank.printMessage(user.getName() + " - " + user.getPermission().name());
                }
            }),

            new Element("List accounts", User.Permission.EMPLOYEE, bank -> {
                for (Account account : bank.getStorage().getAccounts()) {
                    Bank.printMessage("  Account ID: " + account.getId() + ", Balance: " + account.getBalance() /*+ ", Holders: " + String.join(", ", account.getHolders())*/);
                }
            }),

            new Element("List accounts needing approval", User.Permission.EMPLOYEE,
                    bank -> bank.getStorage().getAccountsNeedingApproval().forEach(account -> {
                        Bank.printMessage(account.getId() + " - " + String.join(", ", account.getHolders()));
                    })
            ),

            new Element("Approve an account", User.Permission.EMPLOYEE, bank -> {
                System.out.print("What account would you like to get approved today? ");

                int id = Bank.readInt();
                Account account = bank.getStorage().getAccount(id);

                if (account == null) {
                    Bank.printError("That account doesn't exist");
                    return;
                }

                account.setApproved(true);
                bank.getStorage().updateAccount(account);
                Bank.printMessage("The requested account has been approved.");
            }),

            new Element("Cancel an account", User.Permission.ADMIN, bank -> {
                System.out.print("Please tell us what account you would like to cancel today: ");

                int id = Bank.readInt();

                if (bank.getStorage().deleteAccount(id)) {
                    Bank.printMessage("The requested account has been canceled.");
                } else {
                    Bank.printError("That account doesn't exist.");
                }
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
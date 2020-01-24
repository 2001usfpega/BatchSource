package com.revature.bank;

import java.util.function.Consumer;
import java.util.stream.Collectors;

public enum MenuType {
    /**
     * Login Menu to either create a new user or login.
     */
    LOGIN(new Element[]{new Element("Create a user.", bank -> {
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
    }), new Element("Login to a user.", bank -> {
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
    })}),

    /**
     * The main menu after a user logs in
     */
    MAIN(new Element[]{new Element("List all customers", User.Permission.EMPLOYEE, bank -> {
        for (User user : bank.getUsers().values()) {
            System.out.println(user);
        }
    }), new Element("List accounts needing approval", User.Permission.EMPLOYEE, bank -> {
        bank.getLoggedIn().getAccounts().stream().filter(acc -> !acc.isApproved()).forEach(account -> {
            System.out.println(account.getId() + " - " + account.getHolders().stream().map(User::getName).collect(Collectors.joining(", ")));
        });
    }), new Element("Approve an account", User.Permission.EMPLOYEE, bank -> {
        System.out.println("What account would you like to get approved today?");
        int ID = Bank.readInt();
        Account account = bank.getAccounts().get(ID);
        account.setApproved(true);
        System.out.println("Your account has been approved");

    }), new Element("Cancel an account", User.Permission.ADMIN, bank -> {
        System.out.println("Please tell us what account you would like to cancel today.");
        int ID = Bank.readInt();
        Account account = bank.getAccounts().remove(ID);
        System.out.println("The requaested account has been canceled.");

    })}),

    /**
     * User settings menu containing options to edit the logged in user
     */
    USER(new Element[]{new Element("", bank -> {

    })}),

    /**
     * Account menu containing actions to manipulate accounts
     */
    ACCOUNT(new Element[]{new Element("Open a new account", bank -> {
        Account account = new Account(Bank.ACCOUNT_ID.getAndIncrement());

        account.getHolders().add(bank.getLoggedIn());
        bank.getAccounts().put(account.getId(), account);
    }), new Element("Deposit to an account", bank -> {
        bank.getLoggedIn();
        for (Account a : bank.getLoggedIn().getAccounts()) {
            System.out.println("Account ID: " + a.getId() + ", Account Balance:  " + a.getAmount());
        }
        System.out.println("Please select and account ID.");
        int ID = Bank.readInt();
        System.out.println("Please Enter the Amount you would like to deposit.");
        double deposit = bank.readDouble();

        Account selected = bank.getLoggedIn().getAccounts().stream().filter(acc -> acc.getId() == ID).findAny()
                .orElse(null);
        selected.setAmount(selected.getAmount() + deposit);

    }), new Element("Withdraw from an account", bank -> {
        bank.getLoggedIn();
        for (Account a : bank.getLoggedIn().getAccounts()) {
            System.out.println("Account ID: " + a.getId() + ", Account Balance:  " + a.getAmount());
        }
        System.out.println("Please select and account ID.");
        int ID = Bank.readInt();
        System.out.println("Please Enter the Amount you would like to deposit.");
        double withdrawal = bank.readDouble();
        Account selected = bank.getLoggedIn().getAccounts().stream().filter(acc -> acc.getId() == ID).findAny()
                .orElse(null);
        double balance = selected.getAmount();
        while (balance < withdrawal) {
            System.out.println("Please enter a positive amount. We're a bank, not a charity.");
            withdrawal = bank.readDouble();

        }
        selected.setAmount(selected.getAmount() - withdrawal);

    }), new Element("Transfer money between accounts", bank -> {
        bank.getLoggedIn();
        for (Account a : bank.getLoggedIn().getAccounts()) {
            System.out.println("Account ID: " + a.getId() + ", Account Balance:  " + a.getAmount());
        }
        System.out.println("Please select and account ID.");
        int ID = Bank.readInt();

        System.out.println("Please select which account to which you would like to transfer. ");
        int ID2 = Bank.readInt();
        System.out.println("Please Enter the Amount you would like to transfer.");
        double transferAmount = bank.readDouble();
        while (transferAmount < 0) {
            System.out.println("Please enter a positive amount.");
            transferAmount = bank.readDouble();
        }
        Account selected = bank.getLoggedIn().getAccounts().stream().filter(acc -> acc.getId() == ID).findAny()
                .orElse(null);

        Account selected2 = bank.getLoggedIn().getAccounts().stream().filter(acc -> acc.getId() == ID).findAny()
                .orElse(null);
        while (selected.getAmount() - transferAmount < 0) {
            System.out.println("Not enough funds. Get your bread up.");
            transferAmount = bank.readDouble();
        }
        selected.setAmount(selected.getAmount() - transferAmount);
        selected2.setAmount(selected2.getAmount() + transferAmount);
        System.out.println("Your transfer has been completed, " + bank.getLoggedIn().getName() + "!");
    })});

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
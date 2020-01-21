package com.revature.bank;

import java.util.function.Consumer;

public enum MenuType {
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

                bank.getUsers().put(name, new User(name, User.hashPassword(Bank.readPassword()), User.Permission.CUSTOMER));
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
    MAIN(new Element[]{
            new Element("Open a new account", bank -> {
                Account account = new Account(Bank.ACCOUNT_ID.getAndIncrement());

                account.getHolders().add(bank.getLoggedIn());
                bank.getAccounts().put(account.getId(), account);
            }),
            new Element("Deposit to an account", bank -> {

            }),
            new Element("Withdraw from an account", bank -> {}),
            new Element("Transfer money between accounts", bank -> {}),
            new Element("Deposit to an account", bank -> {}),
            new Element("List all customers", User.Permission.EMPLOYEE, bank -> {}),
            new Element("List accounts needing approval", User.Permission.EMPLOYEE, bank -> {}),
            new Element("Approve an account", User.Permission.EMPLOYEE, bank -> {}),
            new Element("Cancel an account", User.Permission.ADMIN, bank -> {}),
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
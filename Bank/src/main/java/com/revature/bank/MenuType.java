package com.revature.bank;

import java.util.function.Consumer;

public enum MenuType {
    MAIN(new Element[]{
            new Element("Create a user.", bank -> {
                System.out.print("Enter your name: ");
                String name;

                while (!User.validName(name = Bank.SCANNER.nextLine())) {
                    System.out.println("Invalid Name, please try again.");
                }

                System.out.print("Enter a password: ");

                Bank.CUSTOMERS.put(name, new User(name, User.hashPassword(Bank.readPassword()), User.Permission.CUSTOMER));
            })/*,
            new Element("Login to a user.")*/
    }),
    USER(new Element[]{
          /*  new Element("Open a new account"),
            new Element("Deposit to an account"),
            new Element("Withdraw from an account"),
            new Element("Transfer money between accounts"),
            new Element("Deposit to an account")*/
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
    private final Consumer<Bank> usage;

    public Element(String action, Consumer<Bank> usage) {
        this.action = action;
        this.usage = usage;
    }

    public void select(Bank bank) {
        usage.accept(bank);
    }
}
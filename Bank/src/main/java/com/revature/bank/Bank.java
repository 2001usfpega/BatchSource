package com.revature.bank;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1uOtESr7QJAmXMQpK-uxdxRdL070ANWj7KKzAV1Utycw/edit
 */
public class Bank {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final Map<Integer, Account> ACCOUNTS = new HashMap<>();
    public static final Map<String, User> CUSTOMERS = new HashMap<>();

    static {
        try {
            FileOutputStream stream = new FileOutputStream("test");
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(writer);

            // out.write();
            stream.write(writer.toByteArray());
            stream.flush();

            DataInputStream in = new DataInputStream(new ByteArrayInputStream(writer.toByteArray()));

            // in.readNBytes()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Revature Bank!");
        System.out.println("Please select an action:");
        System.out.println("1 - Create a user.");
        System.out.println("2 - Login to a user.");
        System.out.println("3 - Exit.");

        int option;

        while ((option = readInt()) != 3) {
            if (option == 1) {

            } else if (option == 2) {
                System.out.print("Name: ");

                String name = SCANNER.nextLine();
                User user = CUSTOMERS.get(name);

                if (user == null) {
                    System.out.println("Unknown user '" + name + "'");
                    continue;
                }

                System.out.print("Password: ");

                if (user.correctPassword(readPassword())) {
                    login(user);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }

    private static void openMenu(MenuType type) {
        int size = type.getElements().length;

        System.out.println("Please select an action:");

        for (int i = 0; i < size; i++) {
            System.out.println(i + " - " + type.getElements()[i]);
        }

        System.out.println((size + 1) + " - Exit.");

        int option;

        while ((option = readInt()) != size) {

        }
    }

    static String readPassword() {
        return System.console() == null ? SCANNER.nextLine() : new String(System.console().readPassword());
    }

    private static int readInt() {
        int i = SCANNER.nextInt();
        SCANNER.nextLine();
        return i;
    }

    private static void login(User user) {
        System.out.println("Welcome, " + user.getName() + "!");
        System.out.println("Please select an action:");
        System.out.println("1 - Open a new account");
        System.out.println("2 - Deposit to an account");
        System.out.println("3 - Withdraw from an account");
        System.out.println("4 - Transfer money between accounts");
        System.out.println("5 - Exit");

        int option;

        while ((option = readInt()) != 5) {
            if (option == 1) {

            }
        }
    }
}
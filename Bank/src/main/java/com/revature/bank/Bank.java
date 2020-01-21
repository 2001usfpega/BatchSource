package com.revature.bank;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://docs.google.com/document/d/1uOtESr7QJAmXMQpK-uxdxRdL070ANWj7KKzAV1Utycw/edit
 */
public class Bank {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final AtomicInteger ACCOUNT_ID = new AtomicInteger(0);

    private final Map<Integer, Account> accounts = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    private User loggedIn;

    public static void main(String[] args) {
        System.out.println("Welcome to Revature Bank!");

        new Bank().openMenu(MenuType.LOGIN);
    }

    {
        try {
            FileOutputStream stream = new FileOutputStream("test");
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(writer);

            // out.write();
            stream.write(writer.toByteArray());
            stream.flush();

           /* DataInputStream in = new DataInputStream(new FileInputStream("accounts"));

            for (int i = 0; i < in.readInt(); i++) {

            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        users.computeIfAbsent("admin", create -> new User("admin", User.hashPassword("admin"), User.Permission.ADMIN));
    }

    private void openMenu(MenuType type) {
        int size = type.getElements().length;

        for (int i = 1; i <= size; i++) {
            //TODO permission check for options
            System.out.println(i + " - " + type.getElements()[i - 1].getAction());
        }

        System.out.println((size + 1) + " - Exit.");
        System.out.print("Please select an action: ");

        int option;

        while ((option = readInt()) != size + 1) {
            if (option > 0 && option <= size) {
                type.getElements()[option - 1].select(this);
            } else {
                System.out.println("Invalid selection!");
                System.out.print("Please select an action: ");
            }
        }
    }

    void login(User user) {
        System.out.println("Welcome, " + user.getName() + "!");

        loggedIn = user;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User getLoggedIn() {
        return loggedIn;
    }

    static String readPassword() {
        return System.console() == null ? SCANNER.nextLine() : new String(System.console().readPassword());
    }

    static int readInt() {
        try {
            int i = SCANNER.nextInt();
            SCANNER.nextLine();
            return i;
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            return -1;
        }
    }
}
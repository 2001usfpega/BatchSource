package com.revature.bank;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://docs.google.com/document/d/1uOtESr7QJAmXMQpK-uxdxRdL070ANWj7KKzAV1Utycw/edit
 */
public class Bank {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final AtomicInteger ACCOUNT_ID = new AtomicInteger(0);

    private final Map<Integer, Account> accounts = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    private User loggedIn;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Welcome to Revature Bank!");
        new Bank().save();//.openMenu(MenuType.LOGIN);
    }

    {
        users.computeIfAbsent("admin", create -> {
            User admin = new User("admin", "admin");

            admin.setPermission(User.Permission.ADMIN);
            return admin;
        });
    }

    private void load() {
    }

    private void save() {
        File userDir = new File("users\\");

        if (!userDir.exists()) {
            userDir.mkdir();
        }

        users.values().forEach(user -> {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users\\" + user.getName()));

                out.writeObject(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void openMenu(MenuType type) {
        List<Element> elements = Stream.of(type.getElements()).filter(element -> loggedIn == null || loggedIn.getPermission().ordinal() >= element.getPermission().ordinal()).collect(Collectors.toList());
        int size = elements.size();

        for (int i = 1; i <= size; i++) {
            System.out.println(i + " - " + elements.get(i - 1).getAction());
        }

        System.out.println((size + 1) + " - Exit.");
        System.out.print("Please select an action: ");

        int option;

        while ((option = readInt()) != size + 1) {
            if (option > 0 && option <= size) {
                elements.get(option - 1).select(this);
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

    public double readDouble() {
        try {
            double i = SCANNER.nextDouble();
            SCANNER.nextLine();
            return i;
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            return -1;
        }
    }
}
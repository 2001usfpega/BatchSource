package com.revature.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    public static Logger LOGGER = LogManager.getLogger(Bank.class);
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final AtomicInteger ACCOUNT_ID = new AtomicInteger(0);

    public static final File USERS_DIR = new File("users");
    public static final File ACCOUNTS_DIR = new File("accounts");

    private final Map<Integer, Account> accounts = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    private User loggedIn;

    public static void main(String[] args) {
        System.out.println("Welcome to Revature Bank!");

        Bank bank = new Bank();

        bank.load();
        bank.openMenu(MenuType.LOGIN);
        bank.save();
    }

    {
        // Create the default admin user if it doesn't exist
        users.computeIfAbsent("admin", create -> {
            User admin = new User("admin", "admin");

            admin.setPermission(User.Permission.ADMIN);
            return admin;
        });

        // Create the default employee user if it doesn't exist
        users.computeIfAbsent("employee", create -> {
            User admin = new User("employee", "employee");

            admin.setPermission(User.Permission.ADMIN);
            return admin;
        });
    }

    void save() {
        if (!USERS_DIR.exists()) {
            USERS_DIR.mkdir();
        }

        users.values().forEach(user -> {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USERS_DIR.getPath() + "\\" + user.getName()));

                out.writeObject(user);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (!ACCOUNTS_DIR.exists()) {
            ACCOUNTS_DIR.mkdir();
        }

        accounts.values().forEach(account -> {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_DIR.getPath() + "\\" + account.getId()));

                out.writeObject(account);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void load() {
        if (USERS_DIR.exists()) {
            for (File file : USERS_DIR.listFiles()) {
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                    User user = (User) in.readObject();

                    users.put(user.getName(), user);
                    in.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        if (ACCOUNTS_DIR.exists()) {
            for (File file : ACCOUNTS_DIR.listFiles()) {
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                    Account account = (Account) in.readObject();

                    accounts.put(account.getId(), account);
                    in.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        ACCOUNT_ID.set(1 + accounts.values().stream().mapToInt(Account::getId).max().orElse(0));
    }

    public void openMenu(MenuType type) {
        List<Element> elements = Stream.of(type.getElements()).filter(element -> element.getPermission() == User.Permission.CUSTOMER
                || loggedIn.getPermission().ordinal() >= element.getPermission().ordinal()).collect(Collectors.toList());
        int size = elements.size();
        int option;

        do {
            for (int i = 1; i <= size; i++) {
                System.out.println(i + " - " + elements.get(i - 1).getAction());
            }

            System.out.println((size + 1) + " - Exit.");
            System.out.print("Please select an action: ");

            option = readInt();

            if (option > 0 && option <= size) {
                elements.get(option - 1).select(this);
            } else if (option != size + 1) {
                System.out.println("Invalid selection!");
            }
        } while (option != size + 1);
    }

    void login(User user) {
        System.out.println("Welcome, " + user.getName() + "!");

        loggedIn = user;
        LOGGER.info("User '" + user.getName() + "' logged in.");
        openMenu(MenuType.MAIN);
    }

    public Account readAccount() {
        for (Integer id : loggedIn.getAccounts()) {
            System.out.println("Account ID: " + id + ", Balance: " + accounts.get(id).getAmount());
        }

        System.out.println("Please select and account ID.");

        int id = Bank.readInt();

        return accounts.get(loggedIn.getAccounts().stream().filter(aacId -> aacId == id).findAny().orElse(null));
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    /**
     * Gets the current user logged into the bank app
     */
    public User getLoggedIn() {
        return loggedIn;
    }

    /**
     * Read a hidden String from console if available, otherwise read from Scanner
     */
    static String readPassword() {
        return System.console() == null ? SCANNER.nextLine() : new String(System.console().readPassword());
    }

    /**
     * Reads an int from console
     */
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

    /**
     * Reads a double from console
     */
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
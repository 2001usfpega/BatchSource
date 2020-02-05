package com.revature.bank;

import com.revature.bank.data.Account;
import com.revature.bank.data.User;
import com.revature.bank.storage.StorageService;
import com.revature.bank.storage.OracleSQLService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://docs.google.com/document/d/1uOtESr7QJAmXMQpK-uxdxRdL070ANWj7KKzAV1Utycw/edit
 */
public class Bank {
    public static final Logger LOGGER = LogManager.getLogger(Bank.class);
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001b[32m";

    private final StorageService storage;

    private User loggedIn;

    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();

        bank.openMenu(MenuType.LOGIN);
        bank.shutdown();
    }

    Bank() throws IOException {
        storage = new OracleSQLService();

        System.out.println("Welcome!");

        // Create the default admin user if it doesn't exist
      /*  database.getUser("admin", null);
        users.computeIfAbsent("admin", create -> {
            User admin = new User("admin", "admin");

            admin.setPermission(User.Permission.ADMIN);
            database.insertUser(admin);
            return admin;
        });*/

        // Create the default employee user if it doesn't exist
      /*  database.getUser("employee", null);
        users.computeIfAbsent("employee", create -> {
            User employee = new User("employee", "employee");

            employee.setPermission(User.Permission.EMPLOYEE);
            database.insertUser(employee);
            return employee;
        });*/
    }

    void shutdown() {
        printMessage("Goodbye!");
        storage.close();
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
                printError("Invalid selection!");
            }
        } while (option != size + 1);
    }

    void login(User user) {
        printMessage("Welcome, " + user.getName() + "!");

        loggedIn = user;
        LOGGER.info("User '" + user.getName() + "' logged in.");
        openMenu(MenuType.MAIN);
    }

    public Account readAccount() {
        for (int id : loggedIn.getAccounts()) {
            printMessage("  Account ID: " + id + ", Balance: " + storage.getAccount(id).getBalance());
        }

        System.out.print("Please select and account ID: ");

        int id = Bank.readInt();

        return storage.getAccount(id);
    }

    public StorageService getStorage() {
        return storage;
    }

    /**
     * @return The current user logged into the bank app
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
            return 0;
        }
    }

    /**
     * Reads a double from console
     */
    static double readDouble() {
        try {
            double d = SCANNER.nextDouble();
            SCANNER.nextLine();
            return d;
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            return 0;
        }
    }

    /**
     * Prints a red message to console
     */
    static void printError(String message) {
        System.out.println(RED + message + RESET);
    }

    /**
     * Prints a green message to console
     */
    static void printMessage(String message) {
        System.out.println(GREEN + message + RESET);
    }
}
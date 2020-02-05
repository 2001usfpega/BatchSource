package com.revature.bank.storage;

import com.revature.bank.data.Account;
import com.revature.bank.data.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public interface StorageService {

    void insertUser(User user);

    default User getUser(String name) {
        return getUser(name, null);
    }

    User getUser(String username, String loadMsg);

    List<User> getAllUsers();

    void updateUser(User user);

    Account createAccount(User initialHolder);

    Account getAccount(int id);

    List<Account> getAccounts();

    List<Account> getAccountsNeedingApproval();

    void updateAccount(Account account);

    boolean deleteAccount(int id);

    void close();

    /**
     * Performs a blocked database action while printing out '.' to indicate loading
     */
    static <T> T databaseAction(String message, Supplier<T> action) {
        if (message == null) {
            return action.get();
        }

        System.out.print(message + ".");

        AtomicBoolean done = new AtomicBoolean();

        new Thread(() -> {
            while (!done.get()) {
                try {
                    System.out.print('.');
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        T t = action.get();

        done.set(true);
        System.out.println();

        return t;
    }
}
package com.revature.bank.storage;

import com.revature.bank.data.Account;
import com.revature.bank.data.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SerializedFileService implements StorageService {
    public static final AtomicInteger ACCOUNT_ID = new AtomicInteger(0);

    public static final File USERS_DIR = new File("users");
    public static final File ACCOUNTS_DIR = new File("accounts");

    private final Map<Integer, Account> accounts = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    public SerializedFileService() {
        if (USERS_DIR.exists()) {
            for (File file : USERS_DIR.listFiles()) {
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                    User user = (User) in.readObject();

                    users.put(user.getName(), user);
                    in.close();
                } catch (IOException | ClassNotFoundException | ClassCastException e) {
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
                } catch (IOException | ClassNotFoundException | ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }

        ACCOUNT_ID.set(1 + accounts.values().stream().mapToInt(Account::getId).max().orElse(0));
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User getUser(String username, String loadMsg) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Account createAccount(User initialHolder) {
        return null;
    }

    @Override
    public Account getAccount(int id) {
        return accounts.get(id);
    }

    @Override
    public List<Account> getAccountsNeedingApproval() {
        return null;
    }

    @Override
    public void updateAccount(Account user) {

    }

    @Override
    public boolean deleteAccount(int id) {
        return true;
    }

    @Override
    public void close() {
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
}
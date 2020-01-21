package com.revature.bank;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private final String name;
    private byte[] passwordHash;

    private Permission permission;

    private List<Account> accounts;

    public User(String name, byte[] passwordHash, Permission permission) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.permission = permission;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        User user = (User) other;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean correctPassword(String password) {
        return Arrays.equals(passwordHash, hashPassword(password));
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return permission;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public static boolean validName(String name) {
        return name.matches("^[\\p{L} .'-]+$");
    }

    public static byte[] hashPassword(String password) {
        return Base64.getEncoder().encode((password + "-" + password.hashCode()).getBytes(StandardCharsets.UTF_8));
    }

    public enum Permission {
        /**
         * Customers apply to open an account.
         * Customers should be able to apply for joint accounts
         * Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
         */
        CUSTOMER,

        /**
         * Employees of the bank should be able to view all of their customers information
         * This includes, account information
         * Account balances
         * Personal information
         * Employees should be able to approve/deny open applications for accounts
         */
        EMPLOYEE,

        /**
         * Bank admins should be able to view and edit all accounts
         * This includes:
         * Approving/denying accounts
         * withdrawing, depositing, transferring from all accounts
         * canceling accounts
         */
        ADMIN
    }
}
package com.revature.bank;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 3862300651907839903L;

    private final String name;
    private byte[] passwordHash;
    private byte[] salt;

    private Permission permission = Permission.CUSTOMER;

    private List<Account> accounts;

    public User(String name, String password) {
        this.name = name;
        this.passwordHash = hashPassword(password, salt = genSalt());
    }

    public User(String name, byte[] passwordHash, byte[] salt, Permission permission) {
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
        return Arrays.equals(passwordHash, hashPassword(password, salt));
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public static boolean validName(String name) {
        return name.matches("^[\\p{L} .'-]+$");
    }

    public static byte[] hashPassword(String password, byte[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            digest.update(salt);

            return digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] genSalt() {
        byte[] salt = new byte[512];

        try {
            SecureRandom.getInstance("SHA1PRNG").nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return salt;
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
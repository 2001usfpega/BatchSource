package com.revature.bank;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class User implements Serializable {
    private final String name;
    private byte[] passwordHash;

    private Permission permission;

    public User(String name, byte[] passwordHash, Permission permission) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.permission = permission;
    }

    public boolean correctPassword(String password) {
        return Arrays.equals(passwordHash, hashPassword(password));
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return permission;
    }

    public static boolean validName(String name) {
        return name.matches("^[\\p{L} .'-]+$");
    }

    public static byte[] hashPassword(String password) {
        return Base64.getEncoder().encode((password + "-" + password.hashCode()).getBytes(StandardCharsets.UTF_8));
    }

    public enum Permission {
        CUSTOMER,
        EMPLOYEE,
        ADMIN
    }
}
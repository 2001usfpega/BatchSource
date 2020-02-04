package com.revature.bank.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Account implements Serializable {
    private static final long serialVersionUID = -602406623576694074L;

    private final int id;

    private boolean approved;
    private double balance;

    private Set<String> holders = new HashSet<>();

    public Account(int id, boolean approved, double balance) {
        this.id = id;
        this.approved = approved;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", approved=" + approved + ", amount=" + balance + ", holders=" + holders + "]";
    }

    public int getId() {
        return id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<String> getHolders() {
        return holders;
    }
}
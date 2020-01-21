package com.revature.bank;

import java.io.Serializable;

public class Account implements Serializable {
    private final int id;

    private boolean approved;
    private double amount;

    public Account(int id) {
        this.id = id;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
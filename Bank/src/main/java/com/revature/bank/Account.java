package com.revature.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private static final long serialVersionUID = -602406623576694074L;

    private final int id;

    private boolean approved;
    private double amount;

    private List<String> holders = new ArrayList<>();

    public Account(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", approved=" + approved + ", amount=" + amount + ", holders=" + holders + "]";
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

    public List<String> getHolders() {
        return holders;
    }
}
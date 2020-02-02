package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private double balance;
	private double previousTransaction;
	private String accountNum;
	private String accountName;
	private int primaryKey;

	public Account() {

	}

	public Account(String accountNum, String accountName, int bal) {
		super();
		this.accountNum = accountNum;
		this.accountName = accountName;
		this.balance = bal;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", previousTransaction=" + previousTransaction + ", accountNum="
				+ accountNum + ", accountName=" + accountName + ", primaryKey=" + primaryKey + "]";
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPreviousTransaction() {
		return previousTransaction;
	}

	public void setPreviousTransaction(double previousTransaction) {
		this.previousTransaction = previousTransaction;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	public double deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			previousTransaction = amount;
		} else if (amount < 0) {
			System.out.println("Incorrect entry. Please choose a positive integer");
		}
		return this.balance;
	}

	public double withdraw(double amount) {
		if (amount > 0 && amount < balance) {
			this.balance -= amount;
			previousTransaction = -amount;
		} else if (amount < 0) {
			System.out.println("Incorrect entry.  Please choose a positive integer");
		}
		return this.balance;
	}

	public void printPreviousTransaction() {
		if (previousTransaction > 0)
			System.out.println("Your last deposit was: " + previousTransaction);
		else if (previousTransaction < 0) {
			System.out.println("Your last withdrawal was: " + previousTransaction);
		} else {
			System.out.println("There has been no activity on your account.");
		}
	}
}
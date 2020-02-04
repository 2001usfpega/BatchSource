package com.revature.model;

public class Account {
	
	int customerID;

	Integer accountID;

	double balance;

	private double prevTran;

	public Account(int customerID) {
		this.customerID = customerID;
		accountID = null;
		balance = 0;
		prevTran = 0;
	}
	
	/**
	 * 
	 * @param userID
	 * @param accountID
	 * @param balance
	 */
	public Account(Integer accountID, int customerID, double balance) {
		this.accountID = accountID;
		this.customerID = customerID;
		this.balance = balance;
		prevTran = 0;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPrevTran() {
		return prevTran;
	}

	public void setPrevTran(double prevTran) {
		this.prevTran = prevTran;
	}
	
	public void modifyBalance(double amount) {
		balance += amount;
	}

	@Override
	public String toString() {
		return "\nAccount [customerID=" + customerID + ", accountID=" + accountID + ", balance=" + balance + ", prevTran="
				+ prevTran + "]";
	}

}

package com.revature.banking;

public class Account {
	double balance;
	int accountid;
	int customerid;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public Account(int accountid, double balance, int customerid) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.customerid = customerid;
	}
	
}

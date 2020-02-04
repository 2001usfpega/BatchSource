package com.bank.bean;

public class Account {
	
	private int account_number;
	private String account_type;
	private int account_balance;
	
	
	
	public Account() {}
	
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}

	public Account(int account_number, String account_type, int account_balance) {
		super();
		this.account_number = account_number;
		this.account_type = account_type;
		this.account_balance = account_balance;
	}

	
	
}

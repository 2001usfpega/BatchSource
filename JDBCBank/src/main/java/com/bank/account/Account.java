package com.bank.account;

import com.bank.user.Customer;

public class Account {

	private int accNum;
	private double balance = 0.0;

	public Account() {
	}

	public Account(int id,double bal) {
		accNum = id;
		balance=bal;
	}
	
	public static void createNewAccount(Customer c) {
		//server stuff
	}
	public static void createNewAccount(Customer a, Customer b) {
		//server stuff
	}
	
	/*
	 * Getter methods
	 */
	public int getAccNum() {
		return this.accNum;
	}

	public double getBalance() {
		return this.balance;
	}

	
	//Update balance
	//deposit if positive / withdraw if negative
	//return true if success	 
	public boolean balanceUpdate(double amount) {
		if (amount >= 0) { // Deposit case
			balance += amount;
			//BankUtil.saveAll();
			//call server 
			return true;
		} else {
			if (balance + amount < 0) {
				return false;
			} else {
				balance += amount;
				//BankUtil.saveAll();
				//call server
				
				return true;
			}
		}
	}

	// transfer funds from this account to other
	//return true if success	
	public boolean transferTo(Account other, double amount) {
		if (amount >= 0 && balanceUpdate(-amount)) {
			other.balanceUpdate(amount);
			return true;
		}
		return false;
	}

	public String toString() {
		return "ACC: " + accNum + " $" + balance;
	}
}

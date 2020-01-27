package com.revature.accounts;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.bankutil.BankUtil;

public class Account implements Serializable {

	// serial ID
	private static final long serialVersionUID = 5L;
	private static ArrayList<Account> accList = new ArrayList<Account>();
	//private ArrayList<Customer> ownList = new ArrayList<>();

	private static int nextAccId = 9999;
	private String accNum;
	private double balance = 0.0;

	public Account(String type, double amount) {
		this.accNum = type + nextAccId;
		this.balance = amount;
		nextAccId--;
		
		//add to list of all accounts
		accList.add(this);
		BankUtil.saveAll();
	}

	/*
	 * Setter methods
	 */

	public static void setNextAccId(int x) {
		nextAccId = x;
	}
	public static int getNextAccId() {
		return nextAccId;
	}

	/*
	 * Getter methods
	 */
	public String getAccNum() {
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
			BankUtil.saveAll();
			return true;
		} else {
			if (balance + amount < 0) {
				return false;
			} else {
				balance += amount;
				BankUtil.saveAll();
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

//	public void addAccount(Account acc) {
//		accList.add(acc);
//	}

	//search for account with account id
	public static Account getAccount(String accID) {
		for (Account account : accList) {
			if (account.getAccNum().equals(accID)) {
				return account;
			}
		}
		return null;
	}

	public static ArrayList<Account> getAccountList() {
		return accList;
	}

	public static void initalizeAccoutList(ArrayList<Account> list) {
		accList = list;
	}
}

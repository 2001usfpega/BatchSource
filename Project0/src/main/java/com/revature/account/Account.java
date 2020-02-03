
package com.revature.account;


import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable{
	private static final String ACCOUNT_FILE = "Accounts.txt";

	private Random accountNumGen = new Random();

	String userID;

	String accountID;

	double balance;

	private double prevTran;

	public Account(String userID) {
		this.userID = userID;
		accountID = "" + Math.abs(accountNumGen.nextInt());
		balance = 0;
		prevTran = 0;
	}
	
	/**
	 * 
	 * @param userID
	 * @param accountID
	 * @param balance
	 */
	public Account(String userID, String accountID, double balance) {
		this.accountID = accountID;
		this.userID = userID;
		this.balance = balance;
		prevTran = 0;
	}
	
//	@Override
//	public String toString() {
//		return "Account [accountNumGen=" + accountNumGen + ", userID=" + userID + ", accountID=" + accountID
//				+ ", balance=" + balance + ", prevTran=" + prevTran + "]";
//	}

	/**
	 * 
	 * @param amount
	 * @return
	 */
	public double withdraw(double amount) {
		if (amount > 0 && amount < balance) {
			balance -= amount;
			prevTran = amount;
			return amount;
		} else {
			System.out.println("Invalid amount. Please enter positive amount.");
			return 0;
		}
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			prevTran = -amount;
		} else {
			System.out.println("Invalid amount. Please enter positive amount.");
		}
		
	}
	
	/**
	 * 
	 */
	public void printPrevTran() {
		if (prevTran > 0) {
			System.out.println("You withdrew: $" + prevTran);
		} else if (prevTran < 0) {
			System.out.println("You deposited: $" + prevTran);
		} else {
			System.out.println("You have no recent transactions.");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAccountNumber() {
		return this.accountID;
	}
	
	public double getBalance() {
		return balance;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserID() {
		return this.userID;
	}
}

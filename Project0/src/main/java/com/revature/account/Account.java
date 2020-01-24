package com.revature.account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class Account {
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
	
	public Account(String userID, String accountID, double balance) {
		this.accountID = accountID;
		this.userID = userID;
		this.balance = balance;
		prevTran = 0;
	}

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

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			prevTran = -amount;
		} else {
			System.out.println("Invalid amount. Please enter positive amount.");
		}
	}

	public void printPrevTran() {
		if (prevTran > 0) {
			System.out.println("You withdrew: $" + prevTran);
		} else if (prevTran < 0) {
			System.out.println("You deposited: $" + prevTran);
		} else {
			System.out.println("You have no recent transactions.");
		}
	}

	public String getAccountNumber() {
		return this.accountID;
	}
	
	public String getUserID() {
		return this.userID;
	}

	public void printToFile() {
		OutputStream os = null;
		File file = new File(ACCOUNT_FILE);
		String out = userID + ":" + accountID + ":" + balance + "\n";
		try {
			os = new FileOutputStream(file, true);
			os.write(out.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

package com.revature.maven.bankapp.groupbankapp;

import java.io.Serializable;
import java.util.Scanner;

public class BankAccount implements Serializable{

	private double balance;
	private double previousTransaction;
	private String accountNumber;
	private String name;
	private int accountNum;
	private int primaryKey;
	

	public BankAccount(String accntName) {
		this.name = accntName;
	}
	
	public double getBalance() {
		return this.balance;
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
		}else if (amount < 0) {
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

	void showCustomerMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Bank of Revature.");
		System.out.println("Please choose from one of the following options:");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");

		do {
			option = scanner.next().charAt(0);

			switch (option) {

			case 'A':
				System.out.println("Your balance is " + balance);
				break;

			case 'B':
				System.out.println("Enter an amount to depost.");
				double amount = scanner.nextDouble();
				deposit(amount);
				break;

			case 'C':
				System.out.println("Enter an amount to withdraw.");
				double amount2 = scanner.nextDouble();
				withdraw(amount2);
				break;

			case 'D':
				printPreviousTransaction();
				break;

			case 'E':
				System.out.println("Thank you for banking at the Bank of Revature.  See you soon!!");
				break;
				
			default:
				System.out.println("Invalid choice; Please enter again.");
				break;
			}
		} while (option != 'E');
	}
}

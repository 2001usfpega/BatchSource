package com.revature.bankapp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customer implements SavingsAccount {

	String userename;
	String password;
	String fName;
	String lName;
	String address;
	String city;
	String zip;
	String state;
	String phone;
	String email;
	double balance;
	ArrayList<String>transactions;
	
	Customer(String username, String password, String fName, String lName, String address, String city, String zip, String phone, String email, double balance, Date date){
		this.userename = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.phone = phone;
		this.balance = balance;
		
		transactions = new ArrayList<String>(5);
		
		addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
	}
	
		Customer(){
			
		}
	public void deposit(double amount, Date d) {
		balance += amount;
		
		addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.", date));
		
	}

	public void withdraw(double amount, Date d) {
		if (amount>balance) {
			System.out.println("Insufficient balance to make withdrawal.");
			return;
		}
		balance -= amount;
		
		addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.", date));
	}

	
private void addTransaction(String message) {
	transactions.add(0, message);
	if(transactions.size()>5) {
		transactions.remove(5);
		transactions.trimToSize();
	}
}

}

package com.revature.maven.bankapp.groupbankapp;

public class Customer {
	
	String custName;
	String custAddress;
	String custEMail;
	
	BankAccount customer;
	
	Customer(String name, String address, String email, String acctNum){
		this.custName = name;
		this.custAddress = address;
		this.custEMail = email;
		this.customer = new BankAccount(acctNum);
	}
	
	double deposit(double amount) {
		return customer.deposit(amount);
	}
	
	
	
	

}

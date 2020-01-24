package com.revature.bankingassignment;

public class Customer extends Account {
	
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double amount)
	{
		double b = getBalance();
		b = b-amount;
		setBalance(b);
		
		
	}
	
	public void deposit(double amount)
	{
		double b = getBalance();
		b = b+amount;
		setBalance(b);
		
		
	}
	
	
	
	

}

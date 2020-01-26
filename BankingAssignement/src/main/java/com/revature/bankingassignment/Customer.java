package com.revature.bankingassignment;

import java.io.Serializable;

public class Customer extends Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	
	public void CLogin()
	{
		
		
		
		
	}
	
	
	
	

}

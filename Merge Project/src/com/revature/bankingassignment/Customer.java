package com.revature.bankingassignment;

import java.io.Serializable;
import java.util.Scanner;

public class Customer extends Account implements Serializable {
	
	public String userID;
	public String password;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double balance = 0;
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double amount)
	{
		Scanner withScanner = new Scanner(System.in);
		System.out.println("Enter Withdrawl Amount: ");
		float withdrawValue = withScanner.nextFloat();
		
		
		if(withdrawValue <= balance && withdrawValue>=0) {
			System.out.println("Withdrawal Successsful! ");
			double b = getBalance();
			b = balance-b;
			setBalance(b);
			System.out.println("Balance after withdrawl:" + b);
		}
		else
		{
			System.out.println("Invalid Amount: Withdrawal Amount Exceeds Account Balance");
			
			
		}
		



		
		
	}
	
	public void deposit(double amount)
	{
		Scanner depositScanner = new Scanner(System.in);
		System.out.println("Deposit Amount: ");
		double balance = depositScanner.nextDouble();
		double b = getBalance();
		b = b+balance;
		setBalance(b);
		System.out.println("Balance after deposit:" + b);
		
		
	}
	
	
	public void CLogin()
	{
		
		
		
		
	}
}
	
	
	

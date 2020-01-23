package com.revature.bankingassignment;

import java.util.Scanner;

public class AccountChanges {
	
	int balance;
	
	void deposit(int amountDep)
	{
		if(amountDep > 0)
		{
			
			balance = balance + amountDep;
					 
			
			
		}
		else
		{
			
			System.out.println("Invalid Amount");
		}
		
		
	}

	
	void withdraw(int amountWith)
	{
		if(amountWith > 0 && amountWith < balance)
		{
			
			balance = balance - amountWith;
			
		}
		else
		{
			System.out.println("Invalid Amount");
			
		}
		
	}
	
	void customerOptions()
	{
		int options = 0;
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Hello, ");
		System.out.println();
		System.out.println("Your current account balance is: " + balance);
		System.out.println("Please pick a menu option below:");
		System.out.println();
		System.out.println("Deposit: Enter 1");
		System.out.println();
		System.out.println("Withdrawl: Enter 2");
		
		switch(options)
		{
		case 1: 
			System.out.println();
			System.out.println("Amount being Deposited: ");
			System.out.println();
			int amountDep = myScanner.nextInt();
			deposit(amountDep);
			System.out.println();
			break;
			
			
		
		case 2:
			System.out.println();
			System.out.println("Amount being Withdrawn: ");
			System.out.println();
			int amountWith = myScanner.nextInt();
			deposit(amountWith);
			System.out.println();
			break;
			
		default:
			System.out.println("Invlaid: Please try a valid option");
			
		
		
		}
	}
	

}
package com.revature.customer;


import java.util.Scanner;	

public class Account
{
	public int bal;
	int lastTransaction;
	String custName;
	String custID;	
	public Account()
	{
		
	}	
	Account(String cName,String cID)
	{
		custName = cName;
		custID = cID;
	}	
	void deposit(int amount) 
	{
		if(amount != 0)
		{
			bal = bal + amount;
			lastTransaction = amount;
		}
	}	
	void withdraw(int amount)
	{
		if(amount != 0) 
		{
			bal = bal - amount;
			lastTransaction = -amount;
		}
	}	
	void getLastTransaction() 
	{
		if(lastTransaction > 0)
		{
			System.out.println("Deposited: " + lastTransaction);
		}
		else if(lastTransaction < 0) 
		{
			System.out.println("Withdrawn: " + Math.abs(lastTransaction));
		}
		else 
		{
			System.out.println("No transaction occured");
		}
}
			public void Menu() 
			{
			char option = '\0';
			Scanner input = new Scanner(System.in);			
			System.out.println("Hello " + custName);
			System.out.println("Your ID is "+ custID);
			System.out.println("\n");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Last Transaction");
			System.out.println("5. Exit");
			System.out.println("6. Maintenance");			
			do 
			{
				System.out.println("******************************");
				System.out.println("Choose an option");
				System.out.println("******************************");
				option = input.next().charAt(0);			
				switch (option) 
			{
			case '1':
				System.out.println("===============================");
				System.out.println("Your balance is: " + bal);
				System.out.println("===============================");
				System.out.println("\n");
				break;
			case '2':
				System.out.println("===============================");
				System.out.println("How much would you like to deposit? ");
				System.out.println("===============================");
				int amount = input.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			case '3':
				System.out.println("===============================");
				System.out.println("How much would you like to withdraw? ");
				System.out.println("===============================");
				int amount2 = input.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case '4':
				System.out.println("===============================");
				System.out.println(lastTransaction);
				System.out.println("===============================");
				System.out.println("\n");
				break;
			case '5':
				System.out.println("===============================");
				System.out.println("Would you like to make an account? ");
				System.out.println("===============================");
				System.out.println("\n");
			case '6':
				System.out.println("===============================");
				System.out.println("Would you like to join an account? ");
				System.out.println("===============================");
				System.out.println("\n");
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}			
				}
			while(option != '7');
				System.out.println("Thank you for choosing our bank.  Have a great day.");	
				input.close();
				}
		}

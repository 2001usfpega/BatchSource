package com.revature.bank;

import java.util.*;
import java.io.*;

public class Account extends Application implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static void main(String[] args) {
	
	
	Scanner bank = new Scanner(System.in);
	int pick = '\0';
	System.out.println("Welcome to Revature Bank");
	System.out.println("=========================");
	System.out.println("Choose 1 For Customer");
	System.out.println("Choose 2 For Employee");
	System.out.println("Choose 3 For Administrator");
	System.out.println("Choose 4 For To Exit");
	
	do
	{
	System.out.println("Enter an option");
	pick = bank.nextInt();
	switch (pick) 
	{
	case 1:
		System.out.println("Hey Customer");
		
		
		Bank b = new Bank();
		b.Menu();
		break;
	case 2:
		System.out.println("Hey Employee");
		break;
	case 3:
		System.out.println("Hey Administrator");
		break;
	case 4:
		System.out.println("Bye");
		break;
	case 5:
		break;
		
		default:
			System.out.println("Please choose between 1 and 5");
			
	}
	
	
	
	
	
	
	}while(pick != 0);
	
		
}
}

class Bank{
	int balance;
	int previousTrans;
	
	
	void deposit(int amount) {
		if(amount != 0) {
		balance = balance +amount;
		previousTrans = amount;
		}
	}
	
	void withdraw(int amount) {
		if (amount != 0) 
		{
		balance = balance - amount;
		previousTrans = -amount;
		}
	}
	void getPreviousTrans() {
		if (previousTrans > 0) 
		{
			System.out.println("Deposited " + previousTrans);
		}	
			else if(previousTrans <0) 
			{
			System.out.println("Withdrawn " +Math.abs(previousTrans));	
			}
			else 
			{
			System.out.println("No Transaction Occured");	
			}
		}
	
	public void Menu() {
		Application App = new Application();
		
		char select = '\0';
		
		Scanner scan = new Scanner(System.in);
		System.out.println("==============================");
		System.out.println("Welcome " + App.customerFName +""+ App.customerLName );
		System.out.println("Your ID is " + App.customerAccNum);
		System.out.println("\n");
		System.out.println("==============================");
		System.out.println("A. Check Balance ");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do 
		{
			System.out.println("Enter an option");
			select = scan.next().charAt(0);
			
			switch(select)
			{
			case 'A':
				System.out.println("-----------------------");
				System.out.println("Balance = "+ balance);
				System.out.println("-----------------------");
				System.out.println("\n");
				break;
				
				
			case 'B':
				System.out.println("-----------------------");
				System.out.println("Enter an amount to deposit");
				System.out.println("-----------------------");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("-----------------------");
				System.out.println("Enter an amount to withdraw");
				System.out.println("-----------------------");
				int amount2 = scan.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("-----------------------");
				getPreviousTrans();
				System.out.println("-----------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				break;
				
				
			default:
				System.out.println("Invalid option! Please try again (A-E)");
				
				
			}
		}while (select != 'E');
		
		System.out.println("Thank for choosing Revature");
	}
	
	
	
	
	
}

	

	
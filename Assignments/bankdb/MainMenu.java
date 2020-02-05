package com.kaelin.bankdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
	public int bal;
	int lastTransaction;
	int amount3 = 0;
	String custName;
	String custID;
	String custP;
	boolean y = true;
	String yes = "y";
	String yes1 = "enter";
	Scanner c = new Scanner(System.in);
	private Random random = new Random();
	public void Account(){
		
	}
	
	void Account(String cName,String cID, String custP){
		custName = cName;
		custID = cID;
		//custP = pass;
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			bal = bal + amount;
			lastTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			bal = bal - amount;
			lastTransaction = -amount;
		}
	}
	
	void getLastTransaction() {
		if(lastTransaction > 0) {
			System.out.println("Deposited: " + lastTransaction);
	}
		else if(lastTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(lastTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
}
			public void Menu() throws SQLException {
			char option = '\0';
			Scanner input = new Scanner(System.in);
			
			System.out.println("Hello " + custName);
			System.out.println("Your ID is "+ custID);
			System.out.println("\n");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Last Transaction");
			System.out.println("5. Create New Account");
			System.out.println("6. Create Joint Account");
			System.out.println("7. Maintenance");
			System.out.println("8. Exit");
			
			do {
				System.out.println("******************************");
				System.out.println("Choose an option");
				System.out.println("Hello " + custName);
				System.out.println("Your ID is "+ custID);
				System.out.println("\n");
				System.out.println("0. Login");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Last Transaction");
				System.out.println("5. Create New Account");
				System.out.println("6. Create Joint Account");
				System.out.println("7. Maintenance");
				System.out.println("8. Exit");
				System.out.println("******************************");
				option = input.next().charAt(0);
				
			switch (option) {
			case'0':
				System.out.println("Login");
				System.out.println("===============================");
				//input.next();0
			
				Scanner scan = null;
				try {
					scan = new Scanner (new File("Einput.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    Scanner keyboard = new Scanner (System.in);
			    String user2 = scan.nextLine();
			    String pass2 = scan.nextLine(); // looks at selected file in scan

			    String inpUser = keyboard.nextLine();
			    String inpPass = keyboard.nextLine(); // gets input from user

			    if (inpUser.equals(user2) && inpPass.equals(pass2)) {
			        System.out.print("your login message");
			    } else {
			        System.out.print("your error message");
			    }
				System.out.println("===============================");


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
				System.out.println("Enter y for yes or n for no");
				String s = c.nextLine();
				if(s.equals("y") ){
					//SignIn newUser = new SignIn();
					//newUser.LogIn();
				if(y) {
					System.out.println("Create Username");
					String user = c.next();
					System.out.println("Create Password");
					String pass = c.next();
new MainMenu();
//					act2.deposit(amount3);
//					int money = amount3;
//					String amount3 = c.next();
					Main newCust = new Main();
					newCust.newCustomer(user, pass);
					
					custName = user;
					custID = user;
					//custid = ;
					
//				
					
					
				}
				
				}else{
					Menu();
					
					
				}
				System.out.println("\n");
				break;
			case '6':
				System.out.println("===============================");
				System.out.println("Would you like to join an account? ");
				System.out.println("===============================");
				System.out.println("\n");
				break;
			case '7':
				System.out.println("===============================");
				System.out.println("Enter employee credentials ");
				System.out.println("===============================");
				System.out.println("Enter Username");
				String user = c.next();
				System.out.println("Enter Password");
				String pass = c.next();
				//System.out.println(c.next());
				//BankEmployee emp = new BankEmployee();
				BankEmployee.emp_login(user, pass);
				//BankEmployee.Menu2();
				if("enter" != null);
				switch(option) {
				case'1':
					System.out.println("===============================");
					System.out.println("What would you like to do?");
					System.out.println();
				}
			break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
			
			}while(option != '8');
				System.out.println("Thank you for choosing our CK Financial.  Have a great day.");
			input.close();
			}
			
		
				
				
			}
			
			
		
package com.revature.bankingassignment;

import java.util.Scanner;

public class Account {
	
	private int userID;
	private String password;
	private int accountNumber;
	private String firstName;
	private String lastName;
	private String email;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Account()
	{
		Scanner accountScanner = new Scanner(System.in);
		
		System.out.println("Enter UserId: ");
		int userID = accountScanner.nextInt();
		
		System.out.println("Enter Password: ");
		String password = accountScanner.nextLine();
		
		System.out.println("Enter Account Number: ");
		int accountNumber = accountScanner.nextInt();
		
		System.out.println("Enter First Name: ");
		String firstname = accountScanner.nextLine();
		
		System.out.println("Enter Last Name: ");
		String lastname  = accountScanner.nextLine();
		
		System.out.println("Enter Email: ");
		String email = accountScanner.nextLine();
		
		setUserID(userID);
		setPassword(password);
		setAccountNumber(accountNumber);
		setFirstName(firstname);
		setLastName(lastname);
		setEmail(email);
		
		accountScanner.close();
		
	}
	
	
	
	
	
	
}

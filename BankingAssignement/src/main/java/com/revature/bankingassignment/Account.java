package com.revature.bankingassignment;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	
	/**
	 * 
	 */

	public String userID;
	public String password;
	public int accountNumber;
	public String firstName;
	public String lastName;
	public String email;
	public int nextAccountNumber=1000;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String empUserID) {
		this.userID = empUserID;
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
	
	public void createAccount()
	{
		
		
		Scanner accountScanner = new Scanner(System.in);
		
		
		System.out.println("Enter First Name: ");
		String firstname = accountScanner.next();
		
		System.out.println("Enter Last Name: ");
		String lastname  = accountScanner.next();
		
		System.out.println("Enter Email: ");
		String email = accountScanner.next();
		
		System.out.println("Create a UserId: ");
		String userID = accountScanner.next();
		
		System.out.println("Create a Password: ");
		String password = accountScanner.next();
		
		
		
	//	int accountNumber=nextAccountNumber;
		nextAccountNumber++;
	
		//System.out.println("Enter Account Number: ");
		//int accountNumber = accountScanner.nextInt();
	
		setUserID(userID);
		setPassword(password);
		//setAccountNumber(accountNumber);
		setFirstName(firstname);
		setLastName(lastname);
		setEmail(email);
		//accountScanner.close();
		
		 System.out.println(firstname +" "+ lastname +" Your Account " +nextAccountNumber + " has been created.");
	}

}
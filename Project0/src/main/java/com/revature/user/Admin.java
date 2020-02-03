package com.revature.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5130811158589559967L;

	public Admin(ArrayList<Customer> cust) {
		customers = cust;
	}
	
	/**
	 * 
	 */
	public Admin(String username, String password, String fName, String lName,
			Address address, String phone, String email, ArrayList<Customer> cust) {
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		customers = cust;
	}
	
	/**
	 * 
	 */
	public void cancelAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select Customer");
		for(int i = 1; i <= customers.size(); i++) {
			System.out.println(i + ") " + customers.get(i-1).getUsername());
		}
		int input = scan.nextInt() - 1;
		Customer cust = customers.get(input);
		System.out.println("Select Account");
		for(int i = 1; i <= cust.getAccounts().size(); i++) {
			System.out.println(i + ") " + cust.getAccounts().get(i-1).getAccountNumber());
		}
		input = scan.nextInt() - 1;
		cust.getAccounts().remove(input);
	}
}

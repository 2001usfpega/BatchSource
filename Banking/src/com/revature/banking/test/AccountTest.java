package com.revature.banking.test;

import java.io.Serializable;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class AccountTest extends Account implements Serializable {

	private static final long serialVersionUID = 1;
	
	@SuppressWarnings("unused")
	@Test
	public final void NewAccount() {
			
			// used to create a basic account( either customer, employee, or admin
			// takes in information and assigns them to the object
			
		try (Scanner in = new Scanner(System.in)) {
			
			String firstname, info, lastname,address, password,id;
				
			System.out.println("Enter the account holders First Name: ");
			setFirst_name(firstname=in.nextLine());
				
			System.out.println("Enter the account holders Last Name: ");
			setLast_name(lastname=in.nextLine());
				
			System.out.println("Enter the account holders ID: ");
			setId(id = in.nextLine());
				
			System.out.println("Enter the account holders Password: ");
			setPassword(password = in.nextLine());
				
			System.out.println("Enter the account holders Address: ");
			setAddress(address=in.nextLine());
				
			System.out.println("Enter the account holders Additional Info: ");
			setInfo(info = in.nextLine());
				
			in.close();
		}
	}
}

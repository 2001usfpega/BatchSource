package com.revature.banking.test;

import java.io.Serializable;
import java.util.Scanner;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String first_name;
	public String last_name;
	public String sFirst_name;
	public String sLast_name;
	public String address;
	public String id;
	public String password;
	public String info;
	private transient Scanner in = new Scanner(System.in);
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getsFirst_name() {
		return sFirst_name;
	}
	
	public void setsFirst_name(String sFirst_name) {
		this.sFirst_name = sFirst_name;
	}
	
	public String getsLast_name() {
		return sLast_name;
	}
	
	public void setsLast_name(String sLast_name) {
		this.sLast_name = sLast_name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void NewAccount() {
		
		// used to create a basic account( either customer, employee, or admin 
		// takes in information and assigns them to the object
		
			String firstname, info, lastname,address, password,id;
			System.out.println("Enter the account holder's first name: ");
			setFirst_name(firstname=in.nextLine());
			
			System.out.println("Enter the account holder's last name: ");
			setLast_name(lastname=in.nextLine());
			
			System.out.println("Enter the account holder's ID: ");
			setId(id = in.nextLine());
			
			System.out.println("Enter the account holder's password: ");
			setPassword(password = in.nextLine());
			
			System.out.println("Enter the account holder's address: ");
			setAddress(address=in.nextLine());
			
			System.out.println("Enter the account holder's additional info: ");
			setInfo(info = in.nextLine());
			
	}
	
	public boolean checkNull(String a) {
		
		if(a != null) {
			return true;
			
		}else {
			return false;
			
		}
	}
}
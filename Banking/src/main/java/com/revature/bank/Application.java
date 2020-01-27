package com.revature.bank;

import java.io.*;
import java.util.*;

public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String customerAdress;
	public String customerFName;
	public String customerLName;
	public int customerAccNum = 10;

	

	public String getcustomerFName() {
		return customerFName;
	}

	public void setcustomerFName(String custFName) {
		this.customerFName = custFName;
	}

	public String getcustomerLName() {
		return customerLName;
	}

	public void setcustomerLName(String custLName) {
		this.customerLName = custLName;
	}

	public String getcustomerAdress() {
		return customerAdress;
	}

	public void setcustomerAdress(String custAdrs) {
		this.customerAdress = custAdrs;
	}
	public int getcustomerAccNum() {
		return customerAccNum;
	}

	public void setcustomerAccNum(int custAnum) {
		this.customerAccNum = custAnum;
	}
	
	public void Apply() {

	Scanner apply = new Scanner(System.in);
	System.out.println("Enter Your First Name");
	String firstName = apply.next();
	System.out.println("Enter Your Last Name");
	String lastName = apply.next();
	System.out.println("Enter Your Address Name");
	String address = apply.next();
	
	setcustomerFName(firstName);
	setcustomerLName(lastName);
	setcustomerAdress(address);
	customerAccNum++;
	
	
	
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
}
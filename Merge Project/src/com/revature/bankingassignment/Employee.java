package com.revature.bankingassignment;

import java.io.Serializable;

public class Employee extends Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeID;
	private String employeePassword;
	
	
	public Employee() {
		
	}
	
	public Employee(int userId, String password, int accountnumber, String firstname, String lastname, String email, String empid,
			String empassword) {
		


	}




	public String getEmployeeID() {
		return employeeID;
	}




	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}




	public String getEmployeePassword() {
		return employeePassword;
	}




	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
	//Employee emp = new Employee(8000,"Password1", 8000, "Rob", "Rhamy", "robert.rhamy@gmail.com", 8000, "Yooo");
	
	




	public void viewCustomerAccount()
	{
		Customer customer = new Customer();
		
		//customer= object read in Customer
		
		System.out.println("UserID: " + customer.getUserID());
		System.out.println("Password: " + customer.getPassword());
		System.out.println("Account Number: " + customer.getAccountNumber());
		System.out.println("First Name: " + customer.getFirstName());
		System.out.println("Last Name: " + customer.getLastName());
		System.out.println("Email: " + customer.getEmail());
		System.out.println("Balance: " + customer.getBalance());
		
		
		
	}

}
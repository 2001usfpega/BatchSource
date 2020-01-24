package com.revature.bankingassignment;

public class Employee extends Account {
	
	public void viewCustomerAccount()
	{
		Customer customer = new Customer();
		
		//customer= object read in Customer
		
		System.out.println(customer.getAccountNumber());
		System.out.println(customer.getEmail());
		System.out.println();
		
		
		
	}

}

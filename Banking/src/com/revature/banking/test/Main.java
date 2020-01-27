package com.revature.banking.test;

public class Main {
	public static void main(String [] args) {
//		example of how to write to the specific file
		Customer customer = new Customer();
		ObjectIO rObj = new ObjectIO();
		customer.NewAccount();
		rObj.readObject(customer, customer.getFileloc() + customer.getId());
		//customer = (Customer)readObject;
		
		//ObjectIO object = new ObjectIO();
		//object.readObject(object, "00001");
		
		
		//Customer customer = new Customer();
		

		//customer.loginCustomer();
		
		//Employee employee = new Employee();
		//employee.view_customer(customer);
	
		//Admin admin = new Admin();
		//admin.adminLogin();

	}	
}


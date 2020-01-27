package com.revature.banking.test;

import java.util.Scanner;

public class Admin extends Employee{
	
	static final long serialVersionUID = 1L;
	
	public void adminLogin() {	
		
		Admin admin = new Admin();
		
		try {
			Scanner in = new Scanner(System.in);
			
			String id = null;
			boolean t= false;
			
			while( t == false) {
			System.out.println("Enter your ID number: ");
			id = in.nextLine();
			t= admin.checkNull(id);
			}
			
			String pass= null;
			boolean w = false;
			
			while(w == false) {
				System.out.println("Enter your password: ");
				pass = in.nextLine();
				w= admin.checkNull(pass);
			}
			
			Login check = new Login();
			ObjectIO robj = new ObjectIO();
			admin = (Admin) robj.readObject(admin,admin.getFileloc()+"\\Admin\\"+ id);
			String password = admin.getPassword();
			
					if(check.login(pass, password) == true) {
						System.out.println("Logged in");
						in.close();
						
					}else{
						System.out.println("Failed to log in, try again");
						adminLogin();
						}
					
		}catch (Exception ex) {
			
			System.out.println("Account does not exist");
			adminLogin();
			
		}
	}
	
	public void createEmployee() {
		System.out.println("###########################################################################");
		System.out.println("Create an employee menu");
		
		Employee employee = new Employee();
		ObjectIO wobj =  new ObjectIO();
		
		employee.NewAccount();
		wobj.writeObject(employee,employee.getFileloc()+"\\Employee\\"+employee.getId());
		
	}
	
	public void createAdmin() {
		
		System.out.println("###########################################################################");
		System.out.println("Create an admin menu");
		
		Admin admin = new Admin();
		admin.NewAccount();
		
		ObjectIO wobj = new ObjectIO();
		wobj.writeObject(admin, admin.getFileloc()+ "\\Admin\\"+admin.getId());	
	}
	
	public void viewEmployee() {
		//for future use
	}
	
	public void getCustomer() {
		
		try (Scanner in = new Scanner(System.in)) {
			
			System.out.println("###########################################################################");
			
			ObjectIO objI = new ObjectIO();
			Customer customer = new Customer();
			customer = (Customer)objI.readObject(customer, id);
			
			System.out.println("Enter a (C) to Show Customer menu");
			System.out.println("Enter a (E) to create an employee");
			System.out.println("Enter a (A) to create an admin");
			System.out.println("Enter a (x) to exit");
			
			String w = in.nextLine();
			
			if(w.equalsIgnoreCase("c")) {
				System.out.println("Enter Customer id: ");
				String c = in.nextLine();
				customer = (Customer) objI.readObject(customer, customer.getFileloc()+ c);
				
			}else if(w.equalsIgnoreCase("E")) {
				createEmployee();
				
			}else if(w.equalsIgnoreCase("A")) {
				createAdmin();
				
			}else if (w.equalsIgnoreCase("x")) {
				
			}else {
				System.out.println("Invalid command");
				getCustomer();
			}
			
		}
		
	}
	
	public void customerOptions(Customer customer) {
		
		try (Scanner in = new Scanner(System.in)) {
			
			Employee employee = new Employee();
			employee.view_customer(customer);
			
			System.out.println("Enter (C) to deposit/withdraw/transfer funds");
			System.out.println("Enter (A) to approve the customer account");
			System.out.println("Enter (D) to disable/ enable customer account");
			System.out.println("Enter (X) to exit");
			
			String a = in.nextLine();
			
			if(a != null){
				if(a.equalsIgnoreCase("C")) {
					customer.menu(customer);
					
				}else if(a.equalsIgnoreCase("A")) {
					employee.approve(customer);
					
				}else if (a.equalsIgnoreCase("D")) {
					disableCustomer(customer);
					
				}else if (a.equalsIgnoreCase("x")){
					
				}else {
					
					System.out.println("Invalid command");
					customerOptions(customer);
				}
				
			}else {
				
				System.out.println("Invalid command");
			}
		}
	}
	
	public void disableCustomer(Customer customer) {
		
		try (Scanner in = new Scanner(System.in)) {
			
			if (customer.isDisabled() == true) {
				System.out.println("Do you wish to disable this customer? [Y/N]");
				String c = in.nextLine();
				
				if(c.equalsIgnoreCase("y")) {
					customer.setDisabled(false);
					System.out.println("Customer is disabled");
					
				}else if (c.equalsIgnoreCase("n")) {
					System.out.println("Okay");
					
				}else if (customer.isDisabled() == false) {
					System.out.println("Do you wish to enable this customer? [Y/N]");
					c = in.nextLine();
					
					if(c.equalsIgnoreCase("y")) {
						customer.setDisabled(true);
						System.out.println("Customer is enabled");
					}else if (c.equalsIgnoreCase("n")) {
						System.out.println("Okay");
				}else {
					System.out.println("Invalid command");
					}
				}
			}
		}
	}
}
package com.revature.banking.test;

import java.util.Scanner;

public class Admin extends Employee{

	static final long serialVersionUID = 1L;
	Scanner in = new Scanner(System.in);
	Customer customer = new Customer();
	ObjectIO rObj = new ObjectIO();

	public void adminLogin() {	

		Admin admin = new Admin();

		try {
			String id = null;
			boolean t = false;
			while(t == false) {
				System.out.println("Please enter your ID number!");
				id = in.nextLine();
				t = admin.checkNull(id);
			}

			String pass= null;
			boolean w = false;

			while(w == false) {
				System.out.println("Please enter your password!");
				pass = in.nextLine();
				w= admin.checkNull(pass);
			}

			Login check = new Login();
			ObjectIO robj = new ObjectIO();
			admin = (Admin) robj.readObject(admin, "Banking/Admin/" + id);
			String password = admin.getPassword();

			if(check.login(pass, password) == true) {
				
				System.out.println("Logged in!");
				getCustomer();

			}else{
				
				System.out.println("Cannot log in, try again!");
				adminLogin();
				
				}

		}catch (Exception ex) {

			System.out.println("Account does not exist!");
			adminLogin();

		}
	}
	
	public void createEmployee() {
		//used To create a new employee object
		//Only an admin can use this
		
		System.out.println("\nCreate an employee!");

		Employee employee = new Employee();
		ObjectIO wobj =  new ObjectIO();

		employee.NewAccount();
		wobj.writeObject(employee, "Banking/Employee/" + employee.getId());

	}

	public void createAdmin() {
		//Used to create a new Admin object
		//Only an admin can use this

		System.out.println("\nCreate an admin!");

		Admin admin = new Admin();
		admin.NewAccount();

		ObjectIO wobj = new ObjectIO();
		wobj.writeObject(admin, "Admin/" + admin.getId());	
		
	}

	public void viewEmployee() {
		//for future use
	}

	public void getCustomer() {
		// allows admin to view all cutomer info 
		// and create a new employee / admin account
		System.out.println("Welcome to the Admin menu");
		String w = "";
		try  {
			while(w != "x") {
			System.out.println("Enter a (C) to show customer menu");
			System.out.println("Enter a (E) to create an employee");
			System.out.println("Enter a (A) to create an admin");
			System.out.println("Enter a (x) to exit");

			w = in.nextLine();

			if(w.equalsIgnoreCase("c")) {
				System.out.println("Please enter Customer id!");
				String c = in.nextLine();
				customer = (Customer) rObj.readObject(customer, "Banking/Customer/" + c);
				customerOptions(customer);
				getCustomer();
			}else if(w.equalsIgnoreCase("E")) {
				
				createEmployee();
				getCustomer();

			}else if(w.equalsIgnoreCase("A")) {
				
				createAdmin();
				getCustomer();

			}else if (w.equalsIgnoreCase("x")) {

				Main.menu();

			}else {
				
				System.out.println("Try again buster");
				getCustomer();
				
			}
			}
		}finally {	
		}
	}



	public void customerOptions(Customer customer) {

		try  {

			Employee employee = new Employee();
			employee.view_customer(customer);

			System.out.println("Enter (C) to deposit/withdraw/transfer funds");
			System.out.println("Enter (A) to approve the customer account");
			System.out.println("Enter (D) to disable/enable customer account");
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
					
					System.out.println("Thanks for coming! Have a good day!");
					getCustomer();

				}else {

					System.out.println("Try again buster");
					customerOptions(customer);
					
				}

			}else {

				System.out.println("Try again buster");
				
			}
		}finally {
			
		}
	}

	public void disableCustomer(Customer customer) {

		try  {

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
					
					System.out.println("Try again buster");
					
					}
				}
			}
		}finally {
			
		}
	}
} 
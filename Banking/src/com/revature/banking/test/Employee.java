package com.revature.banking.test;


import java.text.DecimalFormat;
import java.util.Scanner;

public class Employee extends Account {

	// used to display the balance to the second decimal place
	private static DecimalFormat df = new DecimalFormat("0.00");
	private static final long serialVersionUID = 1L;
	private transient Scanner in = new Scanner(System.in);

	public void employeeLogin() {

		Employee employee = new Employee();
		try { 
			String id = null;
			boolean t = false;

			while(t == false) {
				
				System.out.println("Please enter your ID number!");
				id = in.nextLine();
				t = employee.checkNull(id);
			
			}

			String pass = null;
			boolean w = false;

			while(w == false) {
				
				System.out.println("Please enter your password!");
				pass = in.nextLine();
				w = employee.checkNull(pass);
				
			}

			Login check = new Login();
			ObjectIO robj = new ObjectIO();

			employee = (Employee) robj.readObject(employee, "Banking/Employee/" + id);
			String password = employee.getPassword();

			if(check.login(pass, password) == true) {
				// if employee password entered and the one stored match
				// they login and are showed the employee menu
				System.out.println("Logged in!");
				employeeMenu();

			}else {
				// prints out when they employee login == false
				System.out.println("Cannot log in, try again!");
				//recalls the login for the employee to try again
				employeeLogin();
				in.close();

				}
			//employeeMenu();

		}catch (Exception ex) {

			System.out.println("Account does not exist");
			
		}

	}

	public void employeeMenu() {
		//the menu an employee sees when they successful login
		Customer customer = new Customer();

		try {
			String id = null;
			
			System.out.println("Enter Customer ID to view their information");
			id = in.nextLine();

			ObjectIO objI = new ObjectIO();
			customer = (Customer)objI.readObject(customer, "Banking/Customer/" + id);
			String c ="";

			while(c != "e") {

				System.out.println("Enter (V) to view all customer information");
				System.out.println("Enter (A) to Approve the customer account");
				System.out.println("Enter (L) to load another customer");
				System.out.println("Enter (E) to Exit ");
				
				c =in.nextLine().toLowerCase();

				if(c.equalsIgnoreCase("v")) {

					view_customer(customer);

				}else if(c.equalsIgnoreCase("a")) {
					
					approve(customer);

				}else if(c.equalsIgnoreCase("e")) {

					c = "e";
					System.out.println("Thanks for coming! Have a good day!");
					Main.menu();
					
				}else if( c.equalsIgnoreCase("l")) {
					employeeMenu();
				}
				else {

					System.out.println("Try again buster");
					employeeMenu();
				}
			}

			in.close();
		}finally {
			
		}
	}

	public void approve(Customer customer) {
		// allows an employee to approve a customers account application
		if(customer.isApproved()== false) {

			System.out.println("Do you wish to approve the this client? [Y/N]");
			String c = in.nextLine();

			if(c.equalsIgnoreCase("y")) {

				System.out.println("Approved");
				customer.setApproved(true);

				ObjectIO wobj = new ObjectIO();
				wobj.writeObject(customer, "Banking/Customer/" + customer.getId());

			}else {

				System.out.println("Enter anything to load another customer!");
				String d = in.nextLine();

				while(d == null) {
					
					d = in.nextLine();
					
				}
			}
		}
	}

	public void view_customer(Customer customer) {
		// used to see customer information

		System.out.println("Account holder: " + customer.getLast_name() + "," + customer.getFirst_name());
		System.out.println("Holder id : " +customer.getId());
		System.out.println("Holder address : " +customer.getAddress());
		System.out.println("Holder balance : " + df.format(customer.getBalance()));
		System.out.println("Holder additional info : " + customer.getInfo());
		System.out.println("Approved: " + customer.isApproved());
		}	
} 
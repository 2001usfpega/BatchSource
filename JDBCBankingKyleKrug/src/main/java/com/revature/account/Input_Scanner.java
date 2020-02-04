package com.revature.account;
//Created By Kyle Krug
import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.database.DatabaseAccess;

public class Input_Scanner {

	public static Scanner in = new Scanner(System.in);
	public DatabaseAccess db = new DatabaseAccess();
	public Customer customer = new Customer();
	static DecimalFormat df = new DecimalFormat("0.00");

	public void mainMenu() {
		String closer ="";
		while (closer == "") {
			String c = "";
			while( c == "") {
				System.out.println("##########################################################");
				System.out.println("Welcome to the database banking application");
				System.out.println("1.New Customer");
				System.out.println("2.Returning Customer");
				System.out.println("3.Employee Loggin");
				System.out.println("##########################################################");
				c = in.next();
				switch(c) {
				case "1":
					newCustomerCreate();
					break;
				case "2":
					customerLoggin();
					break;
				case "3":
					employeeLoggin();
					break;
				case "closer":
					closer = "a";
					System.out.println("Exiting out of System");
				default:
					break;
				}
			}
		}
	}
	public void newCustomerCreate() {
		System.out.println("Welcome new Customer");
		System.out.println("Please fill out the following to create a new account");
		Customer customer = new Customer();
		customer.newAccount();
		db.newBalance(customer);//creates a new record in balance table and calls method to create a new record in the customer table and then links the two with a foreign key
	}
	public void customerLoggin() {
		String username ="";
		String password ="";
		Customer customer = new Customer();
		while(username== "" ) {
			System.out.println("##########################################################");
			System.out.println("Enter your username: ");
			username = in.next();
		}
		while(password == "") {
			System.out.println("Enter your password: ");
			System.out.println("##########################################################");
			password = in.next();
		}
		customer = db.getCustomer(username, password);
		if(customer.getFirstname() == null) {
			System.out.println("This customer does not exist");
		}else{
			if(customer.isApproved() == true) {
				System.out.println("Logging in ...");
				customerMenu(customer);
			}else {
				System.out.println("This Customer has not been approved");
				System.out.println("Speak to an admin and give them your customer_ id : " +customer.getId());
			}
			
		}
	}
	public void customerMenu(Customer customer) {
		db.updateCustomer(customer);
		System.out.println("##########################################################");
		System.out.println("Welcome back " + customer.getFirstname());
		System.out.println("Balance: $" +df.format(customer.getBalance()));
		System.out.println("Options : ");
		System.out.println("1. View Info");
		System.out.println("2. Make a Deposit");
		System.out.println("3. Make a Withdraw");
		System.out.println("4. Transfer funds to Another Member");
		System.out.println("5. Delete account");
		System.out.println("6. Logout");
		System.out.println("##########################################################");
		String c = in.nextLine();
		switch(c) {
		case "1":
			System.out.println("##########################################################");
			System.out.println(customer.toString());
			System.out.println("##########################################################");
			customerMenu(customer);
			break;
		case "2":
			System.out.println("##########################################################");
			System.out.println("Enter how much you wish to deposit: ");
			double input = in.nextDouble();
			customer.deposit(customer.getBalance(), input);
			System.out.println("##########################################################");
			customerMenu(customer);
			break;
		case "3":
			System.out.println("##########################################################");
			System.out.println("Enter how much you wish to withdraw: ");
			double withdraw = in.nextDouble();
			customer.withdraw(customer.getBalance(), withdraw);
			System.out.println("##########################################################");
			customerMenu(customer);
			break;
		case "4":
			System.out.println("##########################################################");
			System.out.println("Enter the ID of the other member you wish to transfer funds to: ");
			int id = in.nextInt();
			System.out.println("Enter the amount you wish to send: ");
			double amount = in.nextDouble();
			customer.transfer(customer, id, amount);
			System.out.println("##########################################################");
			customerMenu(customer);
			break;
		case "5":
			System.out.println("##########################################################");
			if(customer.getBalance() > 0.0) {
				System.out.println("You must have a balance of $0.00 to delete your account");
				System.out.println("##########################################################");
				customerMenu(customer);
			}else {
				System.out.println("Are you sure you want to delete yout account?[y/n]");
				String delete = in.nextLine();
				if(delete.equalsIgnoreCase("y")) {
					db.deleteCustomer(customer);
					System.out.println("Account deleted");
					System.out.println("##########################################################");
					customerMenu(customer);
				}else{
					System.out.println("##########################################################");
					customerMenu(customer);
				}
			}
		case "6":
			System.out.println("Logging out");
			break;
		default:
			customerMenu(customer);
			break;
		}
		
	}
	public void employeeLoggin() {
		String username ="";
		String password ="";
		Employee employee = new Employee();
		while(username== "" ) {
			System.out.println("Enter your username: ");
			username = in.next();
		}
		while(password == "") {
			System.out.println("Enter your password: ");
			password = in.next();
		}
		employee = db.getEmployee(username,password);
		if(employee.getFirstname() == null) {
			System.out.println("This customer does not exist");
		}else {
			System.out.println("Logging in ...");
			employeeMenu(employee);
		}
	}
	public void employeeMenu(Employee employee) {
		db.updateCustomer(customer);
		System.out.println("##########################################################");
		System.out.println("Welcome back Employee " + employee.getId());
		System.out.println("Loaded customer id is : " + customer.getId());
		System.out.println("1.Load a customer");
		System.out.println("2.View loaded customer");
		System.out.println("3.Approve loaded customer account");
		System.out.println("4.Update loaded customer");
		System.out.println("5.Create a new Customer");
		System.out.println("6.Delete customer");
		System.out.println("7.View accounts awaiting approval");
		System.out.println("8. Logout");
		System.out.println("##########################################################");
		String c = in.next();
		switch(c) {
		case "1":
			System.out.println("##########################################################");
			System.out.println("Enter customer id: ");
			int id = in.nextInt();
			customer = db.employeeGetCustomer(id);
			System.out.println("Customer loaded");
			System.out.println("##########################################################");
			employeeMenu(employee);
			break;
		case "2":
			System.out.println("##########################################################");
			System.out.println(customer.toString());
			System.out.println("##########################################################");
			employeeMenu(employee);
			break;
		case "3":
			System.out.println("##########################################################");
			if(customer.isApproved() == false) {
				customer.setApproved(true);
				System.out.println("Customer is approved");
				System.out.println("##########################################################");
				employeeMenu(employee);
			}else {
				System.out.println("Customer is already approved");
				System.out.println("##########################################################");
				employeeMenu(employee);
			}
			break;
		case"4":
			System.out.println("##########################################################");
			System.out.println("Enter the new values for the current customer info below: ");
			System.out.println("##########################################################");
			customer.newAccount();
			db.updateCustomer(customer);
			System.out.println("##########################################################");
			employeeMenu(employee);
			break;
		case "5":
			System.out.println("##########################################################");
			Customer newCustomer = new Customer();
			db.newBalance(newCustomer);
			System.out.println("##########################################################");
			employeeMenu(employee);
			break;
		case "6":
			System.out.println("##########################################################");
			if(customer.getBalance() > 0.0) {
				System.out.println("They must have a balance of $0.00 to delete your account");
				System.out.println("##########################################################");
				employeeMenu(employee);
			}else {
				System.out.println("Are you sure you want to delete yout account?[y/n]");
				String delete = in.nextLine();
				if(delete.equalsIgnoreCase("y")) {
					db.deleteCustomer(customer);
					System.out.println("Account deleted");
					employeeMenu(employee);
					System.out.println("##########################################################");
					employeeMenu(employee);
				}else{
					System.out.println("##########################################################");
					employeeMenu(employee);
				}
			}
			break;
		case "7":
			System.out.println("##########################################################");
			db.unapprovedAccounts();
			System.out.println("##########################################################");
		case "8":
			System.out.println("Logging out...");
			break;
		default:
			employeeMenu(employee);
			break;
		}
		
}

}

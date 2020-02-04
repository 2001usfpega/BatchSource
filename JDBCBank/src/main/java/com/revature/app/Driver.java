package com.revature.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.Address;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.service.AccountService;
import com.revature.service.AccountServiceImpl;
import com.revature.service.CustomerService;
import com.revature.service.CustomerServiceImpl;
import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImpl;

public class Driver {

	static AccountService as = new AccountServiceImpl();

	static CustomerService cs = new CustomerServiceImpl();
	
	static EmployeeService es = new EmployeeServiceImpl();

	/**
	 * The active customer of the program, only used when a customer has
	 * successfully logged in
	 */
	private static Customer activeCustomer;

	/**
	 * The reference of the active employee
	 */
	private static Employee emp = new Employee();
	

	/**
	 * Holds a list of all approved customers - stored in ApprovedCustomers.txt
	 */
	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	/**
	 * Holds a list of all accounts opened by the users- stored in Accounts.txt
	 */
	// private static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		loadMenu();
	}

	/**
	 * Loads the menu of the banking app and allows the user to log-in or create a
	 * new account.
	 */
	private static void loadMenu() {
		boolean running = true;

		// Constantly loop through until the user exits the system
		while (running) {

			// When a customer has not successfully logged in, load the menu, else
			// process the customer
			if (activeCustomer == null) {
				Scanner scan = new Scanner(System.in);
				System.out.println("1) Returning Customer\n2) New Customer\n3) Exit program");
				System.out.print(">> ");
				int input = scan.nextInt();
				switch (input) {
				case 1:

					// Fires when there is a returning customer
					returningCustomer();
					break;
				case 2:

					// Fires when you want to create a new customer
					createCustomer();
					break;
				case 3:

					// Exits the program
					System.out.println("Thank you for using CJ Banking. We make your financial goals possible");
					running = false;
					scan.close();
					break;
				case 8:

					System.out.println("1) Returning Employee\n2) Returning Admin\n3) Exit program");
					System.out.print(">> ");
					input = scan.nextInt();
					emp = null;
					switch (input) {
					case 1:
						emp = es.login();
						if(emp != null) {
							processEmployee();
						}
						break;
					case 2:
						emp = es.login();
						if(emp != null) {
							processEmployee();
						}
						break;
					case 3:
					}
					// Fires when there is a returning employee.
					// returning employee
					break;
				case 9:

					// Fires when you want to create a new employee in the system
					// create employee
					System.out.println("1) Normal Employee\n2) Admin\n3) Cancel");
					System.out.print(">> ");
					int empInput = scan.nextInt();
					break;
				default:
					// defaults and tells the user to enter a valid number ([1-3] for user, 8 and 9
					// are hidden values only for employees)
					System.out.println("Please enter a valid number [1-3]");
				}
			} else {

				// Only gets called when a customer has successfully logged in
				processCustomer();
			}

		}
	}

	/**
	 * Creates a new customer based on the the different values input by the user.
	 */
	private static void createCustomer() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name");
		String fName = scan.nextLine();

		System.out.println("Enter your last name");
		String lName = scan.nextLine();

		System.out.println("Enter your street address");
		String street = scan.nextLine();

		System.out.println("Enter your city");
		String city = scan.nextLine();

		System.out.println("Enter your state");
		String state = scan.nextLine();

		System.out.println("Enter your zip code");
		String zip = scan.nextLine();

		System.out.println("Enter your phone number");
		String phone = scan.nextLine();

		System.out.println("Enter your email");
		String email = scan.nextLine();

		System.out.println("Enter your username");
		String user = scan.nextLine();

		System.out.println("Enter your password");
		String pass = scan.nextLine();

		// Create the customer object with the given values, the prints it to the
		// PendingCustomers.txt file
		Address address = new Address(street, city, state, zip);
		Customer customer = new Customer(null, user, pass, fName, lName, address, phone, email);
		cs.createCustomer(customer);
		customers.add(customer);
	}

	/**
	 * Runs when there is a returning customer. Tries to allow the user to log in.
	 */
	private static void returningCustomer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your username > ");
		String u = scan.nextLine();
		System.out.println("Please enter your password > ");
		String p = scan.nextLine();
		activeCustomer = cs.logIn(u, p);
	}

	/**
	 * Processes the logged in customer, allows them to check their balance, make a
	 * withdraw, make a deposit, open a new account, and view their accounts
	 */
	private static void processCustomer() {
		Scanner scan = new Scanner(System.in);
		boolean running = true;

		// While running Print out the user menu and allow the customer
		// to perform actions
		if (activeCustomer != null) {
			while (running) {
				System.out.println("What action do you want to perform?\n1) Open an account\n2) "
						+ "Withdraw\n3) Deposit\n4) Delete an account\n5) View accounts\n6) Log out");

				int input = scan.nextInt();
				switch (input) {
				case 1:

					// Allows the customer to open a new account and prints the new account to the
					// Accounts.txt file
					as.createAccount(activeCustomer.getCustomerId());
					activeCustomer.setAccounts(as.fillAllAccounts(activeCustomer.getCustomerId()));
					break;
				case 2:
					// Allows the customer to perform a withdraw
					System.out.println("What account do you want to make a withdraw from?");
					int with = 1;

					// Printing out all open accounts
					for (Account a : activeCustomer.getAccounts()) {
						System.out.println(with + ") " + a.getAccountID());
						with++;
					}

					int accountNum1 = scan.nextInt() - 1;
					Account act1 = activeCustomer.getAccounts().get(accountNum1);
					System.out.println("Enter how much you would like to withdraw ");
					double amount1 = scan.nextDouble();
					as.withdraw(amount1, act1);
					// printAllToFile();
					break;
				case 3:
					// Allows the customer to to make a deposit
					System.out.println("What account do you want to make a deposit?");
					int dep = 1;
					for (Account a : activeCustomer.getAccounts()) {
						System.out.println(dep + ") " + a.getAccountID());
						dep++;
					}
					
					int accountNum2 = scan.nextInt() - 1;
					Account act2 = activeCustomer.getAccounts().get(accountNum2);
					System.out.println("Enter how much you would like to deposit ");
					double amount = scan.nextDouble();
					as.deposit(amount, act2);
					// printAllToFile();
					break;
				case 4:
					System.out.println("What account would you like to delete?");
					int del = 1;
					for (Account a : activeCustomer.getAccounts()) {
						System.out.println(del + ") " + a.getAccountID());
						del++;
					}
					
					int accountNum3 = scan.nextInt() - 1;
					Account act3 = activeCustomer.getAccounts().get(accountNum3);
					cs.deleteOnZeroBalance(act3);
					activeCustomer.setAccounts(as.fillAllAccounts(activeCustomer.getCustomerId()));
					break;
				case 5:
					// Allows the user to view all of their open accounts
					for (Account a : activeCustomer.getAccounts()) {
						System.out.println("Account # " + a.getAccountID() + " Balance " + a.getBalance());
					}
					break;
				case 6:
					// exits from the user menu(log out)
					running = false;
					break;
				default:
					System.out.println("Enter a valid number");
					break;
				}
			}
			activeCustomer = null;
		}
	}

	/**
	 * 
	 */
	private static void processEmployee() {
		Scanner scan = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println(
					"What action do you want to perform?\n1) View Customers\n2) Create new Customer\n3) "
					+ "Update Customers\n4) Delete Customers\n5) Log out");
			int res = scan.nextInt();
			switch (res) {
			case 1:
				for (Customer c : emp.getCustomers()) {
					System.out.println(c.toString());
				}
				break;
			case 2:
				createCustomer();
				emp.setCustomers(es.getAllCustomers());
				break;
			case 3:
				Customer cust = null;
				System.out.println("Which customer would you like to update?");
				int upd = 1;
				for (Customer c : emp.getCustomers()) {
					System.out.println(upd++ + ") " + c.getUsername());
				}
				
				int custToUp = scan.nextInt() -1;
				cust = emp.getCustomers().get(custToUp);
				es.updateCustomer(cust);
				emp.setCustomers(es.getAllCustomers());
				break;
			case 4:
				System.out.println("Which User would you like to remove?");
				int count = 1;
				for(Customer c : emp.getCustomers()) {
					System.out.println(count++ + " " +  c.getfName() + " " + c.getlName());
				}
				
				int custToDel = scan.nextInt() - 1;
				Customer delCust = emp.getCustomers().get(custToDel);
				es.deleteAllAccounts(delCust.getCustomerId());
				es.deleteCustomer(delCust);
				emp.setCustomers(es.getAllCustomers());
				break;
			case 5:
				running = !running;
				break;
			default:
				System.out.println("Enter a valid number");
			}
		}

	}
}

package com.revature.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.revature.account.Account;
import com.revature.user.Address;
import com.revature.user.Customer;
import com.revature.user.Employee;

public class BankDriver {
	
	/**
	 * The active customer of the program, only used when a customer has
	 * successfully logged in
	 */
	private static Customer activeCustomer;
	
	/**
	 * Holds a list of all approved customers - stored in ApprovedCustomers.txt
	 */
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	private static Set<Employee> employees = new TreeSet<Employee>();
	
	/**
	 * Holds a list of all accounts opened by the users- stored in Accounts.txt
	 */
	private static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		fillCustomers();
		fillAccounts();
		addAccounts();
		loadMenu();
	}

	/**
	 * Loads the menu of the banking app and allows the user to log-in or create a
	 * new account.
	 */
	private static void loadMenu() {
		boolean running = true;
		
		//Constantly loop through until the user exits the system
		while (running) {
			
			//When a customer has not successfully logged in, load the menu, else
			//process the customer
			if (activeCustomer == null) {
				Scanner scan = new Scanner(System.in);
				System.out.println("1) Returning Customer\n2) New Customer\n3) Exit program");
				System.out.print(">> ");
				int input = scan.nextInt();
				switch (input) {
				case 1:
					
					//Fires when there is a returning customer
					returningCustomer();
					break;
				case 2:
					
					//Fires when you want to create a new customer
					createCustomer();
					break;
				case 3:
					
					//Exits the program
					System.out.println("Thank you for using CJ Banking. We make your financial goals possible");
					running = false;
					scan.close();
					break;
				case 8:
					
					//Fires when there is a returning employee
					// returning employee
					break;
				case 9:
					
					//Fires when you want to create a new employee in the system
					// create employee
					System.out.println("1) Normal Employee\n2) Admin\n3) Cancel");
					System.out.print(">> ");
					int empInput = scan.nextInt();
					break;
				default:
					//defaults and tells the user to enter a valid number ([1-3] for user, 8 and 9
					//are hidden values only for employees)
					System.out.println("Please enter a valid number [1-3]");
				}
			} else {
				
				//Only gets called when a customer has successfully logged in
				processCustomer();
			}

		}
	}
	
	/**
	 * Creates a new customer based on the the different values input
	 * by the user.
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
		
		//Create the customer object with the given values, the prints it to the PendingCustomers.txt file
		Address address = new Address(street, city, state, zip);
		Customer customer = new Customer(user, pass, fName, lName, address, phone, email);
		customer.printToFile();
	}
	
	/**
	 * Runs when there is a returning customer. Tries to allow the user to log in.
	 */
	private static void returningCustomer() {
		Scanner scan = new Scanner(System.in);
		Customer customer = null;
		boolean running = true;
		String user = "";
		
		//Loop through allowing the user to input usernames indefinitely, or until 
		//they enter exit
		while (running || user.equals("exit")) {
			System.out.println("Enter your username or exit to quit");
			user = scan.nextLine();
			for (Customer c : customers) {
				
				//loops through every customer in the system to see if the entered username is valid
				//If valid grab that customer object and break out of the first loop
				if (user.equals(c.getUsername())) {
					running = false;
					customer = c;
					break;
				}
			}
			
			//Means that an invalid username has been entered
			if (running) {
				System.out.println("Invalid Username");
			}
		}
		running = !running;
		int count = 0;
		
		//After a valid username was entered the customer has three attempts to enter the password associated
		//with that account
		while (running && count < 3) {
			System.out.println("Enter your password");
			String pass = scan.nextLine();
			
			//Checks if the the password enters is the correct password. If so,
			//make the active customer the one who just logged in and break out of the loop
			if (pass.equals(customer.getPassword())) {
				running = false;
				activeCustomer = customer;
				break;
			}
			//If the  password is invalid, increment the counter and continue
			if (running) {
				System.out.println("Invalid password");
				count++;
			}
		}
	}
	
	/**
	 * Processes the logged in customer, allows them to check their balance, make a withdraw,
	 * make a deposit, open a new account, and view their accounts 
	 */
	private static void processCustomer() {
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		//While running Print out the user menu and allow the customer 
		//to perform actions
		while (running) {
			System.out.println("What action do you want to perform?\n1) Open an account\n2) "
					+ "Withdraw\n3) Deposit\n4) View accounts\n5) Log out");

			int input = scan.nextInt();
			switch (input) {
			case 1:
				
				//Allows the customer to open a new account and prints the new account to the 
				//Accounts.txt file
				Account account = new Account(activeCustomer.getUsername());
				System.out.println(account.getAccountNumber());
				activeCustomer.getAccounts().add(account);
				account.printToFile();
				break;
			case 2:
				//Allows the customer to perform a withdraw 
				break;
			case 3:
				//Allows the  customer to to make a deposit 
				break;
			case 4:
				//Allows the user to view all of their open accounts
				for(Account a : activeCustomer.getAccounts()) {
					System.out.println(a.getAccountNumber());
				}
			case 5:
				//exits from the user menu(log out)
				running = false;
				break;
			default:
				System.out.println("Enter a valid number");
				break;
			}
		}
		activeCustomer = null;
	}
	
	/**
	 * Reads from the ApprovedCustomers.txt file and populates the customers list from the file.
	 */
	private static void fillCustomers() {
		activeCustomer = null;
		File file = new File(".\\.\\ApprovedCustomers.txt");
		Scanner start;
		try {
			
			//Reads the file line by line and splits the input.
			//Since we control how the file is formatted, we can hard code how to read
			//from it
			start = new Scanner(file);
			while (start.hasNext()) {
				String cust = start.nextLine();
				String[] custValues = cust.split(":");

				String fName = custValues[0];
				String lName = custValues[1];
				String street = custValues[2];
				String city = custValues[3];
				String state = custValues[4];
				String zip = custValues[5];
				String phone = custValues[6];
				String email = custValues[7];
				String user = custValues[8];
				String pass = custValues[9];
				Address address = new Address(street, city, state, zip);
				Customer customer = new Customer(user, pass, fName, lName, address, phone, email);
				customers.add(customer);

			}
			start.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}

	}
	
	/**
	 * Fills all of the accounts to a list from the Accounts.txt file.
	 */
	private static void fillAccounts() {
		File file = new File("Accounts.txt");
		try {
			
			//Goes the the Accounts.txt file and just like in the customers, the file will always
			//be formatted exactly how we want it and we can hard code how to read from it.
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String act = scan.nextLine();
				String[] actList = act.split(":");
				String userID = actList[0];
				String  accountID = actList[1];
				double balance = Double.parseDouble(actList[2]);
				Account account = new Account(userID,accountID, balance);
				accounts.add(account);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 *Takes all of the accounts from the list and adds them to the users list of accounts
	 *based on the userID of both the customer and the Account
	 */
	private static void addAccounts() {
		for(Account a : accounts) {
			
			//For each account, check if the userID of the account is equal to the username of the 
			//customer. If so, add that account to the customers accounts and continue through the loop.
			String userID = a.getUserID();
			for(Customer c : customers) {
				if(c.getUsername().equals(userID)) {
					c.addAccount(a);
				}
			}
		}
	}
}

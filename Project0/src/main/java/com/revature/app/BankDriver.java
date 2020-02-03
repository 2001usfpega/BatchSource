package com.revature.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.user.Address;
import com.revature.user.Admin;
import com.revature.user.Customer;
import com.revature.user.Employee;

public class BankDriver {

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
	 * The location of the customer file
	 */
	private static final String CUST_FILE = "ApprovedCustomers.txt";

	/**
	 * Holds a list of all approved customers - stored in ApprovedCustomers.txt
	 */
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	/**
	 * The refence of the current admin
	 */
	private static Admin ad = new Admin(customers);

	/**
	 * Holds a list of all accounts opened by the users- stored in Accounts.txt
	 */
	// private static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		readFromFile();
		loadMenu();
		printAllToFile();
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
					switch (input) {
					case 1:
						processJared();
						break;
					case 2:
						processAdmin();
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
		Customer customer = new Customer(user, pass, fName, lName, address, phone, email);
		customers.add(customer);
		System.out.println(customer.toString());
	}

	/**
	 * Runs when there is a returning customer. Tries to allow the user to log in.
	 */
	private static void returningCustomer() {
		Scanner scan = new Scanner(System.in);
		Customer customer = null;
		boolean running = true;
		String user = "";

		// Loop through allowing the user to input usernames indefinitely, or until
		// they enter exit
		while (running) {
			System.out.println("Enter your username or exit to quit");
			user = scan.nextLine();
			for (Customer c : customers) {

				// loops through every customer in the system to see if the entered username is
				// valid
				// If valid grab that customer object and break out of the first loop
				if (user.equals(c.getUsername())) {
					running = false;
					customer = c;
					break;
				}
				if (user.equals("exit")) {
					running = false;
					break;
				}
			}

			// Means that an invalid username has been entered
			if (running) {
				System.out.println("Invalid Username");
			}
		}

		running = !running;
		int count = 0;

		// After a valid username was entered the customer has three attempts to enter
		// the password associated
		// with that account
		if (!user.equals("exit")) {
			while (running && count < 3) {
				System.out.println("Enter your password");
				String pass = scan.nextLine();

				// Checks if the the password enters is the correct password. If so,
				// make the active customer the one who just logged in and break out of the loop
				if (pass.equals(customer.getPassword())) {
					running = false;
					activeCustomer = customer;
					break;
				}
				// If the password is invalid, increment the counter and continue
				if (running) {
					System.out.println("Invalid password");
					count++;
				}
			}
		}
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
		while (running) {
			System.out.println("What action do you want to perform?\n1) Open an account\n2) "
					+ "Withdraw\n3) Deposit\n4) View accounts\n5) Log out");

			int input = scan.nextInt();
			switch (input) {
			case 1:

				// Allows the customer to open a new account and prints the new account to the
				// Accounts.txt file
				Account account = new Account(activeCustomer.getUsername());
				System.out.println(account.getAccountNumber());
				activeCustomer.getAccounts().add(account);
				break;
			case 2:
				// Allows the customer to perform a withdraw
				System.out.println("What account do you want to make a withdraw from?");
				int with = 1;
				
				//Printing out all open accounts
				for (Account a : activeCustomer.getAccounts()) {
					System.out.println(with + ") " + a.getAccountNumber());
					with++;
				}
				
				int accountNum1 = scan.nextInt() - 1;
				Account act1 = activeCustomer.getAccounts().get(accountNum1);
				System.out.println("Enter how much you would like to withdraw ");
				double amount1 = scan.nextDouble();
				act1.withdraw(amount1);
				printAllToFile();
				break;
			case 3:
				// Allows the customer to to make a deposit
				System.out.println("What account do you want to make a deposit?");
				int dep = 1;
				for (Account a : activeCustomer.getAccounts()) {
					System.out.println(dep + ") " + a.getAccountNumber());
					dep++;
				}
				int accountNum2 = scan.nextInt() - 1;
				Account act2 = activeCustomer.getAccounts().get(accountNum2);
				System.out.println("Enter how much you would like to deposit ");
				double amount = scan.nextDouble();
				act2.deposit(amount);
				printAllToFile();
				break;
			case 4:
				// Allows the user to view all of their open accounts
				for (Account a : activeCustomer.getAccounts()) {
					System.out.println("Account # " + a.getAccountNumber() + " Balance " + a.getBalance());
				}
				break;
			case 5:
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
	
	/**
	 * 
	 */
	private static void processJared() {
		// emp = new Employee("Jred","a","Jared","McGillicudy",new Address("Foxy Lane",
		// "Hammertown","NE","75748"),"8008675309","gilliboi@yahoo.com", customers);
		Scanner scan = new Scanner(System.in);
		boolean running = true;

		// While running Print out the user menu and allow the customer
		// to perform actions
		while (running) {
			System.out.println(
					"What action do you want to perform?\n1) View customers\n2) View all accounts\n3) Log out");
			int res = scan.nextInt();
			switch (res) {
			case 1:
				for (Customer c : emp.getCustomers()) {
					System.out.print(c.toString());
				}
				break;
			case 2:
				ArrayList<Customer> cust = emp.getCustomers();
				for (int i = 0; i < cust.size(); i++) {
					for (Account a : cust.get(i).getAccounts()) {
						System.out.println("UserID >> " + a.getUserID() + " Account # >> " + a.getAccountNumber()
								+ " Balance >> " + a.getBalance());
					}
				}
				break;
			case 3:
				running = !running;
				break;
			default:
				System.out.println("Enter a valid number");
			}
		}

	}

	/**
	 * 
	 */
	private static void processAdmin() {
		Scanner scan = new Scanner(System.in);
		boolean running = true;

		// While running Print out the user menu and allow the customer
		// to perform actions
		while (running) {
			System.out.println(
					"What action do you want to perform?\n1) View customers\n2) View all accounts\n3) Remove Account\n"
							+ "4) Commit Treason\n5) Execute operation Sad Badger\n6) Declare bankruptcy\n"
							+ "7) Fire Matt\n8) Money Laundering?\n9) Log out");
			int res = scan.nextInt();
			switch (res) {
			case 1:
				for (Customer c : ad.getCustomers()) {
					System.out.print(c.toString());
				}
				break;
			case 2:
				ArrayList<Customer> cust = ad.getCustomers();
				for (int i = 0; i < cust.size(); i++) {
					for (Account a : cust.get(i).getAccounts()) {
						System.out.println("UserID >> " + a.getUserID() + " Account # >> " + a.getAccountNumber()
								+ " Balance >> " + a.getBalance());
					}
				}
				break;
			case 3:
				ad.cancelAccount();
				customers = ad.getCustomers();
				printAllToFile();
				break;
				
			//All of these cases are joke cases, have no implementation only print statements.
			case 4:
				System.out.println("You are now committing treason...");
				break;
			case 5:
				System.out.println("The D.E.N. is active.");
				break;
			case 6:
				System.out.println("Yeah... we broke");
				break;
			case 7:
				System.out.println("Why are you leaving us Matt!?");
				break;
			case 8:
				System.out.println("You realize this is illegal, right?");
				break;
			case 9:
				running = !running;
				break;
			default:
				System.out.println("Enter a valid number");
			}
		}

	}

	/**
	 * Reads from the ApprovedCustomers.txt file and populates the customers list
	 * from the file.
	 */
	@SuppressWarnings("unchecked")
	private static void readFromFile() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(CUST_FILE));
			customers = (ArrayList<Customer>) ois.readObject();
			ois.close();
			ois = new ObjectInputStream(new FileInputStream("Employee.txt"));
			emp = (Employee) ois.readObject();
			ois.close();
			ois = new ObjectInputStream(new FileInputStream("Admin.txt"));
			ad = (Admin) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints all of the serialized objects to the file. Only customers due to time limitations.
	 */
	private static void printAllToFile() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(CUST_FILE));
			oos.writeObject(customers);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

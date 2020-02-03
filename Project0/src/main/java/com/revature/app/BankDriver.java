package com.revature.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.dao.CustDaoImpl;
import com.revature.model.Accounts;
import com.revature.model.CustomerInfo;
import com.revature.user.Address;
import com.revature.user.Admin;
import com.revature.user.Customer;
import com.revature.user.Employee;

public class BankDriver {

	/**
	 * The active customer of the program, only used when a customer has
	 * successfully logged in
	 */
	private static CustomerInfo activeCustomer;

	private static Employee emp = new Employee();

	private static final String CUST_FILE = "ApprovedCustomers.txt";

	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("PROJECT_0_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

	/**
	 * Holds a list of all approved customers - stored in ApprovedCustomers.txt
	 */
	private static ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();

	/**
	 * Holds a list of all accounts opened by the users- stored in Accounts.txt
	 */
	// private static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		loadMenu();
	}

	public static List<CustomerInfo> selectAllCusts() {
		List<CustomerInfo> custs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM customer";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				custs.add(new CustomerInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custs;
	}

	public static void prepStateCust(String user, String pass, String fname, String lname, String address, String city,
			String state, String zipcode, String phone, String email) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "INSERT INTO customer(customerid, username, password, fname, lname, address, city, state, zipcode, phone, email) VALUES(null,?,?,?,?,?,?,?,?,?,?)";
																																											
			PreparedStatement ps = conn.prepareStatement(sql);
			// first question mark
			ps.setString(1, user); // second question mark
			ps.setString(2, pass);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, address);
			ps.setString(6, city);
			ps.setString(7, state);
			ps.setString(8, zipcode);
			ps.setString(9, phone);
			ps.setString(10, email);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Accounts> selectAllAccts() {
		List<Accounts> accts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM accounts";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				accts.add(new Accounts(rs.getInt(1), rs.getString(2), rs.getInt(3)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accts;
	}

	public static void prepStateAcct(int customerid) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "INSERT INTO accounts(accountid, customerid, balance) VALUES(null,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			// first question mark
			ps.setInt(1, customerid);
			ps.setInt(2, 0);
			

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void userLogin(String user, String pass) {
		String password2 ="";
		String username2 ="";
		try(Connection conn = DriverManager.getConnection(url, username, password)){
						
			 String sql= "SELECT * FROM customer WHERE username = '" + user + "'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				activeCustomer = new CustomerInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11));
				
				password2 = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try(Connection conn2 = DriverManager.getConnection(url, username, password)){
//			
//			 String sql2= "SELECT username FROM customer WHERE customerid=" + customerid;
//			
//			PreparedStatement ps2 = conn2.prepareStatement(sql2);
//			ResultSet rs2 = ps2.executeQuery();
//
//			while (rs2.next()) {
//				password2 = rs2.getString("password");
//			}	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		if (pass == activeCustomer.getPassword()) {
			processCustomer();
		}
			
	}
	public static List<Accounts> fillAll(int customerid) {
		List<Accounts> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
						
			 String sql= "SELECT * FROM accounts WHERE customerid = '" + customerid + "'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				accounts.add(new Accounts(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
				
				customerid = rs.getInt("customerid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
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
						// processAdmin();
						break;
					case 3:
					}
					// Fires when there is a returning employee
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
		System.out.println("Enter your username");
		String user = scan.nextLine();

		System.out.println("Enter your password");
		String pass = scan.nextLine();

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

		// Create the customer object with the given values, the prints it to the
		// PendingCustomers.txt file
		prepStateCust(user, pass, fName, lName, street, city, state, zip, phone, email);

	}

	/**
	 * Runs when there is a returning customer. Tries to allow the user to log in.
	 */
	private static void returningCustomer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String user = scan.nextLine();
		System.out.println("Enter your password");
		String pass = scan.nextLine();
		loggingOn(user,pass);
	}

	private static void loggingOn(String user, String pass) {
		userLogin(user, pass);
	}
	
	
	public static void createAccnt(int customerid){
		prepStateAcct(customerid);
	}
	
	public static void setAccnt(List<Accounts> accounts) {

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
			scan.nextLine();
			switch (input) {
			case 1:

				// Allows the customer to open a new account and prints the new account to the
				// Accounts.txt file
						createAccnt(activeCustomer.getCustomerid());
						activeCustomer.setAccnt(fillAll(activeCustomer.getCustomerid()));
				
				
				break;
//			case 2:
//				// Allows the customer to perform a withdraw
//				System.out.println("What account do you want to make a withdraw from?");
//				int with = 1;
//				for (Accounts a : activeCustomer.getAccounts()) {
//					System.out.println(with + ") " + a.getAccountid());
//					with++;
//				}
//				int accountNum1 = scan.nextInt() - 1;
//				Accounts act1 = activeCustomer.getAccounts().get(accountNum1);
//				System.out.println("Enter how much you would like to withdraw ");
//				double amount1 = scan.nextDouble();
//				act1.withdraw(amount1);
//				//printAllToFile();
//				break;
//			case 3:
//				// Allows the customer to to make a deposit
//				System.out.println("What account do you want to make a deposit?");
//				int dep = 1;
//				for (Accounts a : activeCustomer.getAccounts()) {
//					System.out.println(dep + ") " + a.getAccountid());
//					dep++;
//				}
//				int accountNum2 = scan.nextInt() - 1;
//				Accounts act2 = activeCustomer.getAccounts().get(accountNum2);
//				System.out.println("Enter how much you would like to deposit ");
//				double amount = scan.nextDouble();
//				act2.deposit(amount);
//				//printAllToFile();
//				break;
			case 4:
				// Allows the user to view all of their open accounts
				for (Accounts a : activeCustomer.getAccounts()) {
					System.out.println("Account # " + a.getAccountid() + " Balance " + a.getBal());
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
}
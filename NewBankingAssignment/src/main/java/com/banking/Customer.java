package com.banking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer implements UserInterface {

	private String customerID;
	private String userName;
	private String password;
	private String fname;
	private String lname;
	private String email;

	private Account account;

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID2) {
		this.customerID = customerID2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void withdraw(double balance) {

		Scanner withScanner = new Scanner(System.in);

		System.out.println("Enter Customer ID: ");
		String customerID = withScanner.next();
		System.out.println("Enter Password: ");
		String Passwords = withScanner.next();
		System.out.println("Enter Withdrawl Amount: ");
		double withdrawalamt = withScanner.nextDouble();

		if (withdrawalamt > 0) {

			setCustomerID(customerID);

			Withdrawlconn(customerID, Passwords, withdrawalamt);
			System.out.println();
			Driver.main(null);
		} else {

			System.out.println("Enter a Valid Amount to Withdrawl");

			System.out.println();
			Driver.main(null);

		}

	}

	@Override
	public void deposit(double balance) {
		{

			Scanner depScanner = new Scanner(System.in);

			System.out.println("Enter Customer ID: ");
			String customerID = depScanner.next();
			System.out.println("Enter Password: ");
			String Passwords = depScanner.next();
			System.out.println("Enter Deposit Amount: ");
			double depositamt = depScanner.nextDouble();

			setCustomerID(customerID);

			Depositconn(customerID, Passwords, depositamt);

			System.out.println();
			Driver.main(null);

		}

	}

	@Override
	public void getBalance() {

		Scanner balanceScanner = new Scanner(System.in);

		System.out.println("Enter Customer ID: ");
		String customerID = balanceScanner.next();
		System.out.println("Enter Password: ");
		String Passwords = balanceScanner.next();

		getBalanceConn(customerID, Passwords);

		System.out.println();
		Driver.main(null);

	}

	@Override
	public void getAccount() {

	}
	
	@Override
	public void deleteaccount() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createCustomer() {

		Scanner accountScanner = new Scanner(System.in);

		System.out.println("Enter First Name: ");
		String fname = accountScanner.next();

		System.out.println("Enter Last Name: ");
		String lname = accountScanner.next();

		System.out.println("Enter Email: ");
		String email = accountScanner.next();

		System.out.println("Create a CustomerId: ");
		String customerID = accountScanner.next();

		System.out.println("Create a Password: ");
		String password = accountScanner.next();

		setCustomerID(customerID);
		setPassword(password);
		setFname(fname);
		setLname(lname);
		setEmail(email);

		// accountScanner.close();
		accountCreateStatement(customerID, password, fname, lname, email);
		
		System.out.println();

		System.out.println(fname + " " + lname + " Your Account has been created.");

		System.out.println();
		Driver.main(null);
	}

	@Override
	public void viewAccount() {
		// TODO Auto-generated method stub

	}

	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("BANKING_DB_USERNAME");
	private static String DBpassword = System.getenv("TRAINING_DB_PASSWORD");

	// Prepared statement example
	public static void accountCreateStatement(String customerID, String password, String fname,
			String lname, String email) {
		try (Connection conn = DriverManager.getConnection(url, username, DBpassword)) {
			String sql = "INSERT INTO customer(customer_id, passwords, fname, lname, email) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customerID);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);

			ps.executeUpdate();

		} catch (SQLException e) {
			
			System.out.println();
			System.out.println("ACCOUNT FAILURE: That Account ID is already in use; Please try again!");
			Driver.main(null);
			
			

		}

	}

	public static void getBalanceConn(String customerID, String Passwords) {

		try (Connection conn = DriverManager.getConnection(url, username, DBpassword)) {
			String sql = "SELECT balance FROM accounts a INNER JOIN customer b ON b.customer_id = a.fk_customer_id WHERE a.fk_customer_id ="
					+ "'" + customerID + "'" + "AND b.passwords=" + "'" + Passwords + "'";
			PreparedStatement prepstate = conn.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {
				double balance = rset.getDouble("balance");
				System.out.println("Balance: $" + balance);

			}

			prepstate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static void Depositconn(String customerID, String Passwords, double depositamt) {

		double balance = 0;

		try (Connection conn = DriverManager.getConnection(url, username, DBpassword)) {
			String sql = "SELECT balance FROM accounts a INNER JOIN customer b ON b.customer_id = a.fk_customer_id WHERE a.fk_customer_id ="
					+ "'" + customerID + "'" + "AND b.passwords=" + "'" + Passwords + "'";
			PreparedStatement prepstate = conn.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {
				balance = rset.getDouble("balance");
				System.out.println("Balance Before Deposit: $" + balance);

			}

			prepstate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		if (depositamt > 0) {

			balance += depositamt;

			try (Connection Updateconn = DriverManager.getConnection(url, username, DBpassword)) {
				String sql2 = "UPDATE accounts SET balance=" + balance + "WHERE fk_customer_id=" + "'" + customerID
						+ "'";
				PreparedStatement prepstate = Updateconn.prepareStatement(sql2);
				double changedBalance = prepstate.executeUpdate();
				System.out.println("Your New Balance: $" + balance);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			System.out.println();
			System.out.println("INVLAID ENTRY");
			

		}

	}

	public static void Withdrawlconn(String customerID, String Passwords, double withdrawalamt) {

		double balance = 0;

		try (Connection conn = DriverManager.getConnection(url, username, DBpassword)) {
			String sql = "SELECT balance FROM accounts a INNER JOIN customer b ON b.customer_id = a.fk_customer_id WHERE a.fk_customer_id ="
					+ "'" + customerID + "'" + "AND b.passwords=" + "'" + Passwords + "'";
			PreparedStatement prepstate = conn.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {
				balance = rset.getDouble("balance");
				System.out.println("Previous Balance: $" + balance);

			}

			prepstate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (withdrawalamt < balance) {
			balance -= withdrawalamt;

			try (Connection Updateconn = DriverManager.getConnection(url, username, DBpassword)) {
				String sql2 = "UPDATE accounts SET balance=" + balance + "WHERE fk_customer_id=" + "'" + customerID
						+ "'";
				PreparedStatement prepstate = Updateconn.prepareStatement(sql2);
				double changedBalance = prepstate.executeUpdate();
				System.out.println("Balance after Withdrawl: $" + balance);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			System.out.println("");
			System.out.println("Withdrawl amount exceedes account balance!");

		}

	}

	@Override
	public void verifyEmployee() {
		// TODO Auto-generated method stub

	}



}

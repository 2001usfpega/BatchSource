package com.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee implements UserInterface {

	private String empID;
	private String empUsername;
	private String empPassword;

	private Account account;

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public void getAccount() {
		// TODO Auto-generated method stub

	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void withdraw(double balance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deposit(double balance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getBalance() {

		// TODO Auto-generated method stub

	}

	@Override
	public void createCustomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewAccount() {

		Scanner balanceScanner = new Scanner(System.in);

		System.out.println("Enter Customer ID: ");
		String customerID = balanceScanner.next();

		getAccountsConn(customerID);

		System.out.println();
		Driver.main(null);

	}

	@Override
	public void verifyEmployee() {

		Scanner verifyScanner = new Scanner(System.in);

		System.out.println("Enter Employee Username: ");
		String employeeUN = verifyScanner.next();
		System.out.println("Enter Password: ");
		String Passwords = verifyScanner.next();

		verifyConn(employeeUN, Passwords);

	}

	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("BANKING_DB_USERNAME");
	private static String DBpassword = System.getenv("TRAINING_DB_PASSWORD");

	public static void getAccountsConn(String customerID) {

		try (Connection conn = DriverManager.getConnection(url, username, DBpassword)) {
			String sql = "SELECT * FROM customer a INNER JOIN accounts b ON a.customer_id = b.fk_customer_id WHERE b.fk_customer_id="
					+ "'" + customerID + "'";
			PreparedStatement prepstate = conn.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {
				String customerid = rset.getString("customer_id");
				int accountid = rset.getInt("acct_id");
				String customerFName = rset.getString("fname");
				String customerLName = rset.getString("lname");
				double customerBalance = rset.getDouble("balance");

				System.out.println("UserID: " + customerid + "\nAccount Number: " + accountid
						+ "\nCustomer First Name: " + customerFName + "\nCustomer Last Name: " + customerLName
						+ "\nBalance:  $" + customerBalance);

			}

			prepstate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static void verifyConn(String employeeUN, String passwords) {

		try (Connection conn = DriverManager.getConnection(url, username, DBpassword)) {
			String sql = "SELECT * FROM employee WHERE emp_username =" + "'" + employeeUN + "'" + "AND emp_passwords="
					+ "'" + passwords + "'";
			PreparedStatement prepstate = conn.prepareStatement(sql);
			ResultSet rset = prepstate.executeQuery();
			while (rset.next()) {

				System.out.println("Welcome: " + employeeUN);

			}

			prepstate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}



}

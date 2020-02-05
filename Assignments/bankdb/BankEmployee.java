package com.kaelin.bankdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankEmployee extends Main {
	private static String url = System.getenv("Bankdb_url");
	private static String username = System.getenv("Bankdb_user");
	private static String password = System.getenv("Bankdb_pass");

	private static String user;
	private static String pass;

	static Scanner log = new Scanner(System.in);

	public static void emp_login(String user, String pass) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "SELECT * FROM bank_employee WHERE employee_passwd = '" + pass + "'";
		PreparedStatement employee = conn.prepareStatement(sql);
		ResultSet rs = employee.executeQuery();
		// newEmployee(user, pass);
		if (rs.next()) {
			user = rs.getString(2);
			pass = rs.getString(3);
			System.out.println("Login Successful");
			System.out.println("Hello " + user);
			System.out.println("Your ID is " + pass);
			char log3 = 0;
			System.out.println("Please press 1 then enter");
			do {
				

				char log2 = log.next().charAt(0);

				switch (log2) {
				case '1':
					System.out.println("===============================");
					System.out.println("1.What would you like to do?");
					System.out.println("2.View customer");
					System.out.println("3.Create Customer");
					System.out.println("4.Update customer");
					System.out.println("5.Delete customer");
				break;
				case'2':

				}

			} while (log3 != '5');
		} else {
			System.out.println("Login Unsuccessful. Please try again.");
			dispose();
		}
	}

	private static void dispose() {
		// TODO Auto-generated method stub

	}

	public static void Menu2() {

	}

}

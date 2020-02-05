package com.kaelin.bankdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class BankEmployee extends Main{
	private static String url = System.getenv("Bankdb_url");
	private static String username = System.getenv("Bankdb_user");
	private static String password = System.getenv("Bankdb_pass");
	
	private static String user;
	private static String pass;
	
	static Scanner input = new Scanner(System.in);

	public static void emp_login(String user, String pass) throws SQLException {
		Connection conn=DriverManager.getConnection(url,username,password);
		String sql = "SELECT * FROM bank_employee WHERE employee_passwd = '"+ pass +"'";
		PreparedStatement employee = conn.prepareStatement(sql);
		ResultSet rs = employee.executeQuery();
		//newEmployee(user, pass);
		if(rs.next()){
			user = rs.getString(2);
			pass = rs.getString(3);
		System.out.println("Login Successful");
		System.out.println("Hello " + user);
		System.out.println("Your ID is "+ pass);
		int input = 1;
		switch(input) {
		case'1':
			System.out.println("===============================");
			System.out.println("What would you like to do?");
			System.out.println();
		}
		}else {
			System.out.println("Login Unsuccessful. Please try again.");
			dispose();
		}	
	}private static void dispose() {
		// TODO Auto-generated method stub
		
	}
	public static void Menu2() {
		
		
			
		
		}
		
	}

	
	


package com.kaelin.bankdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private static String url = System.getenv("Bankdb_url");
	private static String username = System.getenv("Bankdb_user");
	private static String password = System.getenv("Bankdb_pass");
	

	public static void newCustomer(String cust_user, String cust_passwd) {
		try(Connection conn=DriverManager.getConnection(url,username,password)){
			String sql = "INSERT INTO bank_customer(cust_user, cust_passwd) VALUES (?,?)";
			PreparedStatement cust = conn.prepareStatement(sql);
			cust.setString(1, cust_user);
			cust.setString(2, cust_passwd);
			
			cust.executeUpdate();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void newEmployee(String employee_user, String employee_passwd) {		
			try(Connection conn=DriverManager.getConnection(url,username,password)){
			String sql = "INSERT INTO bank_customer(cust_user, cust_passwd) VALUES (?,?)";
			PreparedStatement empl = conn.prepareStatement(sql);			
			empl.setString(1, employee_user);
			empl.setString(2, employee_passwd);
			
			empl.executeUpdate();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String [] AHHHHHH) throws SQLException {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number ");
		MainMenu act = new MainMenu();
		act.Menu();
		//int c = input.nextInt();
		System.out.println("value = " + input);
		char c = input.next().charAt(0);
		System.out.println("Value = " +input);
		input.close();
//		System.out.println(url);
//		System.out.println(password);
//		System.out.println(username);
	}
	
}

package com.example.dbservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Account;
import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConnectingServlet extends HttpServlet{
	public static final String url = System.getenv("TRAINING_DB_URL");

	public static final String username = System.getenv("TRAINING_DB_USERNAME");

	public static final String password = System.getenv("TRAINING_DB_PASSWORD");

	private static String user;
	private static String pass;

	static Scanner log = new Scanner(System.in);

	public static void emp_login(String user, String pass) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		String cust = "SELECT * FROM bank_employee WHERE employee_passwd = '" + pass + "'";
		PreparedStatement employee = conn.prepareStatement(cust);
		ResultSet rs = employee.executeQuery();
}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
		{
			System.out.println("Indirect doPost");
			
			res.setContentType("application/json");
			
			Account asura = getAccountsByID(10).get(0);
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(asura));
			
			
		}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
		{
			System.out.println("Indirect doPost");
			
			res.setContentType("application/json");
			Account asura = new Account(10,10,10);
			
			//Account asura = getAccountsByID(10).get(0);
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(asura));
			
			
		}
	
	public List<Account> getAccountsByID(int customerID) {
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM accounts WHERE customerid = " + customerID;

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	
	
}


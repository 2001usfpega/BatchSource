package com.servlets.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MightWork extends HttpServlet {
	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("TRAINING_DB_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");
	
	
	
	//@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res)
//	throws ServletException, IOException
//	{
//		System.out.println("In Direct doGet!!");
//		
//		res.setContentType("text/html");
//		//Print writer is responsible for directly responding to the client
//		PrintWriter out = res.getWriter();
//		out.println("<html><body><h1>The Servlet is directly talking to the"+" client!</h1></body></html>");
//	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		System.out.println("In Direct doPost!!!");
		Customer asura = getCustomer("jacob");
		res.setContentType("application/json");
		ObjectMapper obj= new ObjectMapper();
		String jsonString = obj.writeValueAsString(asura);
		
		res.getWriter().write(jsonString);
		}
	
	public static Customer getCustomer(String a) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM customer WHERE username = '" + a + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	

}

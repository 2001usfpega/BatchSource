package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.SuperVillain;


@SuppressWarnings("serial")
public class DirectServlet extends HttpServlet{
//	private static final long serialVersionUID = -4109236571491620947L;

	private static String url= System.getenv("TRAINING_DB_URL");
	private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException
		{
			System.out.println("go get");
			
			res.setContentType("text/html");
			
			PrintWriter out = res.getWriter();
			out.println("<html><body><h1>thist gasdfsad</h1></body></html>");
			
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{		
		System.out.println("go post");
		
		res.setContentType("application/json");
		
		SuperVillain asura = new SuperVillain("asura","hair",10_000); 
		
		

		//List<Customer> users = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE rank=0";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				res.getWriter().write(new ObjectMapper().writeValueAsString(new SuperVillain( rs.getString(2), rs.getString(3),rs.getInt(1))));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//return users;
		
		
		
	}
	
	
	
}

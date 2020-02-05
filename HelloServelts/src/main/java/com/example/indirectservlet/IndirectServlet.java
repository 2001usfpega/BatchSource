package com.example.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndirectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws IOException, ServletException
	{
			System.out.println("In Indirect GET!");
			
			res.sendRedirect("http://localhost:9001/HelloServelts/dirserv");
			//res.sendRedirect("https://www.google.com/");
			
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException
			{
			System.out.println("In Indirect Post!");
			
//			RequestDispatcher redis =req.getRequestDispatcher(
//					"/dirserv"
//					
//					
//					);
			
//			RequestDispatcher redis =req.getRequestDispatcher(
//					"untitled.html");
//			res = redirect("http://localhost:9001/HelloServelts/");	
//			redis.forward(req, res);
//			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

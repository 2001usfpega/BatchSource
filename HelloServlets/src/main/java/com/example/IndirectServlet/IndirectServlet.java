package com.example.IndirectServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * There are THREE ways a servlet can respond to an incoming request
 * 
 * -Direct respoinse      (using the PrintWriter Object.  THis happens when the servlet directly respoonds to itself.)
 * 
 * -Forward				  (1req, 1resp. Use RequestDispatcher's .forward() method to function. COmes from HttpServletRequest Object.
 *The servlets asks another servlet/resource (internal to you applicaiton) for assistance.
 *
 * -Redirect			   (2req, 2res.  Use Response object's .sendRedirect() to function)
 * 						   Comes form the HttpServletResponse
 * The servlets informs the client that it must go somewhere else to have the request handled.
 * 
 *
 */


public class IndirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
		System.out.println("Indirect GET!!!");
		res.sendRedirect("http://localhost:8080/HelloServlets/secondpage.html");
//		res.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		//res.sendRedirect("https://www.google.com/");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException
	
		{
			System.out.println("Indirect POST!!!");
			
//			RequestDispatcher redis = req.getRequestDispatcher("/dirserv");
//			
//			redis.forward(req, res);
			
//			RequestDispatcher redis = req.getRequestDispatcher("https://www.google.com");
			
			RequestDispatcher redis = req.getRequestDispatcher("/secondpage.html");
			
			redis.forward(req, res);
		}

	
}

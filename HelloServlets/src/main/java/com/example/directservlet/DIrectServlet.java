package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DIrectServlet extends HttpServlet{
/*
 * Http methods include get,post,put,delete,patch,head,options,trace,connect,etc
 * Get is the browsers default http method
*/
	@Override //memorize this 
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException 
	{
		System.out.println("Indirect doGet");
		//default content type is "text/html"
		//
		//res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		//PrintWriter is responsible for directly responding to the client
		out.println("<html><body><h1>The Servlet is directly talking to the "+"client!</h1></body></html>");
	}
	
	@Override //memorize this 
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException 
	{
		System.out.println("Indirect doPost");
		
		res.setContentType("application/json");
		
		SuperVillain asura = new SuperVillain("Asura","Hair Armament",200_000);
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(asura));
		
		
	}

}

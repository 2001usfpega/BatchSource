package com.example.indirectservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelperSessionServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException
			{
					System.out.println("In Indirect GET!");
					
					
			}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
					throws IOException, ServletException
					{
					System.out.println("In Indirect Post!");
					
					
					
		}
	
	
}

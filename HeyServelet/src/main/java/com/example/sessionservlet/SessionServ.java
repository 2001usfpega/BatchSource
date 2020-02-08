package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SessionServ extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException
		{
			System.out.println("session get");

			
		}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{
		System.out.println("session post");
		
		
	}
}

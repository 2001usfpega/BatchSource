package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.SuperVillain;


@SuppressWarnings("serial")
public class DirectServlet extends HttpServlet{
//	private static final long serialVersionUID = -4109236571491620947L;

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
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(asura));;
	}
	
	
	
}

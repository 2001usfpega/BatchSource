package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/*
 * Http methods include: get, post, put, delete, patch, head, options, trace, connect, etc.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class DirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("In Direct doGet!!");
		
		res.setContentType("text/html");
		//Print writer is responsible for directly responding to the client
		PrintWriter out = res.getWriter();
		out.println("<html><body><h1>The Servlet is directly talking to the"+" client!</h1></body></html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		System.out.println("In Direct doPost!!!");
		
		res.setContentType("application/json");
		SuperVillain asura = new SuperVillain("Asura", "Hair Armament", 200_00);
		res.getWriter().write(new ObjectMapper().writeValueAsString(asura));
		}
}

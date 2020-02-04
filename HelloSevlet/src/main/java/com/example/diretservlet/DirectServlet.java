package com.example.diretservlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http method get, post, put, delete, patch, head, options, trace, connect, ect


public class DirectServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletExecption, IOExecption
			{
				System.out.println("In direct doGet");
				
				res.setContentType("text/html");
				
				//Responsible for respond to the client
				PrintWriter out = res.getWriter();
				
				out.println("<html><body><h1> the servlet is directly talking to the " + "client!</h1></body></html>");
				
				
			}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletExecption, IOExecption
			{
				System.out.println("In direct doPost");
				
				res.setContentType("application/json");
				
				SuperVillian asura = new SuperVillian("Asura," "hair Armanment", 200_000);
				
				res.getWriter().write(new ObjectMapper().writeValueAsStrong(asura));
				
			}
			
			
}

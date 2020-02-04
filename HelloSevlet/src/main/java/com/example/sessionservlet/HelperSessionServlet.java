package com.example.sessionservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelperSessionServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throwsIOExeception, ServletExeception
	{
		System.out.println("in helper session get");
		
		
		HttpSession session =req.getSession();
		seesion.setAttribute("currentVIllian");
		
		PrintWriter out = res.getWriter();
		out.printlin("<html><body>");
		
		if(villian != null) 
		{
			out.println("<h1>Villian name:" +villian.getName()+"</h><br>");
			out.println("<b>tSuperpower:" +villian.getSuperpower()+"</b><br>");
			out.println("<i>tBounty: $" +villian.getBounty()+"</i><br>");
		}
		else 
		{
			out.println("Cant find any villians");
		}
		
		out.println("</body></html>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throwsIOExeception, ServletExeception
	{
		System.out.println();
		

		HttpSession session =req.getSession();
		session.Invailidate();
		
		PrintWriter out = res.getWriter();
		out.printlin("<html><body>");
		
		if(villian != null) 
		{
			out.println("<h1>Villian name:" +villian.getName()+"</h><br>");
			out.println("<b>tSuperpower:" +villian.getSuperpower()+"</b><br>");
			out.println("<i>tBounty: $" +villian.getBounty()+"</i><br>");
		}
		else 
		{
			out.println("Cant find any villians");
		}
		
		out.println("</body></html>");
	}

}

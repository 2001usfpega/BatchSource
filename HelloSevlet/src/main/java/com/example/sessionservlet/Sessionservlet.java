package com.example.sessionservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sessionservlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throwsIOExeception, ServletExeception
	{
		System.out.println("in session get");
		SuperVIllian dannyboy = new SuperVillian("Danny Boy", "Technopath", 250_000);
		
		HttpSession session =req.getSession();
		seesion.setAttribute("currentVIllian", dannyboy);
		
		PrintWriter out = res.getWriter();
		out.printlin("Danny Boy is on the loose.?");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throwsIOExeception, ServletExeception
	{
		System.out.println();
		
		String name = req.getParameter("myname");
		String superpower = req.getParameter("mysuperpower");
		int bounty = Integer.parseInt(req.getParameter("mybounty"));
		
		SuperVillian tempVill = new SuperVillian(name, superpower, bounty);
		
		HttpSession session = req.getSession();
		session.setAttribute("currentVIllian", tempVill);
		
		PrintWriter out =res.getWriter();
		out.println("");
		
		
		
	}
}

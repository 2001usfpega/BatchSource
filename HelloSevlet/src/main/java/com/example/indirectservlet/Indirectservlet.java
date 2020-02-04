package com.example.indirectservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * three way a servlet can respond to an incoming request:
 * direct response
 * 
 * forward
 * 
 * redirect
 * */

public class Indirectservlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws IOExecption, ServletExeception
	{
		System.out.println("in indirect get");
		
		res.sendRedirect(url);
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOExecption, ServletExeception
		{
			System.out.println("in indirect post");
			
			//RequestDispatcher redis = req.getRequestDispatcher("/dirsery");
			
			//RequestDispatcher redis = req.getRequestDispatcher("/url");
			
			RequestDispatcher redis = req.getRequestDispatcher("/secondpage");
			
			redis.forward(req, res);
		}
}

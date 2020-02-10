package com.dnut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnut.bonus.Util;
import com.dnut.controller.HomeController;
import com.dnut.controller.LoginController;


@SuppressWarnings("serial")
public class MasterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("help me");

		req.getRequestDispatcher(process(req)).forward(req, res);

	//	res.getWriter().append("Served at: ").append(req.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
	public static String process(HttpServletRequest req){
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/dnut/login.change":
			System.out.println("in /reimbursement");
			return LoginController.login(req);
		case "/dnut/home.change":
			System.out.println("in home.change");
			return HomeController.home(req);
		default:
			System.out.println("in default case");
			return "/badlogin2.html";
		}
	}
	
	
	

}

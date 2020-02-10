package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.ers.model.Employee;
import com.ers.service.EmployeeService;
import com.ers.service.EmployeeServiceImpl;

public class LoginController {
	private static EmployeeService es = new EmployeeServiceImpl();
	
	public static String login(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			return "resources/html/Login.html";
		}
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Employee emp = es.login(username, password);

		
		if (emp == null) {
			return "wrongcreds.do";
		} else {
			/*
			 * in YOUR project, you'll be storing an entire User object in the session which
			 * will ALSO contain whether it is an manager or employee
			 */
			//req.getSession().setAttribute("loggedusername", username);
			//req.getSession().setAttribute("loggedpassword", password);
			req.setAttribute("Employee", emp);
			return "home.do";
		}
	}
}

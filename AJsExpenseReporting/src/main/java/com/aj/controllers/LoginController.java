package com.aj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aj.model.User;
import com.aj.service.UserService;
import com.aj.service.UserServiceImpl;

public class LoginController {
	
	public static String login(HttpServletRequest req) {
		UserService userSvc = new UserServiceImpl();
		List<User> users = userSvc.getAllUsers();
		String destination = null;
		
		if(!req.getMethod().equals("POST")) {
			return "resources/html/Login.html";
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("In login controller: " + username + " " + password);
		
		for(User u : users ) {
			if(!username.equals(u.getUname()) && password.equals(u.getPw())) {
				return "badLogin.html";
			}
			else {
				
				req.getSession().setAttribute("loggedinuser", username);
				req.getSession().setAttribute("loggedinpw", password);
				
				if (u.getRole().equals("admin")) {
					destination = "AdminHome.html";
				}
				else {
					destination = "EmployeeHome.html";
				}
			}
		}
		return destination;
	}
}

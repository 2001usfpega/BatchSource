package com.project1.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.project1.Models.AccountsImpl;
import com.project1.Service.EmployeeService;

public class LoginController {
	static EmployeeService emp = new EmployeeService();
	
	
	public static String getUsername(HttpServletRequest req) {
		return req.getParameter("username");
		
	}
	public static String login(HttpServletRequest req) {

		if(!req.getMethod().equals("POST")) {
			return "resources/html/login.html";
		}
		
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		AccountsImpl account = new AccountsImpl();
		account = check(username,password);
		if(account.getFirstname() != null){
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			req.getSession().setAttribute("emp_id", account.getId());
			if (account.getType()== 1){
				return "homeAdmin.change";
			}else{
				return "homeEmployee.change";
			}
		}else{
			return "badlogin";
			
		}
	}
	public static AccountsImpl check(String username, String password) {
		AccountsImpl account = EmployeeService.checkLogin(username, password);
		if(account.getFirstname() == null){
			return null;
		}else{
			return account;
		}
	}
	
}

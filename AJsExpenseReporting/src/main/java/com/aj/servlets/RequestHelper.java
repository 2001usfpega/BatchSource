package com.aj.servlets;

import javax.servlet.http.HttpServletRequest;

import com.aj.controllers.AdminController;
import com.aj.controllers.EmployeeController;
import com.aj.controllers.LoginController;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		
		switch(req.getRequestURI()) {
		case "/AJsExpenseReporting/login.html":
			return LoginController.login(req);
		case "/AJsExpenseReporting/AdminHome.html":
			return AdminController.admin(req);
		case "/AJsExpenseReporting/EmployeeHome.html":
			return EmployeeController.empl(req);
		default:
			return "resources/html/badlogin.html";
		}
	}
}

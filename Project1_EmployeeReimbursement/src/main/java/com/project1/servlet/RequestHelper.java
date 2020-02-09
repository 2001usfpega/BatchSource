package com.project1.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.project1.controllers.HomeController;
import com.project1.controllers.LoginController;
import com.project1.main.LoggerExample;

public class RequestHelper extends HttpServlet {

	private static final long serialVersionUID = 1L;

	final static Logger logg= Logger.getLogger(LoggerExample.class);
	
	public static String process(HttpServletRequest req){
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/Project1_EmployeeReimbursement/approve.change":
			return HomeController.approve(req);
		case "/Project1_EmployeeReimbursement/deny.change":
			System.out.println("in deny.change");
			return HomeController.deny(req);
		case "/Project1_EmployeeReimbursement/newRequest.change":
			return HomeController.newRequest(req);
		case "/Project1_EmployeeReimbursement/newRequestSubmit.change":
			logg.info(req.getAttribute("emp_id") + "Submitted new request");
			return HomeController.newRequestSubmit(req);
		case "/Project1_EmployeeReimbursement/login.change":
			return LoginController.login(req);
		case "/Project1_EmployeeReimbursement/homeAdmin.change":
			logg.info(req.getAttribute("emp_id") + " Admin logged in");
			return HomeController.homeAdmin(req);
		case "/Project1_EmployeeReimbursement/homeEmployee.change":
			logg.info(req.getAttribute("emp_id") + "logged in");
			return HomeController.homeEmployee(req);
		default:
			return "resources/html/badlogin.html";
		}
	}
}

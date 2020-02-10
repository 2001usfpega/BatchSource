package com.ers.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.ers.app.Driver;
import com.ers.model.Employee;
import com.ers.model.ExpenseTicket;
import com.ers.service.ExpenseTicketService;
import com.ers.service.ExpenseTicketServiceImpl;

public class HomeController {
	private static ExpenseTicketService ets = new ExpenseTicketServiceImpl();

	final static Logger LOGGER = Logger.getLogger(Driver.class);
	public static String home(HttpServletRequest req) {
		//Gets the employee attempting to log in
		Employee emp = (Employee) req.getAttribute("Employee");
		
		LOGGER.setLevel(Level.ALL);
		LOGGER.info("User > " + emp.getUsername() + " signed in, Finance Manager? > " + emp.getFinanceManager());
		System.out.println(req);
		
		//Checks whether or not the employee is a admin
		if(emp.getFinanceManager() == 0) {
			//req.setAttribute("ActiveEmployee", emp);
			ets.createExpenseTicket(-1, -1, "null", emp.getUserid());
			return "/resources/html/EmployeeHome.html";
		} else {
			//req.setAttribute("ActiveAdmin", emp);
			List<ExpenseTicket> tickets = ets.getAllTickets();
			req.setAttribute("tickets", tickets);
			return "AdminHome.json";
		}
	}
}

package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.ers.model.ExpenseTicket;
import com.ers.service.ExpenseTicketService;
import com.ers.service.ExpenseTicketServiceImpl;

public class NewExpenseController {
	private static ExpenseTicketService ets = new ExpenseTicketServiceImpl();
	
	public static String createTicket(HttpServletRequest req) {
		int type = Integer.parseInt(req.getParameter("type"));
		
		double amount = Double.parseDouble(req.getParameter("Amount"));
		
		String description = req.getParameter("Description");
		
		ExpenseTicket et = ets.getAllTicketsByType(-1).get(0);
		et.setAmount(amount);
		et.setType(type);
		et.setDescription(description);
		
		ets.updateTicket(et);
		
		return "resources/html/Login.html";
	}
}

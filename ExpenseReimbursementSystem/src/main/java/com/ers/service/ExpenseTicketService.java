package com.ers.service;

import java.util.List;

import com.ers.model.ExpenseTicket;

public interface ExpenseTicketService {
	
	public void createExpenseTicket(int type, double amount, String description, int userid);
	
	public void deleteExpenseTicket(ExpenseTicket et);
	
	public void updateStatus(ExpenseTicket et);
	
	public ExpenseTicket viewSigleTicket(int ticketid);
	
	public List<ExpenseTicket> getAllEmployeeTickets(int userid);
	
	public List<ExpenseTicket> getAllTickets();
	
	public List<ExpenseTicket> getAllTicketsByType(int type);
	
	public void updateTicket(ExpenseTicket et);
}

package com.ers.dao;

import java.util.List;

import com.ers.model.ExpenseTicket;

public interface ExpenseTicketDao extends DaoDao{
	
	public ExpenseTicket getExpenseTicketById(int ticketid);
	
	public List<ExpenseTicket> getExpenseTicketsByUserId(int userid);
	
	public List<ExpenseTicket> getAllExpenseTickets();
	
	public List<ExpenseTicket> getAllExpenseTicketsByType(int type);
	
	public void createExpenseTicket(ExpenseTicket et);
	
	public void updateExpenseTicket(ExpenseTicket et);
	
	public void deleteExpenseTicket(ExpenseTicket et);
	
	public void updateFullTicket(ExpenseTicket et);
}

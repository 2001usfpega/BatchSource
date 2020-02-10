package com.ers.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.ers.dao.ExpenseTicketDao;
import com.ers.dao.ExpenseTicketDaoImpl;
import com.ers.model.ExpenseTicket;

public class ExpenseTicketServiceImpl implements ExpenseTicketService {
	
	private static ExpenseTicketDao etd = new ExpenseTicketDaoImpl();
	
	@Override
	public void createExpenseTicket(int type, double amount, String description, int userid) {
	
		Date dateSubmitted = new Date(System.currentTimeMillis());

		String status = "Pending";

		ExpenseTicket et = new ExpenseTicket(0, type, amount, dateSubmitted, null, status, description, userid);
		etd.createExpenseTicket(et);

	}

	@Override
	public void deleteExpenseTicket(ExpenseTicket et) {
		etd.deleteExpenseTicket(et);

	}

	@Override
	public void updateStatus(ExpenseTicket et) {
		etd.updateExpenseTicket(et);

	}

	@Override
	public ExpenseTicket viewSigleTicket(int ticketid) {
		return etd.getExpenseTicketById(ticketid);
	}

	@Override
	public List<ExpenseTicket> getAllEmployeeTickets(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpenseTicket> getAllTickets() {
		return etd.getAllExpenseTickets();
	}

	@Override
	public List<ExpenseTicket> getAllTicketsByType(int type) {
		return etd.getAllExpenseTicketsByType(type);
	}

	@Override
	public void updateTicket(ExpenseTicket et) {
		etd.updateFullTicket(et);
		
	}

}

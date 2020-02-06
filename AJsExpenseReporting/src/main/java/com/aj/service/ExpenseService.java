package com.aj.service;

import java.util.List;

import com.aj.model.Expense;

public interface ExpenseService {
	
	
	public List<Expense> getAllExpenses();
	public List<Expense> getExpensesByState();
	
	public List<Expense> getExpensesByUserId();
	
	public void createExpense(Expense ex);
	
	
}

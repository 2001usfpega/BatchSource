package com.aj.DAO;

import java.util.List;

import com.aj.model.Expense;

public interface ExpenseDAO {
	
	public void createNewExpense(Expense ex);
	
	public List<Expense> selectAllExpenses();
	public List<Expense> selectPendingExpenses();
	
	public String updateExpense(Expense ex);
	
	public String deleteExpense(Expense ex);
}

package com.aj.main;

import com.aj.DAO.ExpenseDAOImpl;
import com.aj.DAO.UserDAOImpl;
import com.aj.model.Expense;
import com.aj.model.User;

public class Main {
	
	
	public static void main(String[] args) {
		UserDAOImpl userDAO = new UserDAOImpl();
		ExpenseDAOImpl expDAO = new ExpenseDAOImpl();
		User test = new User(null, "aj", "amanda", "Jordan", "pass", "empl");
		Expense exp = new Expense(null, 143, 1, null, null, "pending", 100.87f, "myexpense");
		//userDAO.createNewUser(test);
		expDAO.createNewExpense(exp, test);
		
	}
}

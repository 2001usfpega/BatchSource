package com.aj.main;

import com.aj.DAO.UserDAOImpl;
import com.aj.model.User;

public class Main {
	
	
	public static void main(String[] args) {
		UserDAOImpl userDAO = new UserDAOImpl();
		User test = new User(null, "ajJordan", "AJ", "Jordan", "pass", "empl");
		userDAO.createNewUser(test);
		
	}
}

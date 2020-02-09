package com.project1.Service;

import com.project1.DAO.EmployeeDaoImpl;
import com.project1.Models.AccountsImpl;

public class EmployeeService {
	public EmployeeDaoImpl db = new EmployeeDaoImpl();
	public static AccountsImpl account = new AccountsImpl();
	

	public static AccountsImpl checkLogin(String username, String password) {
		account = EmployeeDaoImpl.readEmployee(username, password);
		if(account.getFirstname() == null) {
		return account;
		}
		return account;
	}
}

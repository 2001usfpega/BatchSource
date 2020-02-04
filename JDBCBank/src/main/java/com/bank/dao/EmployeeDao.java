package com.bank.dao;

import java.util.List;

import com.bank.user.Employee;

public interface EmployeeDao {
	//CREATE
	public boolean insertNewEmployee(String uname, String pw, String fName, String sName, int rank);
	
	//READ
	public List<Employee> selectAllCustomers();
	public Employee selectByUserId(int id);
	public Employee selectByUsername(String uname);
	public Employee selectByUserNameAndPassword(String name, String password);
	//UPDATE
	public boolean updateCustomer(Employee e);
	//DELETE
	public boolean deleteCustomer(Employee e);
}

package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;

public interface EmployeeDao extends DaoDao{
	
	public Employee getEmployeeByUsername(String user);
	
	public List<Employee> getAllEmployees();
	
	public void createEmployee(Employee employee);
	
	public void deleteEmployeeByUsername(String user);
	
	public void updateEmployee(Employee employee);
}

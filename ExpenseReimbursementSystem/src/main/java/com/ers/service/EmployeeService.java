package com.ers.service;

import java.util.List;

import com.ers.model.Employee;

public interface EmployeeService {
	
	public void createTicket();
	
	public Employee login(String user, String pass);
	
	public boolean checkUserAndPass(String user, String pass);
	
	public void createEmp();
	
	public void deleteEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public List<Employee> getAllEmployees();
}

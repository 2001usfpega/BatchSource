package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao extends DaoDao{
	
	/**
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * 
	 * @param employeeID
	 * @return
	 */
	public Employee getEmployeeByID(Integer employeeID);
	
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public boolean createEmployee(Employee employee);
	
	/**
	 * 
	 * @param employeeID
	 * @return
	 */
	public boolean deleteEmployee(Integer employeeID);
	
	public Employee getEmployeeByUsername(String username);
}

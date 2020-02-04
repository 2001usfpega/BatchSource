package com.bankThing.Dao;

import java.util.List;

import com.bankThing.Employee;

public interface EmployeeDaoInterface {
	
	
	//CREATE
	public int insertEmployee (Employee employee);
	//READ
	public List<Employee> selectAllEmployee();
	public Employee selectEmployeeById(long id);
	public Employee selectEmployeeByName(String name);
	//UPDATE
	public boolean updateEmployee(Employee employee);
	//DELETE
	public boolean deleteEmployee(Employee employee);
	

}

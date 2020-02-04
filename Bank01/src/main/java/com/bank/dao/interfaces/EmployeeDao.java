package com.bank.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.bank.bean.Employee;

public interface EmployeeDao {
	
	//inserts
	
	public  void insertEmployee(Employee emp) throws SQLException;
    //Update
	public  void updateEmployee(Employee emp);
	//Delete
	public  void deleteEmployee(Employee emp);
	
	//Select
	public List<Employee> selectAllEmployee();
	public void selectEmployeeById(int emp_id);


}

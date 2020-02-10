package com.ers.service;

import java.util.List;
import java.util.Scanner;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao ed = new EmployeeDaoImpl();

	@Override
	public void createTicket() {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee login(String user, String pass) {
		if (checkUserAndPass(user, pass)) {
			return ed.getEmployeeByUsername(user);
		} else {
			return null;
		}

	}

	@Override
	public boolean checkUserAndPass(String user, String pass) {
		Employee emp = ed.getEmployeeByUsername(user);
		if (emp != null) {
			if (emp.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public void createEmp() {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your username > ");
		String username = input.nextLine();

		System.out.println("Please enter your password > ");
		String password = input.nextLine();

		System.out.println("Please enter your first name > ");
		String fName = input.nextLine();

		System.out.println("Please enter your last name > ");
		String lName = input.nextLine();

		Employee employee = new Employee(0, username, password, fName, lName, 0);
		ed.createEmployee(employee);
		input.close();
	}

	@Override
	public void deleteEmp(Employee employee) {
		ed.deleteEmployeeByUsername(employee.getUsername());
	}

	@Override
	public void updateEmp(Employee employee) {
		ed.updateEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ed.getAllEmployees();
	}

}

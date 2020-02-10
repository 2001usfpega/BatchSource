package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class Not Found", e);
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeByUsername(String user) {
		Employee emp = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = "SELECT * FROM employee WHERE username = '" + user + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						rs.getString(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error getting employee", e);
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error getting employee", e);
		}
		return employees;
	}

	@Override
	public void createEmployee(Employee employee) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			

			String sql = "INSERT INTO employee (userid,username,password,fName,lName,financeManager) "
					+ "VALUES (null, ?, ?, ?, ? ,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getfName());
			ps.setString(4, employee.getlName());
			ps.setInt(5, employee.getFinanceManager());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error creating employee", e);
		}

	}

	@Override
	public void deleteEmployeeByUsername(String user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "DELETE FROM employee WHERE username = '" + user + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error deleting employee", e);
		}

	}

	@Override
	public void updateEmployee(Employee employee) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE employee SET username = '" + employee.getUsername() + "', password = '" + 
			employee.getPassword() +"' WHERE userid = " + employee.getUserid();
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error updating employee", e);
		}

	}

}

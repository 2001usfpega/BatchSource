package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Address;
import com.revature.model.Customer;
import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByID(Integer employeeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Integer employeeID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeByUsername(String user) {
		Employee emp = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = "SELECT * FROM employee WHERE username = '" + user + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Address address = new Address(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), address, rs.getString(10), rs.getString(11),true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

}

package com.bankdao.interfaces.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bank.bean.Employee;
import com.bank.dao.interfaces.EmployeeDao;

public class EmployeeDaoImpl extends connection implements EmployeeDao {

	@Override
	public void insertEmployee(Employee emp) throws SQLException {
		try {
			this.getConected();
			
			String sql="INSERT INTO employee (employee_id,employee_first_name,employee_password,) values(?,?,?)";
			PreparedStatement ps=this.conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmployee_id());

			ps.setString(2, emp.getName());
			ps.setString(3, emp.getPassword());
			ps.executeUpdate();
			
			System.out.println(ps);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.closeConnection();
		}
	
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> selectAllEmployee() {
		
		return null;
	}

	@Override
	public void selectEmployeeById(int emp_id) {
		// TODO Auto-generated method stub
	
	}

}

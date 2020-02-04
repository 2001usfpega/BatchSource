package com.bankThing.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bankThing.Employee;


public class EmployeeDao implements EmployeeDaoInterface {


	private static String url= System.getenv("DB_URL");
	private static String username= System.getenv("DB_bankThing_userName");
	private static String password=System.getenv("DB_pw");



	@Override
	public int insertEmployee(Employee employee) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){

			/*
			 * prepared statement guard against sql injection because it is pre-compiled
			 *  (which also makes it faster)
			 */
			String sql= "INSERT INTO employee(emp_first, emp_last, emp_pw, is_admin) VALUES(?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmp_first()); //first question mark
			ps.setString(2, employee.getEmp_last());  //second question mark
			byte[] emp_pw = employee.getEmp_pw().getBytes(); // un
			ps.setBytes(3, emp_pw); //third question mark
			ps.setBoolean(4, employee.isAdmin());//third question mark

			ps.executeUpdate();
			return 1;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Employee> selectAllEmployee() {
		List<Employee> employees = new ArrayList<>();


		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM employee ORDER BY employee_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) {
				String str = new String(rs.getBytes(4));
				employees.add(
						new Employee( rs.getLong(1), rs.getString(2), rs.getString(3), str, rs.getBoolean(5))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		for (Employee  eachone: employees) {

			System.out.println(eachone);
		}

		return employees;
	}


	@Override
	public Employee selectEmployeeById(long id) {
		Employee employeeById = new Employee();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM employee WHERE employee_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String str = new String(rs.getBytes(4));
			employeeById.setEmployeeid(rs.getLong(1));
			employeeById.setEmp_first(rs.getString(2));
			employeeById.setEmp_last(rs.getString(3));
			employeeById.setEmp_pw(str);
			employeeById.setAdmin(rs.getBoolean(5));
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return employeeById;
	}

	@Override
	public Employee selectEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		//		try(Connection conn = DriverManager.getConnection(url,username,password)){
		//			String sql= "UPDATE customers SET username=?, password=?, firstname=?, lastname=? WHERE customerid=?";
		//
		//			PreparedStatement ps = conn.prepareStatement(sql);
		//			ps.setString(1, employee.getUsername());
		//			ps.setString(2, employee.getPassword());
		//			ps.setString(3, employee.getFirstName());
		//			ps.setString(4, employee.getLastName());
		//			ps.setInt(5, employee.getUserID());
		//
		//			//System.out.println(sql);
		//			if(ps.executeUpdate()>0) {
		//				return true;
		//			}
		//		}catch(SQLException e) {
		//			e.printStackTrace();
		//		}
		//		return false;
		//	}
		return true;
	}

	//	public boolean updateUser(Employee u) {
	//		try(Connection conn = DriverManager.getConnection(url,username,password)){
	//			String sql= "UPDATE customer SET username=?, password=?, firstname=?, lastname=? WHERE customerid=?";
	//			
	//			PreparedStatement ps = conn.prepareStatement(sql);
	//			ps.setString(1, u.getUsername());
	//			ps.setString(2, u.getPassword());
	//			ps.setString(3, u.getFirstName());
	//			ps.setString(4, u.getLastName());
	//			ps.setInt(5, u.getUserID());
	//
	//			//System.out.println(sql);
	//			if(ps.executeUpdate()>0) {
	//				return true;
	//			}
	//		}catch(SQLException e) {
	//			e.printStackTrace();
	//		}
	//		return false;
	//	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){

			String sql="DELETE FROM employee WHERE employee_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, employee.getEmployeeid());
			if(ps.executeUpdate()>0) {
				return true;
			}			
			//System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}


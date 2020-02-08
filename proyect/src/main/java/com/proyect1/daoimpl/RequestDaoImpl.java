package com.proyect1.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.proyect1.dao.interf.RequestDao;
import com.proyect1.model.Employee;
import com.proyect1.model.Ticket;

public class RequestDaoImpl implements RequestDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = System.getenv("BANK_DB_URL");

	private static String username1 = System.getenv("BANK_DB_USERNAME");
	private static String password1 = System.getenv("BANK_DB_PASSWORD");

	@Override
	public int selectEmpId(String username, String pass) {

		return 0;
	}

	@Override
	public int insertRequest(String ticket_type, int Amount, int emp_id,String descrip) {
		int ticke_id = 0;

		try (Connection conn = DriverManager.getConnection(url, username1, password1)) {

			String ql = "BEGIN INSERT INTO ticket(ticket_type,ticket_amount,ticket_status,emp_id,date_submited,description) VALUES(?,?,?,?,?,?) RETURNING ticket_id into ?; END;";

			CallableStatement ps = conn.prepareCall(ql);

			ps.setString(1, ticket_type);
			ps.setDouble(2, Amount);
			ps.setString(3, "pending");
			ps.setInt(4, emp_id);
			ps.setDate(5, (java.sql.Date) new Date(System.currentTimeMillis()));
			ps.setString(6, descrip);

			ps.registerOutParameter(7, Types.NUMERIC);
			ps.execute();
			
			ticke_id = ps.getInt(7);

			System.out.println("new ticket_id is " + ps.getInt(5));
			ps.close();

			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return ticke_id;

	}

	@Override
	public List<Ticket> selectAllTicket() {

		List<Ticket> ticketList = new ArrayList<Ticket>();
		try (Connection conn = DriverManager.getConnection(url, username1, password1)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ticket where ticket_status='pending'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ticketList.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),rs.getDate(6),rs.getString(7)));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return ticketList;

	}

	@Override
	public void updateRequestStatus(int ticket_id) {
		try(Connection conn=DriverManager.getConnection(url, username1, password1)) {
			String ql="UPDATE ticket  SET ticket_status=? where ticket_id=?";
			String status="approve";
			PreparedStatement ps=conn.prepareStatement(ql);
			 ps.setString(1, status);
			 ps.setInt(2,ticket_id);
			ResultSet rs= ps.executeQuery();
		
		if (rs.next()!=false) {
			System.out.println("your request has been approve");

		}
		
		else {
			System.out.println("your request still pending");

		}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public int selectEmpId(int emp_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployee(String username) {
		Employee  emp=new Employee();
		System.out.println("Looking for: "+ username);
		try(Connection conn=DriverManager.getConnection(url, username1, password1)) {
			String ql="SELECT * FROM employee WHERE emp_username=?";
			
			
			PreparedStatement ps=conn.prepareStatement(ql);
			ps.setString(1, username);
			System.out.println("READY TO FIRE");
			
			
			ResultSet rs=ps.executeQuery();
			System.out.println("DONE");
			while(rs.next()) {
			
			emp.setEmp_id(rs.getInt(1));
			emp.setEmp_username(rs.getString(2));
			emp.setEmp_pass(rs.getString(3));
			System.out.println("PRINT OUT THE RESULT");
			System.out.println(emp.toString());		
				
				
			}
				
			//System.out.println("wrong employee");
			}
		catch (SQLException e) {
			e.getStackTrace();
		}

		
		return emp;
	}
	@Override
	public List<Employee> selectAllEmployee() {

		List<Employee> empList = new ArrayList<Employee>();
		try (Connection conn = DriverManager.getConnection(url, username1, password1)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				empList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                   
			}
			// System.out.println(empList);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return empList;

	}
}

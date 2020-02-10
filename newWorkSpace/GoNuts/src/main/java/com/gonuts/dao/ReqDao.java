package com.gonuts.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gonuts.Util;
import com.gonuts.model.Employee;
import com.gonuts.model.RequestForm;

public class ReqDao {// impliments super

	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("TRAINING_DB_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

	// idk
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			Util.LOGGY.error("selectEmployee broke", e);
		}
	}

	// login
	public Employee selectEmployee(String uname, String pw) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM employees WHERE username=? AND password=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("found");
				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			System.out.println("notfound");
		}
		catch (SQLException e) {
			e.printStackTrace();
			Util.LOGGY.error("selectEmployee broke", e);
		}
		return null;
	}

	// selectAllTickets
	public List<RequestForm> selectAllPendingTickets() {
		List<RequestForm> tickets = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			String sql = "SELECT * FROM ticket t INNER JOIN employees e ON t.employeeid=e.employeeid WHERE status = 0";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tickets.add(new RequestForm(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4)
				//                             int id,        int type,   double amount, Date dateSubmited
							,rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getInt(8)
				//			 Date dateResolved, int status, String notes, 		int eid
							,new Employee(rs.getInt(9),rs.getString(10),rs.getString(12),rs.getString(13),rs.getInt(14))));
				//			Employee empl
			}
		}catch(SQLException e) {
			e.printStackTrace();			
			Util.LOGGY.error("selectAllPendingTickets broke", e);
		}
		return tickets;
	}

	// insertTicket
	public boolean insertTicket(RequestForm ticket) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "{ call new_ticket(?,?,?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ticket.getType());
			cs.setDouble(2, ticket.getAmount());
			cs.setString(3, ticket.getNotes());
			cs.setInt(4, ticket.getEid());
			if(cs.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			Util.LOGGY.error("insertTicket broke", e);
		}
		return false;

	}

	// UpdateTicket
	public boolean updateTicket(RequestForm ticket) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "{ call finish_ticket(?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ticket.getType());
			cs.setInt(2, ticket.getEid());
			
			if(cs.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			Util.LOGGY.error("updateTicket broke", e);
		}
		return false;
	}
}

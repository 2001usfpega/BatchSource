package com.dnut.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dnut.model.Employee;
import com.dnut.model.RequestForm;

public class RequestDao {// impliments super

	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("TRAINING_DB_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

	// idk
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
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
			//e.printStackTrace();
		}
		return null;
	}

	// selectAllTickets
	public List<RequestForm> selectAllPendingTickets() {
		List<RequestForm> list = new ArrayList<>();

		return list;
	}

	// insertTicket
	public void insertTicket(RequestForm ticket) {

	}

	// UpdateTicket
	public void updateTicket(RequestForm ticket) {

	}

//	
//	@Override
//	public boolean insertNewUser(String uname, String pw, String fName, String sName,int rank) {
//		try(Connection conn = DriverManager.getConnection(url,username,password)){
//			String sql= "INSERT INTO customers VALUES (null, ?, ?, ?, ?,?)";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, uname);
//			ps.setString(2, pw);
//			ps.setString(3, fName);
//			ps.setString(4, sName);
//			ps.setInt(5, rank);
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
//
//	@Override
//	public List<Customer> selectAllCustomers() {
//		List<Customer> users = new ArrayList<>();
//		
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			String sql = "SELECT * FROM customers WHERE rank=0";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				users.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}
//	
//	@Override
//	public List<User> selectAllUsers(){
//		List<User> users = new ArrayList<>();
//		
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			String sql = "SELECT * FROM customers";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				int rank=rs.getInt(6);
//				if(rank==0) {
//					users.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
//				}
//				else {
//					if(rank==1) {
//						users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false));
//					}
//					else {
//						users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true));
//					}
//				}
//			}			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}
//
//
//	@Override
//	public User selectByUserId(int id) {
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			String sql = "SELECT * FROM customers WHERE customerid=?";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				int rank=rs.getInt(6);
//				if(rank==0) {
//					return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
//				}
//				else {
//					if(rank==1) {
//						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false);
//					}
//					else {
//						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true);
//					}
//				}
//			}			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public User selectByUsername(String uname) {
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			String sql = "SELECT * FROM customers WHERE username=?";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, uname);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				int rank=rs.getInt(6);
//				if(rank==0) {
//					return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
//				}
//				else {
//					if(rank==1) {
//						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false);
//					}
//					else {
//						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true);
//					}
//				}
//			}			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@Override
//	public boolean updateUser(User u) {
//		try(Connection conn = DriverManager.getConnection(url,username,password)){
//			String sql= "UPDATE customers SET username=?, password=?, firstname=?, lastname=? WHERE customerid=?";
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
//
//	@Override
//	public boolean deleteUser(User u) {
//		try(Connection conn = DriverManager.getConnection(url,username,password)){
//			
//			String sql="DELETE FROM customers WHERE customerid=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, u.getUserID());
//			if(ps.executeUpdate()>0) {
//				return true;
//			}			
//			//System.out.println(sql);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

}

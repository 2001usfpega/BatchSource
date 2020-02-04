package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.user.Customer;
import com.bank.user.Employee;
import com.bank.user.User;

public class CustomerDaoImpl implements CustomerDao {
	
	private static String url= System.getenv("TRAINING_DB_URL");
	private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");

	@Override
	public boolean insertNewUser(String uname, String pw, String fName, String sName,int rank) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "INSERT INTO customers VALUES (null, ?, ?, ?, ?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fName);
			ps.setString(4, sName);
			ps.setInt(5, rank);

			//System.out.println(sql);
			if(ps.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> users = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE rank=0";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public List<User> selectAllUsers(){
		List<User> users = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rank=rs.getInt(6);
				if(rank==0) {
					users.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
				}
				else {
					if(rank==1) {
						users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false));
					}
					else {
						users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true));
					}
				}
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}


	@Override
	public User selectByUserId(int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE customerid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int rank=rs.getInt(6);
				if(rank==0) {
					return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				}
				else {
					if(rank==1) {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false);
					}
					else {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true);
					}
				}
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User selectByUsername(String uname) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE username=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int rank=rs.getInt(6);
				if(rank==0) {
					return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				}
				else {
					if(rank==1) {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false);
					}
					else {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true);
					}
				}
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User selectByUserNameAndPassword(String name, String pw) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE username=? AND password=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int rank=rs.getInt(6);
				if(rank==0) {
					return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				}
				else {
					if(rank==1) {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),false);
					}
					else {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),true);
					}
				}
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User u) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "UPDATE customers SET username=?, password=?, firstname=?, lastname=? WHERE customerid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setInt(5, u.getUserID());

			//System.out.println(sql);
			if(ps.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User u) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			
			String sql="DELETE FROM customers WHERE customerid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserID());
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

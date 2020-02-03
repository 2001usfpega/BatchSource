package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.user.Customer;
import com.bank.user.User;

public class CustomerDaoImpl implements UserDao {
	
	private static String url= System.getenv("TRAINING_DB_URL");
	private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");

	@Override
	public boolean insertNewUser(String uname, String pw, String fName, String sName) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "INSERT INTO customers VALUES (null, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fName);
			ps.setString(4, sName);

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
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers";
			
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
	public User selectByUserId(int id) {
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE customerid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectByUsername(String uname) {
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customers WHERE username=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectByUserNameAndPassword(String name, String pw) {
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			//System.out.println(url+" "+username+" "+password);
			String sql = "SELECT * FROM customers WHERE username=? AND password=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				//also get accounts maybe
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(User u) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "UPDATE customer SET username=?, password=?, firstname=?, lastname=? WHERE customerid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setInt(4, u.getUserID());

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
		// TODO Auto-generated method stub
		return false;
	}

}

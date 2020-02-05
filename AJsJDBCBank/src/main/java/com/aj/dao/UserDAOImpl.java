package com.aj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aj.models.User;
import com.aj.utils.DaoConUtil;

public class UserDAOImpl implements UserDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	List<User> users = new ArrayList<>();
	
	@Override
	public void createNewUser(User user) {
		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getUser_id());
			stmt.setString(2, user.getFname());
			stmt.setString(3, user.getLname());
			stmt.setString(4, user.getUname());
			stmt.setString(5, user.getPw());
			stmt.setString(6, user.getRole());
			
			stmt.executeQuery();
			System.out.println("Successfully added user.");

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> selectAllUsers() {
		
		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "SELECT * FROM users";
			
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				
				user.setUser_id(rs.getString(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setUname(rs.getString(4));
				user.setPw(rs.getString(5));
				user.setRole(rs.getString(6));
				
				users.add(user);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		//for (User u : users) {
		//	System.out.println(u);
		//}
		return users;
	}

	@Override
	public User selectUserById(String user_id) {
		User user = new User();
		
		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE user_id = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setNString(1, user_id);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				user.setUser_id(rs.getString(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setUname(rs.getString(4));
				user.setPw(rs.getString(5));
				user.setRole(rs.getString(6));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeRsrcs();
		}
		return user;
	}

	@Override
	public User selectUserByUsername(String user) {
		User userReturned = new User();
		
		try {
			connection = DaoConUtil.getConnection();
			String sql = "SELECT * FROM user WHERE Uname = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				userReturned.setUser_id(rs.getString(1));
				userReturned.setFname(rs.getString(2));
				userReturned.setLname(rs.getString(3));
				userReturned.setUname(rs.getString(4));
				userReturned.setPw(rs.getString(5));
				userReturned.setRole(rs.getString(6));
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return userReturned;
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void closeRsrcs() {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}

}

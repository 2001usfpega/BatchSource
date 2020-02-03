package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.CustomerInfo;
import com.revature.user.Address;
import com.revature.user.Customer;




public class CustDaoImpl implements CustDao{
	
	private static String url=System.getenv("TRAINING_DB_URL");	
	private static String username=System.getenv("PROJECT_0_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");
	
	public CustomerInfo getCustomerByUsername(String user) {
		CustomerInfo customer = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM customer WHERE username = " + "'" + user + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				customer = new CustomerInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}

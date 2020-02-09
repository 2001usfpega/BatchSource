package com.project1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.project1.Models.AccountsImpl;
import com.project1.main.LoggerExample;

public class EmployeeDaoImpl {
	
	public static AccountsImpl account = new AccountsImpl();
	public static String url =System.getenv("p1_url");
	public static String username =System.getenv("p1_username");
	public static String password =System.getenv("p1_password");
	final static Logger logg= Logger.getLogger(LoggerExample.class);
	
	
	public static AccountsImpl readEmployee(String user_name, String pass) {
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			} catch (SQLException e1) {
				logg.error("error in driver registaration",e1);
				e1.printStackTrace();
			}
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, username, password);
				 String sql = "SELECT * FROM employee_user WHERE emp_username =? AND emp_pass = ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, user_name);
		            ps.setString(2, pass);
		            ResultSet rs = ps.executeQuery();
		            while(rs.next()) {
		            	account.setId(rs.getInt(1));
		            	account.setUsername(rs.getString(2));
		            	account.setPassword(rs.getString(3));
		            	account.setFirstname(rs.getString(4));
		            	account.setLastname(rs.getString(5));
		            	account.setType(rs.getInt(6));
		            }
		            return account;
			} catch (SQLException e) {
				logg.error("error in driver connection",e);
				e.printStackTrace();
			}
	           
		return account;
	}

}

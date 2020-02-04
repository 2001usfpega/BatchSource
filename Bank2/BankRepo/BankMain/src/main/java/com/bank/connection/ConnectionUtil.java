package com.bank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil{
	
	
	protected Connection conn;
	private final static String url = System.getenv("BANK_DB_URL");
	private final static String username = System.getenv("BANK_DB_USERNAME");
	private final static String password = System.getenv("BANK_DB_PWORD");
	
	public void getConnected() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
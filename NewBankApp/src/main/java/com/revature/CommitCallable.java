package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommitCallable {
	
	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");
	
	public static void commitCall() {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "{ call commit_procedure }"; 
			CallableStatement cs = conn.prepareCall(sql);
			int status = cs.executeUpdate();
			System.out.println("You're transaction has completed and your updates are committed to the database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}

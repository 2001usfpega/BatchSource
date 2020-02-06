package com.aj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOxUtil {
	private static final String URL = System.getenv("training_db_url");
	private static final String CONNECTION_USERNAME = System.getenv("training_db_username");
	private static final String CONNECTION_PASSWORD = System.getenv("training_db_password");
	private static Connection connection;

	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {

			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		if (connection.isValid(100)) {
			System.out.println("Connection made!");
		}

		// If connection was closed then retrieve a new connection
		if (connection.isClosed()) {
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}

}

package com.example.JDBCServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exapmle.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JDBCServlet extends HttpServlet {

	public final String url = System.getenv("TRAINING_DB_URL");

	public final String username = System.getenv("TRAINING_DB_USERNAME");

	public final String password = System.getenv("TRAINING_DB_PASSWORD");

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");

		Customer asura = getCustomerByUsername("mjlail719");
		System.out.println(asura.toString());

		res.getWriter().write(new ObjectMapper().writeValueAsString(asura));
	}

	public Customer getCustomerByUsername(String user) {
		Customer customer = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("CONNECTED");
			String sql = "SELECT * FROM customer WHERE username = '" + user + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Address address = new Address(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), address, rs.getString(10), rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}

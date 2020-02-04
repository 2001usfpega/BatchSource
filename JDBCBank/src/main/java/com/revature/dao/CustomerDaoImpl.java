package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Address;
import com.revature.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM customer";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = null;
				Address address = new Address(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), address, rs.getString(10), rs.getString(11));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getCustomerByUsername(String user) {
		Customer customer = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

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

	@Override
	public boolean deleteCustomer(Integer customerID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "DELETE FROM customer WHERE customerid = " + customerID;

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void createCustomer(Customer customer) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			/*
			 * prepared statements guard against sql injections because it is pre-compiled
			 * (Which also makes it faster)
			 */

			String sql = "INSERT INTO customer(customerid,username,password,fname,lname,address,city,state,zipcode,phone,email) VALUES(null,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getfName());
			ps.setString(4, customer.getlName());
			ps.setString(5, customer.getAddress().getAddress());
			ps.setString(6, customer.getAddress().getCity());
			ps.setString(7, customer.getAddress().getState());
			ps.setString(8, customer.getAddress().getZip());
			ps.setString(9, customer.getPhone());
			ps.setString(10, customer.getEmail());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE customer SET username = '" + customer.getUsername() + "', password = '" + 
			customer.getPassword() +"'WHERE customerid = " + customer.getCustomerId();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

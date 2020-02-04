package com.bankThing.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bankThing.Customer;

public class CustomerDao implements CustomerDaoInterface {


	private static String url= System.getenv("DB_URL");
	private static String username= System.getenv("DB_bankThing_userName");
	private static String password=System.getenv("DB_pw");

	@Override
	public int insertCustomer(String first1, String last1, String pw1) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){

			/*
			 * prepared statement guard against sql injection because it is pre-compiled
			 *  (which also makes it faster)
			 */
			String sql= "INSERT INTO customer(first_1, last_1, pw_1, account_id) VALUES(?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, first1); //first question mark
			ps.setString(2, last1);  //second question mark
			byte[] cust_pw1 = pw1.getBytes(); // un
			ps.setBytes(3, cust_pw1);
			ps.setLong(4, 0);

			ps.executeUpdate();
			return 1;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectCustomerById(int id) {
		//System.out.println("id is "+ id);
		Customer customerById = new Customer();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customer WHERE customer_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String str = new String(rs.getBytes(4));
			
			customerById.setAccountid(rs.getLong(1));
			customerById.setFirst1(rs.getString(2));
			customerById.setLast1(rs.getString(3));
			customerById.setPw1(str);
			customerById.setAccountid(rs.getLong(5));
			

			customerById.setCustomerid(rs.getLong(1));

		}catch(SQLException e) {
			e.printStackTrace();
		}

		//System.out.println(customerById);
		return customerById;
	}

	@Override
	public Customer selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(long customerID, long accountID) {

		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "UPDATE customer SET accountid=? WHERE customerid=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, customerID);
			ps.setLong(2, accountID);


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
	public boolean deleteCustomer(Customer customer) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){

			String sql="DELETE FROM customer WHERE customer_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, customer.getCustomerid());
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

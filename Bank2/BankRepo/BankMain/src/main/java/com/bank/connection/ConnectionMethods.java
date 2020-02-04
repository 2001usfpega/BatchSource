package com.bank.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.bank.main.Customer;
import com.bank.main.Driver;

public class ConnectionMethods {
	protected Connection conn;
	private final static String url = System.getenv("BANK_DB_URL");
	private final static String username = System.getenv("BANK_DB_USERNAME");
	private final static String password = System.getenv("BANK_DB_PWORD");


	
	public static void getCustomers() {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = "SELECT * FROM customer_bank";
			PreparedStatement query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();
			 
			while (rs.next()) {
				Customer.custList.add(
						new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9))
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
//	public static void insertCustomer(int cusId, String cusName) {
//		try(Connection con = DriverManager.getConnection(url, userName, password)){
//			String sql = "Insert Into food(food_name, recipe) VALUES(?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1,  f_name);
//			ps.setString(2, f_recipe);
//			
//			int rowsChanged = ps.executeUpdate();
//			System.out.println("Rows changed " + rowsChanged);
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void insertCustomer(int cusId, String cusName, String cusPass, int accountEnabled, int cusApplied) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
		
			String sql = "Insert Into customer_bank(customerid, customername, cuspass, account_enabled, cus_applied) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			ps.setString(2, cusName);
			ps.setString(3, cusPass);
			ps.setInt(4, accountEnabled);
			ps.setInt(5, cusApplied);
			
			int rowsChanged = ps.executeUpdate();
			//System.out.println(rowsChanged);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	
	public static void insertNewCustomer(String cusName, String cusPass, int department) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
		
			String sql = "BEGIN INSERT Into customer_bank(customername, cuspass, department) VALUES(?,?,?) RETURNING customerid into ?; END;";
			
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setString(1, cusName);
			ps.setString(2, cusPass);
			ps.setInt(3, department);
			ps.registerOutParameter(4, Types.NUMERIC);
			
			
		ps.execute();
		System.out.println(ps.getInt(4));
		
	Driver.curCustomer =	new Customer(ps.getInt(4), cusName, cusPass, department);
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	public static void applyForAccount (String email, String address, String phone, int applied, int approved, int cusID) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE customer_bank SET email = ?, cusaddress = ?, cusphone = ?, cus_applied = ?, account_enabled =? where customerid=?";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, email);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setInt(4, applied);
			ps.setInt(5, approved);
			ps.setInt(6, cusID);
			ps.executeUpdate();
			
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void deposit(double deposit, int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "{call cus_deposit(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(2, deposit);
			cs.setInt(1, id);
			int rowsChanged = cs.executeUpdate();
			System.out.println("Rows changed " + rowsChanged);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void withdraw(double with, int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "{call cus_withdraw(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(2, with);
			cs.setInt(1, id);
			int rowsChanged = cs.executeUpdate();
			System.out.println("Rows changed " + rowsChanged);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewBalance(int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "Select accountbalance FROM account_bank WHERE c_fk=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			rs.next();			
			Driver.acctBalance = rs.getDouble(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	///employee methods
	
	public static  void approveAccounts() {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM customer_bank WHERE cus_applied =1";
			PreparedStatement query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();
			 
			while (rs.next()) {
				Customer.pendingList.add(
						new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void accountApproved(int cusId) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE customer_bank SET account_enabled = 1, cus_applied = 0 where customerid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, cusId);
			ps.executeUpdate();
			
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void accountCreated(int cusId) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO account_bank(accountbalance, c_fk) VALUES(0, ?)";
					PreparedStatement ps = conn.prepareCall(sql);
					ps.setInt(1, cusId);
					ps.executeUpdate();
					ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

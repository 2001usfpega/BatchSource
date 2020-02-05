package com.revature.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCalls {
	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("TRAINING_DB_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

	public static void insertCustomer(Customer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO customer(customer_id, username, password) Values(null, ?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getUname());
			ps.setString(2, a.getPword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Customer getCustomer(String a) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM customer WHERE username = '" + a + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	public static void createAccount(Customer a, double b) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO account(accountid, balance, customerid) Values(null, ?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, b);
			ps.setInt(2, a.getCustomerid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void depositToAccount(Customer a, double b) {
		double newBalance=0;
		Account newAccount = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE customerid = '" + a.getCustomerid() + "'";
			//System.out.println(newAccount.getBalance()+" "+ newAccount.getAccountid());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("Whattt");
			if (rs.next()) {
				System.out.println("BRuhhhh");
				newAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				System.out.println("Your current balance is "+newAccount.getBalance());
				newBalance = b+newAccount.getBalance();
				sql ="update account set balance ="+newBalance+"where accountid ="+newAccount.getAccountid();
				System.out.println("Succes: Your new balancer is "+newBalance);
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			else {
				System.out.println("You must have an account to deposit. Please create a new account on the next menu by pressing 1.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void withdrawFromAccount(Customer a, Double b) { 
		
		double newBalance=0;
		Account newAccount = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE customerid = '" + a.getCustomerid() + "'";
			//System.out.println(newAccount.getBalance()+" "+ newAccount.getAccountid());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				newAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				System.out.println("Your current balance is "+newAccount.getBalance());
				if(newAccount.getBalance()-b <0) {
					System.out.println("Invalid amount. Please enter a amount less than your current balance.");
				}
				newBalance = newAccount.getBalance()-b;
				sql ="update account set balance ="+newBalance+"where accountid ="+newAccount.getAccountid();
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
				System.out.println("Success: Your new balancer is "+newBalance);
			}
			else {
				System.out.println("We're experiencing technical difficulties currently.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void deleteAccount(Customer a) {
		double newBalance=0;
		Account newAccount = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE customerid = '" + a.getCustomerid() + "'";
			//System.out.println(newAccount.getBalance()+" "+ newAccount.getAccountid());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				newAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				System.out.println("Your current balance is "+newAccount.getBalance());
				if(newAccount.getBalance()!=0) {
					System.out.println("You must have a balance of zero to close an account. we'll first first withdraw for you the amount: "+newAccount.getBalance());
				}
				newBalance = 0;
				sql ="update account set balance ="+newBalance+"where accountid ="+newAccount.getAccountid();
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
				sql="delete from account where accountid = "+newAccount.getAccountid();
				ps.executeUpdate(sql);
				System.out.println("Success: We have close your requested account.");
			}
			else {
				System.out.println("We're experiencing technical difficulties currently.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Admin getCustomerForAdmin(String a) {
		Admin cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM customer WHERE username = '" + a + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cust = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}
	
	public static Account getAccount(int a) {
		
		Account cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE customerid = " + a;

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cust = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	public static void adminDeposit(int myInt, double deposit) {
		
		double newBalance=0;
		Account newAccount = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE accountid = '" + myInt+ "'";
			//System.out.println(newAccount.getBalance()+" "+ newAccount.getAccountid());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				System.out.println("Your current balance is "+newAccount.getBalance());
				newBalance = deposit+newAccount.getBalance();
				sql ="update account set balance ="+newBalance+"where accountid ="+newAccount.getAccountid();
				System.out.println("Succes: Your new balancer is "+newBalance);
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			else {
				System.out.println("You must have an account to deposit. Please create a new account from the admin menu.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void adminWithdrawal(int acid, double withdrawal) {
	
		double newBalance=0;
		Account newAccount = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE accountid = '" + acid + "'";
			//System.out.println(newAccount.getBalance()+" "+ newAccount.getAccountid());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				newAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				System.out.println("Your current balance is "+newAccount.getBalance());
				if(newAccount.getBalance()-withdrawal <0) {
					System.out.println("Invalid amount. Please enter a amount less than your current balance.");
				}
				newBalance = newAccount.getBalance()-withdrawal;
				sql ="update account set balance ="+newBalance+"where accountid ="+newAccount.getAccountid();
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
				System.out.println("Success: Your new balancer is "+newBalance);
			}
			else {
				System.out.println("We're experiencing technical difficulties currently.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void adminDelete(int cid) {
		
		double newBalance=0;
		Account newAccount = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "Select * FROM account WHERE customerid = '" + cid + "'";
			//System.out.println(newAccount.getBalance()+" "+ newAccount.getAccountid());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				System.out.println("Your current balance is "+newAccount.getBalance());
				if(newAccount.getBalance()!=0) {
					System.out.println("You must have a balance of zero to close an account. we'll first first withdraw for you the amount: "+newAccount.getBalance());
				}
				newBalance = 0;
				sql ="update account set balance ="+newBalance+"where accountid ="+newAccount.getAccountid();
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
				sql="delete from account where accountid = "+newAccount.getAccountid();
				ps.executeUpdate(sql);
				System.out.println("Success: We have close your requested account.");
			}
			else {
				System.out.println("We're experiencing technical difficulties currently.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}







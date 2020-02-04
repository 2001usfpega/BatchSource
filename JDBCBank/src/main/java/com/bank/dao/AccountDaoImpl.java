package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.account.Account;
import com.bank.user.Customer;

public class AccountDaoImpl implements AccountDao {
	
	private static String url= System.getenv("TRAINING_DB_URL");
	private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");

	@Override
	public boolean insertAccount(Customer c) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "{ call new_account(?,null) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, c.getUserID());
			
			if(cs.executeUpdate()>0){
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean insertAccount(Customer a,Customer b) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "{ call new_account(?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getUserID());
			cs.setInt(2, b.getUserID());
			
			if(cs.executeUpdate()>0){
				return true;
			}			
			//System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM accounts";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public List<Account> selectAllAccountsForUser(Customer c) {
		List<Account> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "SELECT * FROM accountholders INNER JOIN accounts ON accounts.accountid = accountholders.accountid WHERE customerid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getUserID());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(3), rs.getDouble(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account selectByAccountId(int id) {
		//Account account = null;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			
			String sql=  "SELECT * FROM accounts WHERE customerid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Account(rs.getInt(1), rs.getDouble(2));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean transferMoney(Account a, Account b) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "{ call transfer_money(?,?,?,?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getAccNum());
			cs.setDouble(2, a.getBalance());
			cs.setInt(3, b.getAccNum());
			cs.setDouble(4, b.getBalance());
			
			if(cs.executeUpdate()>0){
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			//String sql= "{ call transfer_money(?,?,?,?) }";
			String sql= "UPDATE accounts SET balance=? WHERE accountid=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccNum());
			
			if(ps.executeUpdate()>0){
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			
			//kill the children
			String sql="{ call kill_account(?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getAccNum());
			if(cs.executeUpdate()>0) {
				return true;
			}			
			//System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}

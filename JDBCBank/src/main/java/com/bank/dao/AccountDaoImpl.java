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
			cs.executeUpdate();
			
			//System.out.println(sql);
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
			
			cs.executeUpdate();
			
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
			
			String sql=  "SELECT * FROM accounts WHERE customerid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getUserID());
			
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
	public Account selectByAccountId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean transferMoney(Account a, Account b, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(Account a, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

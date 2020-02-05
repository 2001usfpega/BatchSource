package com.aj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aj.models.Account;
import com.aj.utils.DaoConUtil;

public class AccDAOImpl implements AccDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	
	
	@Override
	public void createNewAcc(Account acc) {

		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "INSERT INTO account VALUES "
					+ "(?, ?, ?, ?)";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,  acc.getAcc_id());
			stmt.setString(2,  acc.getType());
			stmt.setString(3,  acc.getCust_id());
			stmt.setFloat(4,  acc.getBalance());
			
			stmt.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Account successfully created.");
	}

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "SELECT * FROM account";
			
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Account acc = new Account();
				
				acc.setAcc_id(rs.getString(1));
				acc.setType(rs.getString(2));
				acc.setCust_id(rs.getString(3));
				acc.setBalance(rs.getFloat(4));
				
				accounts.add(acc);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Account a : accounts) {
			System.out.println(a);
		}
		
		return accounts;
	}

	@Override
	public Account selectAccByAccId(String acc_id) {
		Account acc = new Account();
		
		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "SELECT * FROM account WHERE acc_id = ?";
			
			stmt.setString(1, acc_id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				acc.setAcc_id(rs.getString(1));
				acc.setType(rs.getString(2));
				acc.setCust_id(rs.getString(3));
				acc.setBalance(rs.getFloat(4));
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
	}

	@Override
	public List<Account> selectAccByCustId(Long cust_id) {
		List<Account> accounts = new ArrayList<>();
		
		try {
			connection = DaoConUtil.getConnection();
			
			String sql = "SELECT * FROM account WHERE fk_cust_id = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, cust_id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Account acc = new Account();
				
				acc.setAcc_id(rs.getString(1));
				acc.setType(rs.getString(2));
				acc.setCust_id(rs.getString(3));
				acc.setBalance(rs.getFloat(4));
			
				accounts.add(acc);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public void updateAccount(Account acc) {
		try {
			connection = DaoConUtil.getConnection();
			String sql = "UPDATE account SET balance=? "
					+ "WHERE acc_id=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setFloat(1, acc.getBalance());
			stmt.setString(2, acc.getAcc_id());
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(int acc_id) {
		// TODO Auto-generated method stub
	}

}

package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;

public class AccountDaoImpl implements AccountDao {

	@Override
	public Account getAccount(int accountNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccount(int accountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAccount(int customerID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			/*
			 * prepared statements guard against sql injections because it is pre-compiled
			 * (Which also makes it faster)
			 */

			String sql = "INSERT INTO accounts (accountid,customerid,balance) VALUES (null, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, customerID);
			ps.setInt(2, 0);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean updateAccount(Account account) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE accounts SET balance = " + account.getBalance() + " WHERE accountid = " + account.getAccountID();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Account> getAccountsByID(int customerID) {
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM accounts WHERE customerid = " + customerID;

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

}

/*package com.revature.maven.bankapp.groupbankapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.maven.bankapp.groupbankapp.BankAccount;


public class BankAcccountDAOImpl implements BankAppDAO {
	
	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");
	

	@Override
	public int insertAccount(BankAccount account) {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO revature_bank";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(
						new BankAccount(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public List<BankAccount> selectAllAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM revature_bank";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(
						new BankAccount(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public BankAccount selectAccountByNumber(int id) {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM revature_bank";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(
						new BankAccount(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public BankAccount selectAccountByName(String name) {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM revature_bank";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(
						new BankAccount(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateBankAccount(BankAccount account) {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM revature_bank";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(
						new BankAccount(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int deleteFood(BankAccount account) {
		List<BankAccount> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM revature_bank";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(
						new BankAccount(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

}
*/
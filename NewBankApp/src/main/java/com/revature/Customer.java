package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer implements User {

	private String userName;
	private String userPassword;
	private int custID;
	private String fName;
	private String lName;

	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");

	public Customer() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	private List<Account> bankAccounts = new ArrayList<>();

	public Customer(String userName, String password, int custID) {
		super();
		this.userName = userName;
		this.userPassword = password;
		this.custID = custID;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", password=" + password + ", custID=" + custID + ", bankAccounts="
				+ bankAccounts + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public List<Account> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<Account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public void getAccount(int acctID) {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM revature_bank_account WHERE rb_acct_id="+acctID;
			PreparedStatement prepState = connection.prepareStatement(sql);
			ResultSet revAccnts = prepState.executeQuery();
			while (revAccnts.next()) {
				int id = revAccnts.getInt("rb_acct_id");
				String accntName = revAccnts.getString("account_name");
				String accntNum = revAccnts.getString("account_number");
				int bal = revAccnts.getInt("balance");
				System.out.println(id + " " + accntName + " " + accntNum + " " + bal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getBalance(int acctID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT balance FROM revature_bank_account WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int balance = rs.getInt("balance");
				System.out.println("Your balance is " + balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(int acctID, int withdraw) {
		// int withdraw = Integer.parseInt(bankAccounts.get(index).getPrimaryKey());
		int balance = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT balance FROM revature_bank_account WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getInt("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		balance -= withdraw;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE revature_bank_account SET balance=" + balance + " WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			int newBalance = ps.executeUpdate();
			System.out.println("You have withdrawn $" + withdraw + " and your new balance is $" + balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(int acctID, int deposit) {
		// int deposit = Integer.parseInt(bankAccounts.get(index).getPrimaryKey());
		int balance = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT balance FROM revature_bank_account WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getInt("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		balance += deposit;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE revature_bank_account SET balance=" + balance + " WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			int newBalance = ps.executeUpdate();
			System.out.println("You deposited $" + deposit + " and your new balance is $" + balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void makeTransfer(int acctID1, int acctID2, int transfer) {
		int balance1 = 0;
		int balance2 = 0;
		try (Connection conn1 = DriverManager.getConnection(url, username, password)) {
			String sql1 = "SELECT balance FROM revature_bank_account WHERE rb_acct_id=" + acctID1;
			PreparedStatement ps1 = conn1.prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				balance1 = rs1.getInt("balance");
			}
		}catch (SQLException e1) {
				e1.printStackTrace();
			}
			try (Connection conn2 = DriverManager.getConnection(url, username, password)) {
				String sql2 = "SELECT balance FROM revature_bank_account WHERE rb_acct_id=" + acctID2;
				PreparedStatement ps2 = conn2.prepareStatement(sql2);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					balance2 = rs2.getInt("balance");
				}
			}catch (SQLException e1) {
					e1.printStackTrace();
				}
				balance1+=transfer;
				balance2-=transfer;
				try (Connection conn3 = DriverManager.getConnection(url, username, password)) {
					String sql3 = "UPDATE revature_bank_account SET balance=" + balance1 + " WHERE rb_acct_id=" + acctID1;
					PreparedStatement ps3 = conn3.prepareStatement(sql3);
					int newBalance1 = ps3.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					String sql4 = "UPDATE revature_bank_account SET balance=" + balance2 + " WHERE rb_acct_id=" + acctID2;
					PreparedStatement ps4 = conn.prepareStatement(sql4);
					int newBalance2 = ps4.executeUpdate();
					System.out.println("You have transferred $"+transfer+" from "+acctID2+" into "+acctID1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

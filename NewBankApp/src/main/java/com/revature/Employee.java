package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Employee implements User {

	private String userName;
	private int custPassword;
	private int empID;
	private String fName;
	private String lName;

	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");

	public Employee() {

	}

	public Employee(String userName, int pword, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.custPassword = pword;
		this.fName = firstName;
		this.lName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password + ", empID=" + empID + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return custPassword;
	}

	public void setPassword(int password) {
		this.custPassword = password;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
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
		if (withdraw <= 0) {
			System.out.println("Please enter a valid withdrawal amount");
		} else if (withdraw <= balance) {
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
	}

	@Override
	public void deposit(int acctID, int deposit) {
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
		if (deposit > 0) {
			balance += deposit;
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				String sql = "UPDATE revature_bank_account SET balance=" + balance + " WHERE rb_acct_id=" + acctID;
				PreparedStatement ps = conn.prepareStatement(sql);
				int newBalance = ps.executeUpdate();
				System.out.println("You have deposited $" + deposit + " and your new balance is $" + balance);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Please enter a valid deposit amount");
		}
	}

	@Override
	public void getAccount(int x) {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM revature_bank_account";
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

	public void getEmployee() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM revature_employees";
			PreparedStatement prepState = connection.prepareStatement(sql);
			ResultSet revEmps = prepState.executeQuery();
			while (revEmps.next()) {
				int id = revEmps.getInt("rb_emp_id");
				String uName = revEmps.getString("user_name");
				int pwrd = revEmps.getInt("password");
				String fName = revEmps.getString("first_name");
				String lName = revEmps.getString("last_name");
				System.out.println(id + " " + uName + " " + pwrd + " " + fName + " " + lName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertEmp(String userName, int pword, String fName, String lName) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO revature_employees (rb_emp_id, user_name, password, first_name, last_name) VALUES(null, ?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, pword);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.executeUpdate();
			System.out.println("You have created a new employee record.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertAccount(String accntName, long accntNum, int balance) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO revature_bank_account (rb_acct_id, account_name, account_number, balance) VALUES(null,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accntName);
			ps.setLong(2, accntNum);
			ps.setInt(3, balance);
			ps.executeUpdate();
			System.out.println("You have created a new account.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAccnt(int acctID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "DELETE FROM revature_bank_account WHERE rb_acct_id=" + acctID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("You have deleted an account with Account ID " + acctID);
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
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try (Connection conn2 = DriverManager.getConnection(url, username, password)) {
			String sql2 = "SELECT balance FROM revature_bank_account WHERE rb_acct_id=" + acctID2;
			PreparedStatement ps2 = conn2.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				balance2 = rs2.getInt("balance");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		balance1 += transfer;
		balance2 -= transfer;
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
			System.out.println("You have transferred $" + transfer + " from " + acctID2 + " into " + acctID1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCustomer(String uName, double pword, String fName, String lName) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call insert_emp_null_ (?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, uName);
			cs.setDouble(2, pword);
			cs.setString(3, fName);
			cs.setString(4, lName);
			int status = cs.executeUpdate();
			System.out.println("New Customer has been added to the table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getCustomer() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM revature_customers";
			PreparedStatement prepState = connection.prepareStatement(sql);
			ResultSet revEmps = prepState.executeQuery();
			while (revEmps.next()) {
				int id = revEmps.getInt("rb_cust_id");
				String uName = revEmps.getString("user_name");
				int pwrd = revEmps.getInt("password");
				String fName = revEmps.getString("first_name");
				String lName = revEmps.getString("last_name");
				System.out.println(id + " " + uName + " " + pwrd + " " + fName + " " + lName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

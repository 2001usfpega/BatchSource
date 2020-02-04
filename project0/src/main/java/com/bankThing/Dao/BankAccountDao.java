package com.bankThing.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bankThing.BankAccount;
import com.bankThing.Customer;
import com.bankThing.Employee;

public class BankAccountDao implements BankAccountDaoInterface {

	private static String url= System.getenv("DB_URL");
	private static String username= System.getenv("DB_bankThing_userName");
	private static String password=System.getenv("DB_pw");

	@Override
	public int insertBankAccount( ) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			/*
			 * prepared statement guard against sql injection because it is pre-compiled
			 *  (which also makes it faster)
			 */
			String sql= "INSERT INTO bank_account(checking, saving, credit_1, credit_2, credit_3) VALUES(?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, 0); //first question mark
			ps.setDouble(2, 0);  //second question mark
			ps.setDouble(3, 0); // un
			ps.setDouble(4, 0);
			ps.setDouble(5, 0);

			ps.executeUpdate();
			return 1;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<BankAccount> selectAllBankAccount() {
		List<BankAccount> bankAccounts = new ArrayList<>();


		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM bank_account ORDER BY account_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) {

				bankAccounts.add(
						new BankAccount( rs.getLong(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6) )
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		for (BankAccount  eachone: bankAccounts) {
			System.out.println(eachone);
		}

		return bankAccounts;
	}


	@Override
	public BankAccount selectBankAccountById(long id) {

		BankAccount bankAccountById = new BankAccount();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM bank_account WHERE account_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();

			bankAccountById.setAccountid(rs.getLong(1));
			bankAccountById.setChecking(rs.getDouble(2));
			bankAccountById.setSaving(rs.getDouble(3));
			bankAccountById.setCredit1(rs.getDouble(4));
			bankAccountById.setCredit2(rs.getDouble(5));
			bankAccountById.setCredit3(rs.getDouble(6));

		}catch(SQLException e) {
			e.printStackTrace();
		}

		//System.out.println(customerById);
		return bankAccountById;
	}

	@Override
	public BankAccount selectBankAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean updateBankAccount(BankAccount bankAccount) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "UPDATE customers SET checking=?, saving=?, credit_1=?, credit_2=?, credit_3 WHERE account_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, bankAccount.getChecking());
			ps.setDouble(2, bankAccount.getSaving());
			ps.setDouble(3, bankAccount.getCredit1());
			ps.setDouble(4, bankAccount.getCredit2());
			ps.setDouble(5, bankAccount.getCredit3());
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
	public boolean deleteBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return true;
	}

}

package com.aj.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aj.model.Expense;
import com.aj.utils.DAOxUtil;

public class ExpenseDAOImpl implements ExpenseDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	List<Expense> expenses = new ArrayList<>();

	public void createNewExpense(Expense ex) {
		try {
			connection = DAOxUtil.getConnection();
			
			String sql = "INSERT INTO expenses VALUES (?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, ex.getExp_id());
			stmt.setLong(2, ex.getFk_e_id());
			stmt.setString(3, ex.getType());
			stmt.setString(4, ex.getState());
			stmt.setFloat(5, ex.getAmount());
			
			stmt.executeQuery();
			System.out.println("Successfully submitted new expense.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Expense> selectAllExpenses() {
		
		try {
			connection = DAOxUtil.getConnection();
			
			String sql = "SELECT * FROM expenses";
			
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Expense exp = new Expense();
				
				exp.setExp_id(rs.getLong(1));
				exp.setFk_e_id(rs.getLong(2));
				exp.setType(rs.getString(3));
				exp.setState(rs.getString(4));
				exp.setAmount(rs.getFloat(5));
				
				expenses.add(exp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expenses;
	}

	public List<Expense> selectPendingExpenses() {
		try {
			connection = DAOxUtil.getConnection();
			
			String sql = "SELECT * WHERE state = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, "pending");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Expense exp = new Expense();
				
				exp.setExp_id(rs.getLong(1));
				exp.setFk_e_id(rs.getLong(2));
				exp.setType(rs.getString(3));
				exp.setState(rs.getString(4));
				exp.setAmount(rs.getFloat(5));
				
				expenses.add(exp);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return expenses;
	}

	public String updateExpense(Expense ex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteExpense(Expense ex) {
		// TODO Auto-generated method stub
		return null;
	}

}

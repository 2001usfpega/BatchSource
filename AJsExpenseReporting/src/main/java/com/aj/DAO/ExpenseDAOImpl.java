package com.aj.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aj.model.Expense;
import com.aj.model.User;
import com.aj.utils.DAOxUtil;

public class ExpenseDAOImpl implements ExpenseDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	List<Expense> expenses = new ArrayList<>();

	public void createNewExpense(Expense ex, User us) {
		try {
			connection = DAOxUtil.getConnection();
			
			//String sql = "INSERT INTO expenses VALUES (null, null, 1, null, null, 100.87, 'pending', 'desc')";
			
			String sql = "INSERT INTO expenses VALUES (null, 143, ?, null, null, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			System.out.println(ex);
			//stmt.setInt(1, ex.getExp_id());
			//stmt.setInt(1, us.getU_id());
			stmt.setInt(1, ex.getType());
			//stmt.setDate(3, ex.getSubmitted());
			//stmt.setDate(4, ex.getResolved());
			stmt.setFloat(2, ex.getAmount());
			stmt.setString(3, ex.getState());
			stmt.setString(4, ex.getDesc());
			
			if(stmt.executeUpdate() > 0) {
				System.out.println("Successfully submitted new expense.");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("In create new expense");
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
				
				exp.setExp_id(rs.getInt(1));
				exp.setFk_e_id(rs.getInt(2));
				exp.setType(rs.getInt(3));
				exp.setSubmitted(rs.getDate(4));
				exp.setResolved(rs.getDate(5));
				exp.setAmount(rs.getFloat(6));
				exp.setState(rs.getString(7));
				exp.setDesc(rs.getString(8));
				
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
				
				exp.setExp_id(rs.getInt(1));
				exp.setFk_e_id(rs.getInt(2));
				exp.setType(rs.getInt(3));
				exp.setSubmitted(rs.getDate(4));
				exp.setResolved(rs.getDate(5));
				exp.setAmount(rs.getFloat(6));
				exp.setState(rs.getString(7));
				exp.setDesc(rs.getString(8));
				
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

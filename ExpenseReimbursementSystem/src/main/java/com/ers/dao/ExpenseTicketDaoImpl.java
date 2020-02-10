package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.Employee;
import com.ers.model.ExpenseTicket;

public class ExpenseTicketDaoImpl implements ExpenseTicketDao {

	@Override
	public ExpenseTicket getExpenseTicketById(int ticketid) {
		ExpenseTicket et = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM expenseTicket WHERE ticketid = " + ticketid;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				et = new ExpenseTicket(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error getting ticket (TICKETID)", e);
		}
		return et;
	}

	@Override
	public List<ExpenseTicket> getExpenseTicketsByUserId(int userid) {
		List<ExpenseTicket> tickets =  new ArrayList<>();;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM expenseTicket WHERE userid = " + userid;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tickets.add(new ExpenseTicket(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error getting ticket (USERID)", e);
		}
		return tickets;
	}

	@Override
	public List<ExpenseTicket> getAllExpenseTickets() {
		List<ExpenseTicket> tickets =  new ArrayList<>();;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM expenseTicket";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tickets.add(new ExpenseTicket(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error getting ticket (ALL)", e);
		}
		return tickets;
	}

	@Override
	public List<ExpenseTicket> getAllExpenseTicketsByType(int type) {
		List<ExpenseTicket> tickets = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM expenseTicket WHERE tickettype = " + type;
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tickets.add(new ExpenseTicket(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error getting ticket (BY TYPE)", e);
		}
		return tickets;
	}

	@Override
	public void createExpenseTicket(ExpenseTicket et) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "INSERT INTO expenseTicket (ticketid,ticketType,amount,datesubmitted,dateresolved,status,description,userid) "
					+ "VALUES (null, ?, ?, ?, null, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, et.getType());
			ps.setDouble(2, et.getAmount());
			ps.setDate(3, et.getDateSubmitted());
			ps.setString(4, et.getStatus());
			ps.setString(5, et.getDescription());
			ps.setInt(6, et.getUserid());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error creating ticket", e);
		}

	}

	@Override
	public void updateExpenseTicket(ExpenseTicket et) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println(et.getDateResolved());
			String sql = "UPDATE expenseTicket SET dateresolved = TO_DATE('" + et.getDateResolved() + "','YYYY-MM-DD'), status = '" + 
			et.getStatus() +"' WHERE ticketid = " + et.getTicketid();
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error updating ticket", e);
		}
	}

	@Override
	public void deleteExpenseTicket(ExpenseTicket et) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "DELETE FROM expenseTicket WHERE ticketid = " + et.getTicketid();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error deleting ticket", e);
		}

	}

	@Override
	public void updateFullTicket(ExpenseTicket et) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println(et.getDateResolved());
			String sql = "UPDATE expenseTicket SET tickettype =  " + et.getType()+ ", amount = " + 
			et.getAmount() + ", description = '" + et.getDescription() + "' WHERE ticketid = " + et.getTicketid();
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error updating ticket (FULL)", e);
		}
		
	}

}

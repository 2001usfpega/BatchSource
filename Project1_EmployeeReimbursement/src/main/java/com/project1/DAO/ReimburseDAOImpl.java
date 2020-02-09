package com.project1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.project1.Models.RequestImpl;
import com.project1.main.LoggerExample;

public class ReimburseDAOImpl {
	public static String url =System.getenv("p1_url");
	public static String username =System.getenv("p1_username");
	public static String password =System.getenv("p1_password");
	static RequestImpl requestRec = new RequestImpl();
	final static Logger logg= Logger.getLogger(LoggerExample.class);
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	static Date date = new Date();
	

	public ArrayList<RequestImpl> employeeRecords(int emp_id){
		ArrayList<RequestImpl> list = new ArrayList<RequestImpl>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e1) {
			logg.error("error in driver registaration",e1);
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM re_request WHERE emp_id =? ORDER BY request_id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, emp_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	requestRec = new RequestImpl();
            	requestRec.setRequest_id(rs.getInt(1));
            	requestRec.setEmp_id(rs.getInt(2));
            	requestRec.setStatues(rs.getString(3));
            	requestRec.setRe_type(4);
            	requestRec.setAmount(rs.getDouble(5));
            	requestRec.setDate_sub(rs.getString(6));
            	requestRec.setDate_res(rs.getString(7));
            	requestRec.setInfo(rs.getString(8));
            	list.add(requestRec);
            }
            return list;
		}catch(SQLException e) {
			logg.error("error in driver connection",e);
			e.printStackTrace();
        }
		return list;
	}
	public static ArrayList<RequestImpl> readRecords() { 
		//returns an array of all records in the re_request table
		ArrayList<RequestImpl> list = new ArrayList<RequestImpl>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e1) {
			logg.error("error in driver registaration",e1);
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM re_request ORDER BY request_id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	requestRec = new RequestImpl();
            	requestRec.setRequest_id(rs.getInt(1));
            	requestRec.setEmp_id(rs.getInt(2));
            	requestRec.setStatues(rs.getString(3));
            	requestRec.setRe_type(4);
            	requestRec.setAmount(rs.getDouble(5));
            	requestRec.setDate_sub(rs.getString(6));
            	requestRec.setDate_res(rs.getString(7));
            	requestRec.setInfo(rs.getString(8));
            	list.add(requestRec);
            }
            return list;
		}catch(SQLException e) {
			logg.error("error in driver connection",e);
			e.printStackTrace();
        }
		return list;
	}
	public static void newRecord(int emp_id,int re_type, double amount, String info) {
		//Adds a new record to the table
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e1) {
			logg.error("error in driver registaration",e1);
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql ="INSERT INTO re_request"
					+ "(emp_id, status, re_type, amount,date_sub,date_res, info) "
					+ "VALUES(?,'pending',?,?,?,null,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ps.setInt(2, re_type);
			ps.setDouble(3, amount);
			ps.setString(4, dateFormat.format(date));
			ps.setString(5,info);
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			logg.error("error in driver connection",e);
			e.printStackTrace();
		}
		
	}
	public static void updateRecord(String status, int id) {
		//updates the record to show if i twas approved or denied and at what date
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e1) {
			logg.error("error in driver registaration",e1);
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql ="UPDATE re_request SET status=?,date_res=? WHERE request_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,status);
            ps.setString(2, dateFormat.format(date));
            ps.setInt(3, id);
            
            System.out.println(id);
            System.out.println(status);
            ResultSet rs = ps.executeQuery();	
		} catch (SQLException e) {
			logg.error("error in driver connection",e);
			e.printStackTrace();
		}
		
	}
}

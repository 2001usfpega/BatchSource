package com.revature.DAO;

import com.revature.logging.ExpenseLogger;
import com.revature.model.Employee;
import com.revature.model.ExpenseReimbursement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ExpenseReimbursementDAOImplementation implements ExpenseReimbursementDAO {
	
	static final Logger LOGGER = Logger.getLogger(ExpenseLogger.class);
			
    private final Connection con;

    public ExpenseReimbursementDAOImplementation(String dbPropertiesPath) throws SQLException, IOException {
        Map<String, String> settings = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(dbPropertiesPath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] setting = line.split(" ");

            settings.put(setting[0], setting[1]);
        }

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        con = DriverManager.getConnection("jdbc:oracle:thin:@" + settings.get("url") + ":1521:ORCL",
                settings.get("user"), settings.get("pass"));
    }

    @Override
    public void reimburseLogIn(String uName, String pWord) {
        /*
         * try { String sql =
         * "SELECT user_name, password FROM revature_customers WHERE rb_cust_id=" +
         * customerIDInfo; PreparedStatement prepState = con.prepareStatement(sql);
         * ResultSet revAccnts = prepState.executeQuery(); if (revAccnts.next()) {
         * custUN = revAccnts.getString("user_name"); pwrd =
         * revAccnts.getString("password"); if (custUN.equals(custUseNm) &&
         * pwrd.equals(custPWRD)) { System.out.println("Thank you for logging in");
         * return; } } System.out.println("You're login credentials are invalid");
         * NewBankAppSwitch.showCustomerMenu();
         *
         * } catch (SQLException e) { e.printStackTrace(); }
         */
    }

    @Override
    public void employeeSubmitReimburse(int reimburseType, double amount, String empForKey, String description) {
        try {
            String sql = "INSERT INTO reimburse(r_type, amount, sub_date, fk_emp_id, status, description) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, reimburseType);
            ps.setDouble(2, amount);
            ps.setDate(3, new Date(System.currentTimeMillis()));
            ps.setString(4, empForKey);
            ps.setInt(5, 1);
            ps.setString(6, description);
            ps.executeUpdate();
            LOGGER.info("Reimbursement request submitted");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Error submitting reimbursement", e);
        }
    }

    @Override
    public List<ExpenseReimbursement> viewAllReimburseReq() {
        try {
            String sql = "SELECT * FROM reimburse a INNER JOIN employee b ON b.emp_id = a.fk_emp_id";
            PreparedStatement prepstate = con.prepareStatement(sql);
            ResultSet rset = prepstate.executeQuery();
            List<ExpenseReimbursement> allReimbursements = new ArrayList();
            while (rset.next()) {
                int reimbursementID = rset.getInt("reim_id");
                String fName = rset.getString("fname");
                String lName = rset.getString("lname");
                String rType = rset.getString("r_type");
                Double amount = rset.getDouble("amount");
                java.sql.Date subDate = rset.getDate("sub_date");
                String empFKID = rset.getString("emp_id");
                java.sql.Date decDate = rset.getDate("dec_date");
                String manFKID = rset.getString("fk_man_id");
                int status = rset.getInt("status");
                String desc = rset.getString("description");
                allReimbursements.add(new ExpenseReimbursement(reimbursementID, fName, lName, rType, amount, subDate, decDate, status, desc));
            }
            return allReimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Error viewing all reimbursements", e);
        }
        return Collections.emptyList();
    }

    @Override
    public void resolveReimburse(String finManForeignKey, boolean approved, int reimburseID) {
        try {
            PreparedStatement prepstate = con.prepareStatement("UPDATE reimburse SET fk_man_id=? ,status=?, dec_date=? WHERE reim_id=?");

            prepstate.setString(1, finManForeignKey);
            prepstate.setInt(2, approved ? 2 : 0);
            prepstate.setDate(3, new Date(System.currentTimeMillis()));
            prepstate.setInt(4, reimburseID);
            prepstate.executeUpdate();
            LOGGER.info("Reimbursement resolved");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Error resolving reimbursement", e);
        }
    }

    @Override
    public List<ExpenseReimbursement> viewPending() {
        try {
            String sql = "SELECT * FROM reimburse a INNER JOIN employee b ON b.emp_id = a.fk_emp_id";
            PreparedStatement prepstate = con.prepareStatement(sql);
            ResultSet rset = prepstate.executeQuery();
            List<ExpenseReimbursement> pendingReimbursements = new ArrayList();
            while (rset.next()) {
                int reimbursementID = rset.getInt("reim_id");
                String fName = rset.getString("fname");
                String lName = rset.getString("lname");
                String rType = rset.getString("r_type");
                double amount = rset.getDouble("amount");
                java.sql.Date subDate = rset.getDate("sub_date");
                java.sql.Date decDate = rset.getDate("dec_date");
                String manFK_id = rset.getString("fk_man_id");
                int status = rset.getInt("status");
                String desc = rset.getString("description");
                pendingReimbursements.add(new ExpenseReimbursement(reimbursementID, fName, lName, rType, amount, subDate, decDate, status, desc));
            }
            return pendingReimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Error viewing pending reimbursement", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Employee login(String emp_username, String emp_password) {
        try {String sql = "SELECT * FROM employee WHERE emp_uname='" + emp_username + "'";
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet result = prep.executeQuery();

            if (result.next()) {
                String empPassword = result.getString("emp_pWord");
                
                LOGGER.info("Login attempted");

                if (!emp_password.equals(empPassword)) {
                	LOGGER.warn("Login unsuccessful");
                    return null;
                }

                String empID = result.getString("emp_id");
                String empUName = result.getString("emp_uName");
                int empType = result.getInt("emp_type");
                String empFName = result.getString("fname");
                String empLName = result.getString("lname");

                return new Employee(empID, empUName, empPassword, empType, empFName, empLName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Error logging in", e);
        }
        return null;
    }
}
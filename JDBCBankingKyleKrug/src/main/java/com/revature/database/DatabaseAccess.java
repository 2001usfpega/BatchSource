package com.revature.database;
//Created By Kyle Krug
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.account.Customer;
import com.revature.account.Employee;

public class DatabaseAccess {

	
	public static String url =System.getenv("BANKING_URL");
	public static String username =System.getenv("BANKING_USERNAME");
	public static String password =System.getenv("BANKING_PASSWORD");
	public static DatabaseAccess db = new DatabaseAccess();
	
	public Customer getCustomer(String user_name , String user_pass) {
		// loads customer from database
		Customer customer = new Customer();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM customer WHERE username = ? and user_pass = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, user_pass);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
	            	customer.setId(rs.getInt(1));
	            	customer.setFirstname(rs.getString(2));
	            	customer.setLastname(rs.getString(3));
	            	customer.setAge(rs.getInt(4));
	            	customer.setGender(rs.getString(5));
	            	customer.setSsn(rs.getInt(6));
	            	customer.setUsername(rs.getString(7));
	            	customer.setPassword(rs.getString(8));
	            	customer.setApproved(rs.getBoolean(9));
	            	customer.setDisabled(rs.getBoolean(10));
	            	customer.setJointacc(rs.getBoolean(11));
	            	customer.setBalance_id(rs.getInt(12));
	            sql = "SELECT * FROM balance WHERE b_id = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setLong(1,customer.getBalance_id());
	            rs = ps.executeQuery();
	            while(rs.next()) {
	            	customer.setBalance(rs.getDouble(2));
	            }
            }
		}catch(SQLException e) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Cannot find account with that username and password, please try again");
        }
		return  customer;
	}
	public void newBalance(Customer customer) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "INSERT INTO balance (b_amount) values(0.0)";//Starts new customer off with a balance of zero
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Balance created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		newCustomer(customer);
	}
	public void newCustomer(Customer customer) {
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				String sql1 =  "INSERT INTO customer(first_name,last_name, age, gender, ssn, username, user_pass, "
		        		+ "approved, disabled,jointacc) values(?,?,?,?,?,?"
		        		+ ",?,?,?,?)";
		        PreparedStatement ps1 = conn.prepareStatement(sql1);
		        ps1.setString(1, customer.getFirstname());
		        ps1.setString(2, customer.getLastname());
		        ps1.setInt(3, customer.getAge());
		        ps1.setString(4, customer.getGender());
		        ps1.setInt(5, customer.getSsn());
		        ps1.setString(6, customer.getUsername());
		        ps1.setString(7, customer.getPassword());
		        ps1.setBoolean(8, customer.isApproved());
		        ps1.setBoolean(9, customer.isDisabled());
		        ps1.setBoolean(10, customer.isJointacc());
		        ResultSet rs1 = ps1.executeQuery();
		        System.out.println(customer.getId());
		        System.out.println("Inserted Customer");
			}catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("Account already exists that has this username, please try again");
			}	        
			linkCustomerNBalance(customer);
		
	}
	public void linkCustomerNBalance(Customer customer) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
		Customer customer2 = getCustomer(customer.getUsername(),customer.getPassword());
        String sql2 = "UPDATE customer SET balance_id = ( SELECT max(b_id) FROM balance ) WHERE customer_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setInt(1, customer2.getId());
        ResultSet rs2 = ps2.executeQuery();
        System.out.println("Done creating a new Customer");
        System.out.println("Congraulations on creating your new account");
		System.out.println("Please wait for an admin to approve you before proceeding\n\n");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateCustomer(Customer customer) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql1 =  "UPDATE customer\r\n" + 
					"SET\r\n" + 
					"first_name = ?,\r\n" + 
					"last_name = ?,\r\n" + 
					"age = ?,\r\n" + 
					" gender = ?,\r\n" + 
					"ssn = ?,\r\n" + 
					"username =?,\r\n" + 
					"user_pass =?,\r\n" + 
					"approved = ?,\r\n" + 
					"disabled = ?,\r\n" + 
					"jointacc =?,\r\n" + 
					"balance_id = ?\r\n" + 
					"WHERE customer_id = ?" ;
					
	        PreparedStatement ps1 = conn.prepareStatement(sql1);
	        ps1.setString(1, customer.getFirstname());
	        ps1.setString(2, customer.getLastname());
	        ps1.setInt(3, customer.getAge());
	        ps1.setString(4, customer.getGender());
	        ps1.setInt(5, customer.getSsn());
	        ps1.setString(6, customer.getUsername());
	        ps1.setString(7, customer.getPassword());
	        ps1.setBoolean(8, customer.isApproved());
	        ps1.setBoolean(9, customer.isDisabled());
	        ps1.setBoolean(10, customer.isJointacc());
	        ps1.setInt(11, customer.getBalance_id());
	        ps1.setInt(12, customer.getId());
	        ps1.executeQuery();

	        String sql = "UPDATE balance\r\n" + 
	        		"SET\r\n"
	        		+ "b_amount = ?"
	        		+ "WHERE b_id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setDouble(1, customer.getBalance());
	        ps.setDouble(2, customer.getBalance_id());
	        ps.executeQuery();
	        conn.setAutoCommit(false);
	        conn.commit();
	        System.out.println("Updated Customer");
		}catch (SQLException e) {
			e.printStackTrace();
		}	        
		
	}
	public void deleteCustomer(Customer customer ) {
	try(Connection conn = DriverManager.getConnection(url, username, password)){
				int b_id = customer.getBalance_id();
				int c_id = customer.getId();
				String sql =  "DELETE FROM customer WHERE customer_id = ?";
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setInt(1, c_id);
		        ps.execute();
		        
		        String sql2 = "DELETE FROM balance WHERE b_id =?";
		        PreparedStatement ps2 = conn.prepareStatement(sql2);
		        ps2.setInt(1, b_id);
		        ps2.execute();
		        System.out.println("Customer Deleted");
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Employee getEmployee(String user_name , String user_pass) {
		// loads customer from database
		Employee employee = new Employee();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM banking_employee WHERE username = ? and user_pass = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, user_pass);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
	            	employee.setId(rs.getInt(1));
	            	employee.setFirstname(rs.getString(2));
	            	employee.setLastname(rs.getString(3));
	            	employee.setAge(rs.getInt(4));
	            	employee.setGender(rs.getString(5));
	            	employee.setSsn(rs.getInt(6));
	            	employee.setUsername(rs.getString(7));
	            	employee.setPassword(rs.getString(8));
            }
		}catch(SQLException e) {
            e.printStackTrace();
        }
		return  employee;
	}
	public Customer employeeGetCustomer(int id ) {
		// loads customer from database from only the customer d
		Customer customer = new Customer();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM customer WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
	            	customer.setId(rs.getInt(1));
	            	customer.setFirstname(rs.getString(2));
	            	customer.setLastname(rs.getString(3));
	            	customer.setAge(rs.getInt(4));
	            	customer.setGender(rs.getString(5));
	            	customer.setSsn(rs.getInt(6));
	            	customer.setUsername(rs.getString(7));
	            	customer.setPassword(rs.getString(8));
	            	customer.setApproved(rs.getBoolean(9));
	            	customer.setDisabled(rs.getBoolean(10));
	            	customer.setJointacc(rs.getBoolean(11));
	            	customer.setBalance_id(rs.getInt(12));
	            sql = "SELECT * FROM balance WHERE b_id = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setLong(1,customer.getBalance_id());
	            rs = ps.executeQuery();
	            while(rs.next()) {
	            	customer.setBalance(rs.getDouble(2));
	            }
            }
		}catch(SQLException e) {
            e.printStackTrace();
        }
		return  customer;
	}
	public void unapprovedAccounts() {
		ArrayList<Integer> unapproved = new ArrayList<Integer>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM customer WHERE approved = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	unapproved.add(rs.getInt(1));
            }
            System.out.println("The following are the accounts waiting approval");
            for(int i : unapproved) {
            	System.out.print(i + ", ");
            }
            System.out.println("\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
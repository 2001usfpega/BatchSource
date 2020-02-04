package com.bankdao.interfaces.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.bank.bean.Account;
import com.bank.bean.Admin;
import com.bank.bean.Customer;
import com.bank.bean.Employee;
import com.bank.dao.interfaces.BankDao;
import com.bank.main.BankDriver;
import com.bank.service.Menu;

public class BankDaoImpl implements BankDao  {
	
	private static String url=System.getenv("BANK_DB_URL");
	
	private static String username1=System.getenv("BANK_DB_USERNAME"); 
	private static String password1=System.getenv("BANK_DB_PASSWORD");
	
	

	public void insertCustomer(Customer cust) {
		try {
			Connection conn=DriverManager.getConnection(url, username1, password1);
			String sql="insert into customer values (null,'Manuel','null','null','null','pass')";
			PreparedStatement st=conn.prepareStatement(sql);
			st.executeQuery();
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	
	

	public List<Customer> selectAllcustomer() {
		try (Connection conn=DriverManager.getConnection(url, username1, password1)){
		
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM customer");
		ResultSet rs= ps.executeQuery();
		//System.out.println(rs);
		while (rs.next()) {
			BankDriver.custList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)
					, rs.getString(4), rs.getString(5), rs.getString(6)));
			
			int custis=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			String address=rs.getString(4);
			String phone=rs.getString(5);
			
			String pass=rs.getString(6);
			
				//System.out.println(custis+" "+name+" "+email+" "+address+" "+phone+" "+" "+ pass);	
				//Customer.custList.add(new Customer(custis, name, email, address, phone, accnumb, pass));
				
		}
		//System.out.println(BankDriver.custList);
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return BankDriver.custList;
	}

	public  List<Employee> selectAllEmployee() {
		List<Employee> emplist=new ArrayList<Employee>();
		try(Connection conn=DriverManager.getConnection(url, username1, password1)){
			String sql="SELECT * FROM employee";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println(rs);
			//System.out.println("BankDaoImpl.selectAllEmployee()");
			while(rs.next()) {
				emplist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
			}
			
				
						
		}catch (Exception e) {
			// TODO: handle exception
		}
		return emplist;
	}




	@Override
	public void insertcustNamePass(String name, String pass)  {
		try (Connection conn=DriverManager.getConnection(url, username1, password1)){
			//System.out.println(name + pass);
			//System.out.println("in customer register dao");
	 String ql="BEGIN INSERT Into customer(customer_firstname, cust_password) VALUES(?,?) RETURNING customer_id into ?; END;";
	    
	 PreparedStatement ps=conn.prepareStatement(ql);
		ResultSet rs=ps.executeQuery();
	    CallableStatement st =conn.prepareCall(ql);
		

		st.setString(1, name);
		st.setString(2, pass);
		st.registerOutParameter(3, Types.NUMERIC);
		int count=st.executeUpdate();
		Menu.current_id=st.getInt(3);
		
		Menu.customer=new Customer (st.getInt(3),name,pass);
		
		st.close();
		//statement.executeQuery(sql);
		System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
	}

	@Override
	public void selectCustomerInfo(String name, String pass) {
		try (Connection conn=DriverManager.getConnection(url, username1, password1)){
			String ql="SELECT Customer_id from customer where customer_firstname=? and cust_password=?";
			
			PreparedStatement st =conn.prepareStatement(ql);
				

				st.setString(1, name);
				st.setString(2, pass);
				ResultSet rs=st.executeQuery();
				if( rs.next()) {
					
				Menu.current_id= rs.getInt(1);

				
				}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}	
	
		
	}

	@Override
	public void selectCustomerAccount(String cust_name) {
		
		
		
	}

	@Override
	public void updateCustomer(String name,String email, String addres,String phone,String pass) {
		
		try(Connection conn=DriverManager.getConnection(url, username1, password1)) {
			
			System.out.println("in my dao");
			
			
			
			
			
		String sql="UPDATE customer SET  cust_email=?,cust_address=?,cust_phone=? WHERE customer_firstname=? AND cust_password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, addres);
			ps.setString(3, phone);
			ps.setString(4,name);
			ps.setString(5, pass);
		if(ps.executeUpdate()>0) {
			
			System.out.println("good");
			
		}
					  							
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
	}

	@Override
	public void deleteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectCustomerId(Customer cust) {
		int id=0;
		
		try(Connection conn=DriverManager.getConnection(url, username1, password1)) {
			
			String sql="Select customer_id from customer where  customer_firstname='"+cust.getName()+"'AND cust_password='"+cust.getPassword()+"'";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeQuery();
			id=ps.executeUpdate();
			System.out.println(id);
		}catch (Exception e) {
			
			e.getStackTrace();
		}

		return id;
	}




	@Override
	public void insertAccount(int acc_num,int balance,int cust_id) {
		
		try(Connection conn=DriverManager.getConnection(url, username1, password1)){
			String	sql="INSERT Into accounts(account_number,balance,cust_fk) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, acc_num);
			ps.setInt(2, balance);
			ps.setInt(3, cust_id);
            ps.executeQuery();
			
			if(ps.executeUpdate()>0) {
				
				System.out.println("good");
				
			}
			
						
		}catch (Exception e) {
			e.getStackTrace();
			
		}
		
	}




	@Override
	public Double selectCustomerbalance(int cust_Id) {
		Double num=0.0;
		try(Connection conn=DriverManager.getConnection(url, username1, password1)){
			
		String	sql="SELECT balance FROM accounts where cust_fk=?";
		
		PreparedStatement st=conn.prepareStatement(sql);
		st.setInt(1,cust_Id);
		 ResultSet is=st.executeQuery();
		 is.next();
		 
		num=is.getDouble(1);
		System.out.println("Your balances is "+is.getDouble(1));
			
	
		}catch (Exception e) {
			e.getStackTrace();
		}

		return num;
		
	}




	@Override
	public void updateAccBalance(int amount,int cust_id) {
		
		try(Connection conn=DriverManager.getConnection(url, username1, password1)){
			String sql="{call deposit_update_balance(?,?)}";
			CallableStatement cs=conn.prepareCall(sql);
			
			cs.setInt(1, cust_id);
			cs.setInt(2, amount);
			cs.executeUpdate();
		

		if (cs.executeUpdate()>0) {
			System.out.println("good");
			
		}
		
		
		
	}catch (Exception e) {
		// TODO: handle exception
		e.getStackTrace();
	}

	}




	@Override
	public void updateBalanceAfterWithdraw(int cust_id, Double amount) {
		try(Connection conn=DriverManager.getConnection(url, username1, password1)){
			String sql="{call withdraw_update_balance(?,?)}";
			CallableStatement cs=conn.prepareCall(sql);
			
			cs.setInt(1, cust_id);
			cs.setDouble(2, amount);
			cs.executeUpdate();
		

		if (cs.executeUpdate()>0) {
			System.out.println("good");
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void selectAdminInfo(String name, String pass) {
		try (Connection conn=DriverManager.getConnection(url, username1, password1)){
			String ql="SELECT admin_id from administrator where first_name=? and password=?";
			
			PreparedStatement st =conn.prepareStatement(ql);
				

				st.setString(1, name);
				st.setString(2, pass);
				ResultSet rs=st.executeQuery();
				if( rs.next()) {
					
				Menu.current_id= rs.getInt(1);

				
				}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}	
	
		
	}


}

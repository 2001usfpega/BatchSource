package com.bankdao.interfaces.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.bank.bean.Customer;
import com.bank.dao.interfaces.CustomerDao;

public class CustomerDaoImpl extends connection implements CustomerDao {

	@Override
	public void insertCustomer(Customer cust) {
		try {
			this.getConected();
			
			String sql="INSERT INTO customer(customer_firstname) values(?,?)";
			PreparedStatement ps=this.conn.prepareStatement(sql);
			
			ps.setString(1, cust.getName());
			
			ps.executeUpdate();
			
			System.out.println(ps);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> selectAllcustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectCustomerById(int cust_Id) {
		// TODO Auto-generated method stub
		return null;
	}

}

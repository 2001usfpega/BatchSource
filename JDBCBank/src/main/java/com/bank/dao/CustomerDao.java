package com.bank.dao;

import java.util.List;

import com.bank.user.Customer;
import com.bank.user.User;

public interface CustomerDao {
	//CREATE
	public boolean insertNewUser(String uname, String pw, String fName, String sName, int rank);
	
	//READ
	public List<Customer> selectAllCustomers();
	public List<User> selectAllUsers();
	public User selectByUserId(int id);
	public User selectByUsername(String uname);
	public User selectByUserNameAndPassword(String name, String password);
	//UPDATE
	public boolean updateUser(User c);
	//DELETE
	public boolean deleteUser(User c);
}

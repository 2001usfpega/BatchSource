package com.bank.dao;

import java.util.List;

import com.bank.user.User;

public interface UserDao {
	//CREATE
	public boolean insertNewUser(String uname, String pw, String fName, String sName);
	
	//READ
	public List<User> selectAllUsers();
	public User selectByUserId(int id);
	public User selectByUsername(String uname);
	public User selectByUserNameAndPassword(String name, String password);
	//UPDATE
	public boolean updateUser(User u);
	//DELETE
	public boolean deleteUser(User u);
}

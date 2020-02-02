package com.bank.dao;

import java.util.List;

import com.bank.user.User;

public interface UserDao {
	//CREATE
	public boolean insertUser(User u);
	
	//READ
	public List<User> selectAllUsers();
	public User selectByUserId(int id);
	public User selectByUserName(String name);
	public User selectByUserNameAndPassword(String name, String password);
	//UPDATE
	public boolean updateUser(User u);
	//DELETE
	public boolean deleteUser(User u);
}

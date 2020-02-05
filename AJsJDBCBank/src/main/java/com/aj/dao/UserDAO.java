package com.aj.dao;

import java.util.List;

import com.aj.models.User;

public interface UserDAO {
	
	//CREATE
	public void createNewUser(User user);
	
	//READ
	public List<User> selectAllUsers();
	public User selectUserById(String user_id);
	public User selectUserByUsername(String user);
	
	//UPDATE
	public String updateUser(User user);
	
	//DELETE
	public String deleteUser();

}

package com.aj.DAO;

import java.util.List;

import com.aj.model.User;

public interface UserDAO {
	
	public void createNewUser(User user);
	
	public List<User> selectAllUsers();
	public User selectUserByUsername(String user);
	
	public String updateUser(User user);
	
	public String deleteUser();
}

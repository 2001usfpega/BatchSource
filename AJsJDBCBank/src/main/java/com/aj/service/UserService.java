package com.aj.service;

import java.util.List;

import com.aj.models.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(User user);
	public User createUser(User user);
	public boolean validateUsername(String username);
	public boolean validatePassword(String pass);
	public long logIn(String user, String pass);

}

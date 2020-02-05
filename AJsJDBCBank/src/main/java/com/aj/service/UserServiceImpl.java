package com.aj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.aj.dao.UserDAO;
import com.aj.dao.UserDAOImpl;
import com.aj.models.User;

public class UserServiceImpl implements UserService {
	private static UserDAO userDao = new UserDAOImpl();
	private static List<User> userList = new ArrayList<>();
	private static User currentUser = new User();
	private static final String REGEX_PW_VALIDATION = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,12}$";
	private static final Pattern PASSWORD_PATTERN =
			Pattern.compile(REGEX_PW_VALIDATION);

	@Override
	public List<User> getAllUsers() {
		userList = userDao.selectAllUsers();
		return userList;
	}

	@Override
	public User getUser(User user) {
		currentUser = userDao.selectUserById(user.getUser_id());
		
		return currentUser;
	}

	@Override
	public User createUser(User user) {
		userDao.createNewUser(user);
		currentUser = user;
		return user;
	}

	@Override
	public boolean validateUsername(String username) {
		if (username.length() < 8) {
			return false;
		}
			return true;
	}
	
	@Override
	public boolean validatePassword(String pass) {
		if(PASSWORD_PATTERN.matcher(pass).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public long logIn(String user, String pass) {
		userList = userDao.selectAllUsers();
		for (User u : userList) {
			if (userExists(user) && u.getPw().equals(pass)) {
				currentUser = u;
				
				return Long.parseLong(u.getUser_id());
			}
		}
		return -1;
	}

	 public static boolean userExists(String user) {
	        boolean isUser = false;
	        for (User u : userList) {
	            if (u.getUname().equals(user)) {
	                isUser = true;
	                break;
	            }
	            isUser =  false;
	        }
	        return isUser;
	    }
	
	public static List<User> getUserList() {
		return userList;
	}

	public static void setUserList(List<User> userList) {
		UserServiceImpl.userList = userList;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		UserServiceImpl.currentUser = currentUser;
	}
}

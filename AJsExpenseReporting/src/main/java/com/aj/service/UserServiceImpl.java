package com.aj.service;

import java.util.ArrayList;
import java.util.List;

import com.aj.DAO.UserDAO;
import com.aj.DAO.UserDAOImpl;
import com.aj.model.User;

public class UserServiceImpl implements UserService {
	private static UserDAO userDao = new UserDAOImpl();
	private static List<User> userList = new ArrayList<>();
	private User currentUser = new User();
	
	@Override
	public List<User> getAllUsers() {
		userList = userDao.selectAllUsers();
		
		return userList;
	}

	@Override
	public User createUser(User user) {
		userDao.createNewUser(user);
		currentUser = user;
		return currentUser;
	}

	@Override
	public boolean validateUsername(String username) {
		if (username.length() < 7) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validatePassword(String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long logIn(String user, String pass) {
		userList = userDao.selectAllUsers();
		for (User u : userList) {
			if (userExists(user) && u.getPw().equals(pass)) {
				currentUser = u;
				
				return u.getU_id();
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

}

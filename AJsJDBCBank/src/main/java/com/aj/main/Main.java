package com.aj.main;

import java.util.Scanner;

import com.aj.menus.Menus;
import com.aj.models.User;


public class Main {
	static Scanner scan = new Scanner(System.in);
	public static User currentUser = null;

	public static void main(String[] args) {

		//UserServiceImpl usrsvc = new UserServiceImpl();
		//usrsvc.getAllUsers();
		currentUser = Menus.mainMenu(scan);
	}
}

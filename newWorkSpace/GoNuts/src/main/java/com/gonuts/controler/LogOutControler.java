package com.gonuts.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LogOutControler {

	public static String logout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "index.html";
	}
}

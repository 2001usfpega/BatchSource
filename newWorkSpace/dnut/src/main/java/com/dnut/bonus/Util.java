package com.dnut.bonus;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.example.testmain;

public class Util {
	public final static Logger LOGGY = Logger.getLogger(testmain.class);
	
	public static String pageBuilder(HttpServletRequest req,boolean logout,String tital,String cont,String bLink,String bText) {
		
		if(logout) {
			req.setAttribute("logout", "Logout");
		}
		
		//title
		req.setAttribute("tital", tital);
		
		//content
		req.setAttribute("cont", cont);
		
		//button
		req.setAttribute("bLink", "'"+bLink+"'");
		req.setAttribute("bText", bText);
		
		return "WEB-INF/temp/circleTemp.jsp";
	}
}

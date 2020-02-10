package com.gonuts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.gonuts.model.Employee;


public class Util {
	public final static Logger LOGGY = Logger.getLogger(Util.class);

	public static String pageBuilder(HttpServletRequest req,String tital,String cont,String bLink,String bText) {
		HttpSession session = req.getSession();
		Employee greg = (Employee) session.getAttribute("user");
		
		if (greg != null) {
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

package com.dnut.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dnut.dao.RequestService;
import com.dnut.model.Employee;

public class LoginController {
	private static RequestService service= new RequestService();

	/**
	 * @param req
	 * @return
	 */
	public static String login(HttpServletRequest req) {
//		if(!req.getMethod().equals("POST")) {
//			return "html/login.html";
//		}
		
		String uname= req.getParameter("username");
		String pword= req.getParameter("password");
		
		Employee bob=service.login(uname, pword);
		System.out.println(bob);
		
		//hit the db
		if(bob==null) {
			return "wrongcreds.change";
		}else {
			/*
			 * in YOUR project, you'll be storing an entire User object in the session
			 * which will ALSO contain whether it is an manager or employee
			 */
//			HttpSession sess=req.getSession();
//			sess.setAttribute("id", bob.getId());
//			sess.setAttribute("name", bob.getFirstName());
//			sess.setAttribute("rank", bob.getRank());
			
			req.getSession().setAttribute("user", bob);

			
			System.out.println("homeward");
			//return "home.change";
			return "turkey";
		}
	}
}

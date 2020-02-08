package com.dnut.controller;

import javax.servlet.http.HttpServletRequest;

import com.dnut.model.Employee;

public class HomeController {

	public static String home(HttpServletRequest req) {
		
		
//		HttpSession session = req.getSession();
//		SuperVillain villain= 
//				(SuperVillain) session.getAttribute("currentVillain");
//		System.out.println(session.getAttribute("Who IS this dude?"));
		
		Employee bob=(Employee)req.getSession().getAttribute("user");
		System.out.println(bob);
		System.out.println();
		
		//hit the db
		if(bob==null) {
			return "wrongcreds.change";
		}		
		return "dnut/home.html";
	}
}

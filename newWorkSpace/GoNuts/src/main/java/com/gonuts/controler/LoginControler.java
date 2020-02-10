package com.gonuts.controler;

import javax.servlet.http.HttpServletRequest;

import com.gonuts.dao.ReqService;
import com.gonuts.model.Employee;

public class LoginControler {
	private static ReqService service = new ReqService();

	public static String login(HttpServletRequest req) {
		String uname = req.getParameter("username");
		String pword = req.getParameter("password");

		Employee bob = service.login(uname, pword);
		System.out.println(bob);

		if (bob == null) {
			return "bad.chan";
		}
		else {
			req.getSession().setAttribute("user", bob);
			if(bob.getRank()>0) {
				return AdminControler.admin(req);
			}
			return "home.html";
		}
	}
	
}

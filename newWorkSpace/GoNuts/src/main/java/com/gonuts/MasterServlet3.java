package com.gonuts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonuts.controler.LogOutControler;
import com.gonuts.controler.LoginControler;
import com.gonuts.controler.SubmitControler;
import com.gonuts.controler.BabyControler;

public class MasterServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("starting servlet4");
		req.getRequestDispatcher(process(req)).forward(req, res);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	//helper
	public static String process(HttpServletRequest req){
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/GoNuts/login.chan":
			return LoginControler.login(req);
		case "/GoNuts/submit.chan":
			return SubmitControler.submit(req);
		case"/GoNuts/bad.chan":
			return BabyControler.badLogin(req);
		case"/GoNuts/logout.chan":
			return LogOutControler.logout(req);
		default:
			return BabyControler.idk(req);
		}
	}
}

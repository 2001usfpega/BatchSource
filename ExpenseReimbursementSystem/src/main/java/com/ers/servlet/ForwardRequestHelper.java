package com.ers.servlet;

import javax.servlet.http.HttpServletRequest;

import com.ers.controller.HomeController;
import com.ers.controller.LoginController;
import com.ers.controller.NewExpenseController;

public class ForwardRequestHelper {

	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/Login.do":
			System.out.println("in login.change");
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/home.do":
			System.out.println("in home.do");
			return HomeController.home(req);
		case "/ExpenseReimbursementSystem/NewExpense.do":
			return NewExpenseController.createTicket(req);
		case "/ExpenseReimbursementSystem/AdminHome.do":
			return LoginController.login(req);
		default:
			System.out.println("in default case");
			return "resources/html/badlogin.html";
		}
		
	}
}

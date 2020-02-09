package com.project1.controllers;

import javax.servlet.http.HttpServletRequest;

import com.project1.Service.ReimburseService;

public class HomeController {
	static ReimburseService rs = new ReimburseService();

	public static String homeEmployee(HttpServletRequest req) {
		return "resources/html/homeEmployee.html";
	}
	public static String homeAdmin(HttpServletRequest req) {
		return "resources/html/homeAdmin.html";
	}
	public static String newRequest(HttpServletRequest req) {
		return "resources/html/newRequest.html";
	}
	public static String newRequestSubmit(HttpServletRequest req) {
		int emp_id = (int)(req.getSession().getAttribute("emp_id"));
		req.getAttribute("r_type");
		int r_type = Integer.parseInt(req.getParameter("r_type"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		String info =  req.getParameter("info");
		rs.newRecord(emp_id,r_type,amount,info );
		return "resources/html/homeEmployee.html";
	}

	public static String approve(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		rs.approverecord("Approved", id);
		return "resources/html/homeAdmin.html";
	}
	public static String deny(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		rs.approverecord("Denied", id);
		return "resources/html/homeAdmin.html";
	}
}
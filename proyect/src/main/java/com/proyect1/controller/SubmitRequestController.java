package com.proyect1.controller;

import javax.servlet.http.HttpServletRequest;

import com.proyect1.service.impl.RequestServiceImpl;
import com.proyect1.service.interf.RequestServiceInterface;

public class SubmitRequestController {
	private static RequestServiceInterface serv = new RequestServiceImpl();

	public static String submit() {
		return "ProyectHtml/submitRequest.html";
	}

	// The process method will save all info from the submit form into the database
	public static String process(HttpServletRequest req) {
		// 0. Pull the request
		Integer emp_id = Integer.parseInt(req.getParameter("emp_id"));
		String request_type = req.getParameter("ticket_type");
		Integer amount = Integer.parseInt(req.getParameter("amount"));

		System.out.println(emp_id + " " + request_type + " " + amount);
		// 1. Call the service layer
		serv.sendRequest(request_type, amount, emp_id);

		// 2. Service layer call Dao

		// 3. Dao will insert into database

		return "submitRequest.test";
	}

	public static String empLogOut() {
		return "ProyectHtml/login.html";
	}
}

package com.proyect1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.proyect1.model.Driver;
import com.proyect1.model.Employee;
import com.proyect1.service.impl.RequestServiceImpl;
import com.proyect1.service.interf.RequestServiceInterface;

public class SubmitRequestController {
	private static RequestServiceInterface serv = new RequestServiceImpl();
	final static Logger logger = Logger.getLogger(Driver.class);

	public static String submit() {
		return "ProyectHtml/submitRequest.html";
	}

	// The process method will save all info from the submit form into the database
	public static String process(HttpServletRequest req) {

		// 0. Pull the request
		// Integer emp_id = Integer.parseInt(req.getParameter("emp_id"));

		// get employee object from session
		HttpSession session = req.getSession();
		Employee currentEmp = (Employee) session.getAttribute("employeesession");

		String request_type = req.getParameter("ticket_type");
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		String descrip = req.getParameter("descrip");
		logger.setLevel(Level.ALL);
		System.out.println(currentEmp.getEmp_id() + " " + request_type + " " + amount + " " + descrip);
		// 1. Call the service layer
		serv.sendRequest(request_type, amount, currentEmp.getEmp_id(), descrip);

		// 2. Service layer call Dao

		// 3. Dao will insert into database

		return "submitRequest.test";
	}

	public static String empLogOut() {
		return "ProyectHtml/login.html";
	}
}

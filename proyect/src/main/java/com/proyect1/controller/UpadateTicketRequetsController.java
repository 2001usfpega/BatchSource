package com.proyect1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyect1.model.Ticket;
import com.proyect1.service.impl.RequestServiceImpl;
import com.proyect1.service.interf.RequestServiceInterface;

public class UpadateTicketRequetsController {
	private static RequestServiceInterface serv = new RequestServiceImpl();

	public static String submit() {
		return "ProyectHtml/approveRequest.html";
	}

	public static String approve(HttpServletRequest req) throws IOException {
		System.out.println("START APPROVING");
		// 0. Get the ticket ID and Search the ticket by id
		try {
			Integer ticket_num = Integer.parseInt(req.getParameter("ticket_id"));
			serv.SetRequestStatus(ticket_num);
		} catch (Exception e) {
			System.out.println("APPROVE ERROR");
			System.out.println(req.getParameter("ticket_id"));
		}
		

		// 1. Change the status
		
		// 2. Update the database
         
		// serv.SetRequestStatus(ticket_num);

		return "approveProcess.test";

	}

	public static String list(HttpServletResponse resp) throws IOException, ServletException {
		// 1 grab the pending list
		List<Ticket> list = serv.getAllRequest();
		
		String content="";
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<thml><body><h1> the servlet is directly talking to the "+"client!</h1></body></html>");
	
		for (Ticket ticket : list) {
			//String name=null;
		//for
			content+="<tr><td>"+ticket.getEmp_id()+"</td><td>";
			
			
		}
		
	String reponse="<html><body>	<div class=\"container\">\r\n" + "<div class=\"form-group\">\r\n"
				+ "				<table border=\"2\" class=\"table\" id=\"reimbtable\">\r\n"
				+ "					<tr>\r\n" + "<th>User Id</th>\r\n" + "						<th>First Name</th>\r\n"
				+ "<th>Last Name</th>\r\n" + "						<th>Type</th>\r\n"
				+ "						<th>Amount</th>\r\n" + "						<th>Submitted</th>\r\n"
				+ "						<th>Resolved</th>\r\n" + "						<th>Status</th>\r\n"
				+ "						<th>Description</th>\r\n" + "						<th>Ticket Id</th>\r\n"
				+ "</tr>"+content+  "</table></div></div></body></html>";
		// 2print the list
		/*
		 * for (Ticket ticket : list) { resp.getWriter().write(new
		 * ObjectMapper().writeValueAsString(ticket)); }
		 */
		
		return reponse;
		
	}
	
	public static String adminLogOut() {
		 return "ProyectHtml/login.html";
		
		
		
	}

}

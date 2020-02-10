package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.model.ExpenseTicket;
import com.ers.service.EmployeeService;
import com.ers.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AdminController {
	
	private static EmployeeService es = new EmployeeServiceImpl();
	
	public static void admin(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<ExpenseTicket> tickets = (List<ExpenseTicket>) req.getAttribute("tickets");
		List<Employee> employees = es.getAllEmployees();
		System.out.println(tickets);
		
		PrintWriter out = res.getWriter();
		String output = "<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Admin Home</title>\r\n" + 
				"<link rel=\"stylesheet\"\r\n" + 
				"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n" + 
				"	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n" + 
				"	crossorigin=\"anonymous\">\r\n" + 
				"<link rel=stylesheet type=\"text/css\" href=\"../css/style.css\">\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div class=\"container\">\r\n" + 
				"		<div class=\"form-group\">\r\n" + 
				"			<table border=\"2\" class=\"table\" id=\"reimbtable\">\r\n" + 
				"				<tr>\r\n" + 
				"					<th>User Id</th>\r\n" + 
				"					<th>First Name</th>\r\n" + 
				"					<th>Last Name</th>\r\n" + 
				"					<th>Type</th>\r\n" + 
				"					<th>Amount</th>\r\n" + 
				"					<th>Date submitted</th>\r\n" + 
				"					<th>Date resolved</th>\r\n" + 
				"					<th>Status</th>\r\n" + 
				"					<th>Description</th>\r\n" + 
				"					<th>Ticket Id</th>\r\n" + 
				"				</tr>\r\n";
		 
				
			for(ExpenseTicket t : tickets) {
				Employee emp = null;
				for(Employee e : employees) {
					if(e.getUserid() == t.getUserid()) {
						emp = e;
					} else {
						continue;
					}
				}
				
				String type = "";
				switch(t.getType()) {
				case 1:
					type = "Lodging";
					break;
				case 2:
					type = "Travel";
					break;
				case 3:
					type = "Food";
					break;
				case 4:
					type = "Other";
					break;
				}
				
				output = output + "<tr>"
						+ "<td>" + t.getUserid() + "</td>"
						+ "<td>" + emp.getfName() + "</td>"
						+ "<td>" + emp.getlName() + "</td>"
						+ "<td>" + type + "</td>"
						+ "<td>$" + t.getAmount() + "</td>"
						+ "<td>" + t.getDateSubmitted() + "</td>"
						+ "<td>" + t.getDateResolved() + "</td>"
						+ "<td>" + t.getStatus() + "</td>"
						+ "<td>" + t.getDescription() + "</td>"
						+ "<td>" + t.getTicketid() + "</td>"
						+ "</tr>";

		}

		output = output + "			</table>\r\n" + "		</div>\r\n" + "	</div>\r\n" + "\r\n" + "\r\n"
				+ "	<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n"
				+ "		integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n"
				+ "		crossorigin=\"anonymous\"></script>\r\n" + "	<script\r\n"
				+ "		src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n"
				+ "		integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n"
				+ "		crossorigin=\"anonymous\"></script>\r\n" + "	<script\r\n"
				+ "		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n"
				+ "		integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n"
				+ "		crossorigin=\"anonymous\"></script>\r\n" + "</body>\r\n" + "</html>";
		
		out.println(output);
		// res.getWriter().write(new ObjectMapper().writeValueAsString(tickets));

	}
}

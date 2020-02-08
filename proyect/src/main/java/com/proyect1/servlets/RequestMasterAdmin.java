package com.proyect1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyect1.model.Employee;
import com.proyect1.model.Ticket;
import com.proyect1.service.impl.RequestServiceImpl;
import com.proyect1.service.interf.RequestServiceInterface;

/**
 * Servlet implementation class RequestMaster
 */
public class RequestMasterAdmin extends HttpServlet {
	RequestServiceInterface serv=new RequestServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
List<Ticket> list = serv.getAllRequest();
	List<Employee>	empList=serv.getAllEmployee();
		String content="";
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<thml><body><h1> This is the list of pending request</h1></body></html>");
		String name=null;
		String last=null;
		for (Ticket ticket : list) {
			
			for (Employee emp : empList) {
				 if (emp.getEmp_id()==(ticket.getEmp_id()))
					      {
					         name = emp.getFirstname();
					         last = emp.getLastname();
					      }
										
			}
			content+="<tr><td>"+ticket.getEmp_id()+"</td><td>"+name+"</td><td>"+last+"</td>"
					+ "<td>"+ticket.getTicket_type()+"</td><td>"+ticket.getTicket_amount()+"</td><td>date submited"
					+"</td><td>"+ticket.getTicket_status()+"</td><td>description<td>"+ticket.getTicket_id()
					+"</td></tr>";
		}
		
	out.println("<html><body>	<div class=\"container\">\r\n" + "<div class=\"form-group\">\r\n"
				+ "				<table border=\"2\" class=\"table\" id=\"reimbtable\">\r\n"
				+ "					<tr>\r\n" + "<th>User Id</th>\r\n" + "						<th>First Name</th>\r\n"
				+ "<th>Last Name</th>\r\n" + "						<th>Type</th>\r\n"
				+ "						<th>Amount</th>\r\n" + "						<th>Submitted</th>\r\n"
			    + "						<th>Status</th>\r\n"
				+ "						<th>Description</th>\r\n" + "						<th>Ticket Id</th>\r\n"
				+ "</tr>"+content+  "</table></div></div></body></html>");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}

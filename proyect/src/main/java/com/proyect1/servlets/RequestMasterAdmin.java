package com.proyect1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.proyect1.controller.UpadateTicketRequetsController;
import com.proyect1.model.Driver;
import com.proyect1.model.Employee;
import com.proyect1.model.Ticket;
import com.proyect1.service.impl.RequestServiceImpl;
import com.proyect1.service.interf.RequestServiceInterface;

/**
 * Servlet implementation class RequestMaster
 */
public class RequestMasterAdmin extends HttpServlet {
	RequestServiceInterface serv=new RequestServiceImpl();
	final static Logger logger=Logger.getLogger(Driver.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
List<Ticket> list = serv.getAllRequest();
	List<Employee>	empList=serv.getAllEmployee();
		String content="";
		System.out.println(list);
		System.out.println(empList);
		resp.setContentType("text/html");
		logger.setLevel(Level.ALL);
		if (logger.isInfoEnabled()) {
			logger.info("this is info : manager has logged");
			
		}
		PrintWriter out=resp.getWriter();
		out.println("<thml><body style='background_image:url(/Proyect1Servlet/resouces/image/admin.jpg)'><h1> This is the list of pending request</h1></body></html>");
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
					+ "<td>"+ticket.getTicket_type()+"</td><td>"+ticket.getTicket_amount()+"</td><td>"+ticket.getDateSubmited()
					+"</td><td>"+ticket.getTicket_status()+"</td><td>"+ticket.getDescription()+"<td>"+ticket.getTicket_id()
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
		
		
		//out.getClass().cast(UpadateTicketRequetsController.approve(request));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}

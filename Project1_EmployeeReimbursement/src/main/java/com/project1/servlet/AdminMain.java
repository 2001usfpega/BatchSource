package com.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.DAO.ReimburseDAOImpl;
import com.project1.Models.RequestImpl;

public class AdminMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimburseDAOImpl db = new ReimburseDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>All Reimbursement Requests</title>\r\n" + 
				"</head>\r\n" + 
				"<body>");
		out.println("<table><tr>"
				+ "<th>Request ID</th>"
				+ "<th>Employee ID</th>"
				+ "<th>Status</th>"
				+ "<th>Reimbursement Type</th>"
				+ "<th>Amount</th>"
				+ "<th>Date Submitted</th>"
				+ "<th>Date Resolved</th>"
				+ "<th>Info</th>"
				+ "<th>Deny</th>"
				+ "<th>Approve</th></tr>");
			ArrayList<RequestImpl> list = ReimburseDAOImpl.readRecords();
			for(RequestImpl x : list) {
				out.println("<tr> "
						+ " <th>" + x.getRequest_id() +"</th>"
						+ " <th>" + x.getEmp_id() +"</th>"
						+ " <th>" + x.getStatues() +"</th>"
						+ " <th>" + x.getRe_type() +"</th>"
						+ " <th>" + x.getAmount() +"</th>"
						+ " <th>" + x.getDate_sub() +"</th>"
						+ " <th>" + x.getDate_res() +"</th>"
						+ " <th>" + x.getInfo() +"</th>");
						if(x.getStatues().equals("pending")) {
						out.print("<th><form method="+"POST"+" action="+"approve.change"+"><input type ="+"hidden"+" name = "+"id"+" value = "+ x.getRequest_id()+"> <input type="+"submit"+" value="+"Approve"+"></form></th>"
						+ " <th><form method="+"POST"+" action= "+"deny.change"+" ><input type ="+"hidden"+" name ="+"id"+" value = "+ x.getRequest_id()+"> <input type="+"submit"+" value="+"Deny"+"> </form> </th>");
						}
						out.print("</tr>");
			}
			out.println("</table></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

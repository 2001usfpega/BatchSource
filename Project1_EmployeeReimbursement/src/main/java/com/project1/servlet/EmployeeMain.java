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

/**
 * Servlet implementation class EmployeeMain
 */
public class EmployeeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimburseDAOImpl db = new ReimburseDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			System.out.println(request.getSession().getAttribute("emp_id"));
			PrintWriter out = response.getWriter();
		out.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" +
				"<style>body{\r\n" + 
				"		background-image: url(\"mainBackGround.png\");\r\n" + 
				"		background-size: 100%;\r\n" + 
				"		}\r\n" +  
				"	</style>"
				+"</head>\r\n" + 
				"<body style ='background-color : #92fe9d'>");
		out.println("<table><tr>"
				+ "<th>Request ID</th>"
				+ "<th>Employee ID</th>"
				+ "<th>Status</th>"
				+ "<th>Reimbursement Type</th>"
				+ "<th>Amount</th>"
				+ "<th>Date Submitted</th>"
				+ "<th>Date Resolved</th>"
				+ "<th>Info</th></tr>");
			ArrayList<RequestImpl> list = db.employeeRecords((int) request.getSession().getAttribute("emp_id"));
			for(RequestImpl x : list) {
				out.println("<tr> "
						+ " <th>" + x.getRequest_id() +"</th>"
						+ " <th>" + x.getEmp_id() +"</th>"
						+ " <th>" + x.getStatues() +"</th>"
						+ " <th>" + x.getRe_type() +"</th>"
						+ " <th>" + x.getAmount() +"</th>"
						+ " <th>" + x.getDate_sub() +"</th>"
						+ " <th>" + x.getDate_res() +"</th>"
						+ " <th>" + x.getInfo() +"</th>"
						+ "</tr>");
			}
			out.println("</table></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

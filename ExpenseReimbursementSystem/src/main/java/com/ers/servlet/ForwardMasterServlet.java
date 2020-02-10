package com.ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.model.ExpenseTicket;

public class ForwardMasterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Master Servlet, get");

		// request.getRequestDispatcher(ForwardRequestHelper.process(request))
		// .forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In Master Servlet, post");

		request.getRequestDispatcher(ForwardRequestHelper.process(request)).forward(request, response);
	}
}

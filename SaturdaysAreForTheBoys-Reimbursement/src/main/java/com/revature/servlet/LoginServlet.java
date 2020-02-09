package com.revature.servlet;

import com.revature.DAO.ExpenseReimbursementDAOImplementation;
import com.revature.logging.ExpenseLogger;
import com.revature.model.Employee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "Servlet")
public class LoginServlet extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(ExpenseLogger.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = ((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).login(request.getParameter("username"), request.getParameter("password"));

        if (employee != null) {
            request.getSession().setAttribute("employee", employee);
            request.getSession().setMaxInactiveInterval(5 * 60);

            if (employee.getEmpType() == 0) {
                response.sendRedirect("/resources/SubmitReimburse.html");
                LOGGER.info("Employee login");
            } else {
                response.sendRedirect("/resources/ResolveReimburse.html");
                LOGGER.info("Finance Manager login");
            }
        } else {
            response.getWriter().print("Login has failed!");
            LOGGER.error("Failed login!");
        }
    }
}
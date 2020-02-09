package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.ExpenseReimbursementDAOImplementation;
import com.revature.model.Employee;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExpenseReimburseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = (Employee) request.getSession().getAttribute("employee");

        if (employee == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        response.getWriter().write(new ObjectMapper().writeValueAsString(((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).viewPending()));
    }
}
package com.revature.controller;

import com.revature.DAO.ExpenseReimbursementDAOImplementation;
import com.revature.model.Employee;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResolveReimburseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = (Employee) request.getSession().getAttribute("employee");

        if (employee == null || employee.getEmpType() == 0) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).resolveReimburse(
                employee.getEmpID(),
                Boolean.parseBoolean(request.getParameter("status")),
                Integer.parseInt(request.getParameter("id"))
        );
    }
}
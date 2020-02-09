package com.revature.controller;

import com.revature.DAO.ExpenseReimbursementDAOImplementation;
import com.revature.model.Employee;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitReimburseController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = (Employee) request.getSession().getAttribute("employee");

        if (employee == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).employeeSubmitReimburse(
                Integer.parseInt(request.getParameter("reimbursement_type")),
                Double.parseDouble(request.getParameter("amount")),
                employee.getEmpID(),
                request.getParameter("description")
        );
    }
}
package com.revature;

import com.revature.DAO.ExpenseReimbursementDAOImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.setOut(new PrintStream(response.getOutputStream()));

        ((ExpenseReimbursementDAOImplementation) request.getServletContext().getAttribute("db")).viewAllReimburseReq();
        // service.viewAllReimburseReq();
        //response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}
package com.ers.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.AdminController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONRequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/AdminHome.json":
			AdminController.admin(req, res);
			break;		
		}

	}
}

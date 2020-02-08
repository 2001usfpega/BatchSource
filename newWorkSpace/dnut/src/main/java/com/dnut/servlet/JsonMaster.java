package com.dnut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnut.controller.DannyControler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class JsonMaster
 */
public class JsonMaster extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req,res);
	}



	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());//sent from html action
		switch(req.getRequestURI()) {
		case "/dnut/danny.json":
			DannyControler.dFinder(req,res);
		break;
			default:
				System.out.println("default jason case");

				res.getWriter().write(new ObjectMapper().writeValueAsString("ERRORERRORERROR"));
		}
	}
}
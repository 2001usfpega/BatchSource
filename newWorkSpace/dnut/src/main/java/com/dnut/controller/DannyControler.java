package com.dnut.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DannyControler {
	public static void dFinder(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		String danny="happy danny";
		res.getWriter().write(new ObjectMapper().writeValueAsString(danny));
		
	}

}

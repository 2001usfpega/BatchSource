package com.proyect1.controller;

import javax.servlet.http.HttpServletRequest;

import com.proyect1.model.Employee;
import com.proyect1.service.impl.RequestServiceImpl;
import com.proyect1.service.interf.RequestServiceInterface;

public class loginController {
	private static RequestServiceInterface reqSer = new RequestServiceImpl();


	public static String login(HttpServletRequest req) {

		if(!req.getMethod().equals("GET")) {
            return "Proyect1Servlet/login.html";
        }
        
        String username= req.getParameter("username1");//perform data
        String password= req.getParameter("password");//coger lo que tiene el reqywst
        
        /*
         * for YOUR project, you won't hardcode "cheese" and "louise" you'll go to the DB
         * and find the ACTUAL password that should be used, base on the username they typed
         * in.
         */
        Employee emp=reqSer.getEmployee(username);
       System.out.println(emp.toString()); 
       if (emp.getEmp_username()!=null) {
    	   if (emp.getEmp_username().equals(username) && (emp.getEmp_pass().equals(password))){
           	System.out.println("FOUND ID");
           	if (username.equals("Teresa")) {
				//return "approveRequest.test";
           		return "RequestMasterAdmin";
			}else 
           	{
				return "submitRequest.test";
			}
           	
           }
	}
        
		
        	else 
	/*	
	  if(!(username.equals("Teresa") && password.equals("tscamara"))) {
	  System.out.println("INCORRECT ID"); return "wrongcreds.test"; }else {
	  
	  // in YOUR project, you'll be storing an entire User object in the session //
	//  which will ALSO contain whether it is an manager or employee
	  
	  req.getSession().setAttribute("loggedusername", username);
	  req.getSession().setAttribute("loggedpassword", password);*/
        		System.out.println("CANNOT FOUND");
	  return "adminHome.test";
	  } 
	
	}





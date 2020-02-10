package com.gonuts.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gonuts.Util;
import com.gonuts.dao.ReqService;
import com.gonuts.model.Employee;
import com.gonuts.model.RequestForm;

public class SubmitControler {
	private static ReqService service = new ReqService();
	
	
	public static String submit(HttpServletRequest req){

		HttpSession session = req.getSession();
		Employee bob= (Employee) session.getAttribute("user");
		
		if (bob == null) {
			return "bad.chan";
		}
		int type=Integer.parseInt(req.getParameter("type"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		String notes = req.getParameter("notes");
		
		if(service.insertTicket(new RequestForm(type, amount, notes, bob.getId()))) {
			Util.LOGGY.info("---Form Submitted---");
		}
		else {
			System.out.println("--form bounced--");			
			Util.LOGGY.error("---Form Didn't Work---");
			return "logout.chan";
		}
	
		
		String cont="Your request has been submitted. ";
		cont+="Click below to submit another request or click the logout button up top to quit.";
		return Util.pageBuilder(req,"Request Submitted",cont,"/GoNuts/home.html","More");
	}
}

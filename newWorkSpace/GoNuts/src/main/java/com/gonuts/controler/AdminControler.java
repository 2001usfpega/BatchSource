package com.gonuts.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gonuts.Util;
import com.gonuts.dao.ReqService;
import com.gonuts.model.Employee;
import com.gonuts.model.RequestForm;

public class AdminControler {

	private static ReqService service = new ReqService();
	static String s1;
	static String s2;
	static String s3;
	static String s4;
	static String s5;
	static String s6;
	static String s7;
	static String s8;
	static String s9;
	static String s10;
	static String s11;
	static String sx;
	
	
	static String[] type= {"","Lodging","Travel","Food","Other"};
	
	
	static{
		s1="<form method='post' action='/GoNuts/submit2.chan'>"+
           "<div class='card text-white bg-dark mb-3 mx-auto align-middle rounded' style='width: 1000px;'>"+
               "<div class='card-body'>"+
                   "<div class='container'>"+
                       "<div class='row'><div class='col-sm'>Name: ";
								s2="</div><div class='col-sm'>Employee ID: ";
								s3="</div> <div class='col-sm'>Date Submitted: ";
								s4="</div><div class='col-sm'></div></div><br><div class='row'><div name='id2' class='col-sm'>Form ID: ";
								s5="</div><div class='col-sm'>Type: ";
								s6="</div><div class='col-sm'>Ammount: $";
							s7="</div><div class='col-sm'></div></div><br><div class='row'><div class='col-sm-9'>Notes: ";
						s8="</div><div class='col-sm-3'><select name='pending'>";
					s9="<option value='2'>Denied</option><option value='1'>Approved</option></select>";
				s10="<button name='id' value='";
				s11="'type='submit' class='btn' style='background-color: rgb(231, 120, 213);'>Submit</button>";
				s11+="</div></div></div></div></div></form>";
								
					
	}
	
	public static String admin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Employee greg = (Employee) session.getAttribute("user");
		
		if (greg == null) {//and greg admin
			return "bad.chan";
		}
		
		
		String outstuff = "";
		List<RequestForm> list = service.selectAllPendingTickets();
		for(RequestForm r: list) {
			Employee jeff=r.getEmployee();//
			String cheese=s1+jeff.getFirstName()+" "+jeff.getLastName()+s2+r.getEid()+s3+r.getDateSubmited()+s4+
					r.getId() + s5 + type[r.getType()]+s6+r.getAmount()+s7+r.getNotes()+s8+s9+s10+r.getId()+s11;
			outstuff+=cheese;
		}
		
		//
		//title
		req.setAttribute("allthethings", outstuff);

		
		return "WEB-INF/temp/adminTemp.jsp";
	}
	
	public static String adminSubmit(HttpServletRequest req) {
		System.out.println(req.getParameter("id"));
		int id=Integer.parseInt(req.getParameter("id"));
		int status = Integer.parseInt(req.getParameter("pending"));
		
		String notes = req.getParameter("notes");
		
		if(service.updateTicket(id,status)) {
			Util.LOGGY.info("---Form Submitted---");
		}
		else {
			System.out.println("--form bounced--");			
			Util.LOGGY.error("---Form Didn't Work---");
			return "logout.chan";
		}
		
		return admin(req);
	}

}

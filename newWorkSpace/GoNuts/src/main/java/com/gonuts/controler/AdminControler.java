package com.gonuts.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	
	static String[] type= {"","Lodging","Travel","Food","Other"};
	
	
	static{
		s1="<form method='post' action='/GoNuts/submit2.chan'>"+
           "<div class='card text-white bg-dark mb-3 mx-auto align-middle rounded' style='width: 1000px;'>"+
               "<div class='card-body'>"+
                   "<div class='container'>"+
                       "<div class='row'>"+
                           "<div class='col-sm'>"+
                               "Name: ";
								s2="</div><div class='col-sm'>Employee ID: ";
								s3="</div> <div class='col-sm'>Date Submitted: ";
								s4="</div><div class='col-sm'></div></div><br><div class='row'><div class='col-sm'>Form ID: ";
								s5="</div><div class='col-sm'>Type: ";
								s6="</div><div class='col-sm'>Ammount: $";
							s7="</div><div class='col-sm'></div></div><br><div class='row'><div class='col-sm-8'>Notes: ";
						s8="</div><div class='col-sm-4'>"
								+ "<select name='pending'><option disabled selected>Pending</option>";
					s9="<option value='1'>Approved</option><option value='2'>Denied</option></select>";
				s10="<button type='submit' class='btn' style='background-color: rgb(231, 120, 213);'>Submit</button>";
				s11="</div></div></div></div></div></form>";
								
					
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
					r.getId() + s5 + type[r.getType()]+s6+r.getAmount()+s7+r.getNotes()+s8+s9+s10+s11;
			outstuff+=cheese;
		}
		
		//
		//title
		req.setAttribute("allthethings", outstuff);

		
		return "WEB-INF/temp/adminTemp.jsp";
	}

}

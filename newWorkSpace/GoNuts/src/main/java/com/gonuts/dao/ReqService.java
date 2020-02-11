package com.gonuts.dao;

import java.util.List;

import com.gonuts.model.Employee;
import com.gonuts.model.RequestForm;


public class ReqService {
	private static ReqDao dao=new ReqDao();

	//login
	public Employee login(String uname, String pw) {
		return dao.selectEmployee(uname, pw);
	}
	
	//selectAllTickets
	public List<RequestForm> selectAllPendingTickets(){
		return dao.selectAllPendingTickets();
	}
	
	//insertTicket
	public boolean insertTicket(RequestForm ticket) {
		return dao.insertTicket(ticket);
	}
	
	//UpdateTicket
	public boolean updateTicket(int id,int status) {
		return dao.updateTicket(id,status);
	}
}

package com.dnut.dao;

import java.util.ArrayList;
import java.util.List;

import com.dnut.model.Employee;
import com.dnut.model.RequestForm;

public class RequestService {
	private static RequestDao dao=new RequestDao();

	
	//login
	public Employee login(String uname, String pw) {
		return dao.selectEmployee(uname, pw);
	}

	
	//selectAllTickets
	public List<RequestForm> selectAllPendingTickets(){
		List<RequestForm> list=new ArrayList<>();
		
		
		
		return list;
	}
	
	//insertTicket
	public void insertTicket(RequestForm ticket) {
		
	}
	
	//UpdateTicket
	public void updateTicket(RequestForm ticket) {
		
	}
	
	
}

package com.proyect1.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.proyect1.dao.interf.RequestDao;
import com.proyect1.daoimpl.RequestDaoImpl;
import com.proyect1.model.Employee;
import com.proyect1.model.Ticket;
import com.proyect1.service.interf.RequestServiceInterface;

public class RequestServiceImpl implements RequestServiceInterface {
	RequestDao requestDao=new RequestDaoImpl();

	@Override
	public void sendRequest(String ticket_type, int Amount, int emp_id,String descrip) {
		
		requestDao.insertRequest(ticket_type, Amount, emp_id, descrip);
		
		
	}

	@Override
	public void SetRequestStatus(int ticket_id) {
		
		 requestDao.updateRequestStatus(ticket_id);
	}

	@Override
	public List<Ticket> getAllRequest() {
		List<Ticket> requestList=requestDao.selectAllTicket();
		for (int i = 0; i <requestList.size(); i++) {
			
			System.out.println(requestList.get(i));
			
		}
		
		return requestList;
	}

	@Override
	public Employee getEmployee(String username) {
			return requestDao.getEmployee(username);
	}
	public List<Employee> getAllEmployee() {
		List<Employee> emp=new ArrayList<Employee>();
		
		return requestDao.selectAllEmployee();
		
	}

}

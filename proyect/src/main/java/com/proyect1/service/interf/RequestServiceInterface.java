package com.proyect1.service.interf;

import java.util.List;

import com.proyect1.model.Employee;
import com.proyect1.model.Ticket;

public interface RequestServiceInterface {
	
	public void sendRequest(String ticket_type,int Amount,int emp_id,String descrip);
	//public String setRequestStatus(int ticket_id);
	public List<Ticket> getAllRequest();
	 public void SetRequestStatus(int ticket_id);
  public Employee getEmployee(String username);
  public List<Employee> getAllEmployee();
}

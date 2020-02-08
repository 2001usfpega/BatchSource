package com.proyect1.dao.interf;

import java.util.List;

import com.proyect1.model.Employee;
import com.proyect1.model.Ticket;

public interface RequestDao {
	
	public int selectEmpId(String username,String pass);
	
	public int insertRequest(String ticket_type,int Amount,int emp_id,String descrip);
	
	public List<Ticket> selectAllTicket();
	public void  updateRequestStatus(int ticket_id);
	public int selectEmpId(int emp_id);
	public Employee getEmployee(String username);
	public List<Employee> selectAllEmployee();
	
	
	

}

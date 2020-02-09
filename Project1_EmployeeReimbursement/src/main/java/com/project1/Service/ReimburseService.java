package com.project1.Service;

import com.project1.DAO.ReimburseDAOImpl;

public class ReimburseService {
	
	public String newRecord(int emp_id,int re_type, double amount, String info){
		ReimburseDAOImpl.newRecord(emp_id, re_type, amount, info);
		return "New Record inserted";
	}
	public void approverecord(String status, int id) {
		ReimburseDAOImpl.updateRecord(status, id);
	}

}

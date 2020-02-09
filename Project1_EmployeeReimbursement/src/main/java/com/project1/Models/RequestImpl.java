package com.project1.Models;

public class RequestImpl {
	int request_id;// request id
	int emp_id;// submitted employee id 
	String statues;// status of the request
	int re_type; //reimbursement type
	double amount; // amount requested
	String date_sub; // date the request was submmitted
	String date_res; // date the request is resolved
	String info; //any information submitted about the request
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getStatues() {
		return statues;
	}
	public void setStatues(String statues) {
		this.statues = statues;
	}
	public int getRe_type() {
		return re_type;
	}
	public void setRe_type(int re_type) {
		this.re_type = re_type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate_sub() {
		return date_sub;
	}
	public void setDate_sub(String date_sub) {
		this.date_sub = date_sub;
	}
	public String getDate_res() {
		return date_res;
	}
	public void setDate_res(String date_res) {
		this.date_res = date_res;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

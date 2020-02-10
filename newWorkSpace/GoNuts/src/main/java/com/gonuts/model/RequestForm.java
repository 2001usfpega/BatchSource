package com.gonuts.model;

import java.sql.Date;

public class RequestForm {
	private int id;
	private int type;
	private double amount;
	private Date dateSubmited;
	private Date dateResolved;
	private int status;
	private String notes;
	private int eid;
	private Employee empl;
	
	public RequestForm(int id, int type, double amount, Date dateSubmited, Date dateResolved, 
			int status, String notes, int eid, Employee empl) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.dateSubmited = dateSubmited;
		this.dateResolved = dateResolved;
		this.status = status;
		this.notes = notes;
		this.eid = eid;
		this.empl = empl;
	}
	
	//for a submit request
	public RequestForm(int type, double amount, String notes, int eid) {
		super();
		this.type = type;
		this.amount = amount;
		this.notes = notes;
		this.eid = eid;
	}

	public int getId() { return id;	}
	public int getType() { return type;	}
	public double getAmount() { return amount; }
	public Date getDateSubmited() { return dateSubmited; }
	public Date getDateResolved() { return dateResolved; }
	public int getStatus() { return status; }
	public String getNotes() { return notes; }
	public int getEid() { return eid; }
	public Employee getEmployee() { return empl; }

	/*
	 * set
	*/
//	public void setType(int type) {
//		this.type = type;
//	}
//
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//
//	public void setDateResolved(Date dateResolved) {
//		this.dateResolved = dateResolved;
//	}

	public void setStatus(int status) {
		this.status = status;
	}

	
//	public void setNotes(String notes) {
//		this.notes = notes;
//	}
//
//	public void setEid(int eid) {
//		this.eid = eid;
//	}
}

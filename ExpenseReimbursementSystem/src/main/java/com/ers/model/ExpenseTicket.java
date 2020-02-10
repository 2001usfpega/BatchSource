package com.ers.model;

import java.sql.Date;

public class ExpenseTicket {
	
	private int ticketid;
	
	private int type;
	
	private double amount;
	
	private Date dateSubmitted;
	
	private Date dateResolved;
	
	private String status;
	
	private String description;
	
	/**
	 * Links the ExpenseTicket to the Employee
	 */
	private int userid;
	
	public ExpenseTicket() {
		// TODO Auto-generated constructor stub
	}

	public ExpenseTicket(int ticketid, int type, double amount, Date dateSubmitted, Date dateResolved, String status,
			String description, int userid) {
		super();
		this.ticketid = ticketid;
		this.type = type;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.status = status;
		this.description = description;
		this.userid = userid;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ExpenseTicket [ticketid=" + ticketid + ", type=" + type + ", amount=" + amount + ", dateSubmitted="
				+ dateSubmitted + ", dateResolved=" + dateResolved + ", status=" + status + ", description="
				+ description + ", userid=" + userid + "]";
	}
	
	
	
}

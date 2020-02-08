package com.proyect1.model;

import java.sql.Date;

public class Ticket {
	private int ticket_id;
	private String ticket_type;
	private int ticket_amount;
	private String ticket_status;
	private int emp_id;
	private Date dateSubmited;
	private String description;
	
	
	
	public Ticket() {}
	
	public Date getDateSubmited() {
		return dateSubmited;
	}

	public void setDateSubmited(Date dateSubmited) {
		this.dateSubmited = dateSubmited;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", ticket_type=" + ticket_type + ", ticket_amount=" + ticket_amount
				+ ", ticket_status=" + ticket_status + ", emp_id=" + emp_id + ", dateSubmited=" + dateSubmited
				+ ", description=" + description + "]";
	}

	
	public Ticket(int ticket_id, String ticket_type, int ticket_amount, String ticket_status, int emp_id,
			Date dateSubmited, String description) {
		super();
		this.ticket_id = ticket_id;
		this.ticket_type = ticket_type;
		this.ticket_amount = ticket_amount;
		this.ticket_status = ticket_status;
		this.emp_id = emp_id;
		this.dateSubmited = dateSubmited;
		this.description = description;
	}

	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getTicket_type() {
		return ticket_type;
	}
	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	public int getTicket_amount() {
		return ticket_amount;
	}
	public void setTicket_amount(int ticket_amount) {
		this.ticket_amount = ticket_amount;
	}
	public String getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

}

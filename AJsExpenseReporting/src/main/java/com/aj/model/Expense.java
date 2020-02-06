package com.aj.model;

import java.sql.Date;

public class Expense {
	private long exp_id, fk_e_id;
	private int type;
	private Date submitted, resolved;
	private String state = "pending";
	private float amount;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(long exp_id, long fk_e_id, int type, Date submitted, Date resolved, String state, float amount) {
		super();
		this.exp_id = exp_id;
		this.fk_e_id = fk_e_id;
		this.type = type;
		this.submitted = submitted;
		this.resolved = resolved;
		this.state = state;
		this.amount = amount;
	}

	public long getExp_id() {
		return exp_id;
	}

	public void setExp_id(long exp_id) {
		this.exp_id = exp_id;
	}

	public long getFk_e_id() {
		return fk_e_id;
	}

	public void setFk_e_id(long fk_e_id) {
		this.fk_e_id = fk_e_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	@Override
	public String toString() {
		return "Expense [exp_id=" + exp_id + ", fk_e_id=" + fk_e_id + ", type=" + type + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", state=" + state + ", amount=" + amount + "]";
	}

	
}

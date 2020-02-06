package com.aj.model;

import java.sql.Date;

public class Expense {
	private Integer exp_id, fk_u_id;
	private int type;
	private Date submitted, resolved;
	private String state = "pending";
	private float amount;
	private String desc;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(Integer exp_id, Integer fk_u_id, int type, Date submitted, Date resolved, String state, float amount, String desc) {
		super();
		this.exp_id = null;
		this.fk_u_id = null;
		this.type = type;
		this.submitted = submitted;
		this.resolved = resolved;
		this.state = state;
		this.amount = amount;
		this.desc = desc;
	}

	public Integer getExp_id() {
		return exp_id;
	}

	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}

	public Integer getFk_e_id() {
		return fk_u_id;
	}

	public void setFk_e_id(Integer fk_u_id) {
		this.fk_u_id = fk_u_id;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Expense [exp_id=" + exp_id + ", fk_u_id=" + fk_u_id + ", type=" + type + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", state=" + state + ", amount=" + amount + ", desc=" + desc + "]";
	}

	
}

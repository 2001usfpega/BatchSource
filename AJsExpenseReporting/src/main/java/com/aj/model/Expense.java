package com.aj.model;

public class Expense {
	private long exp_id, fk_e_id;
	private String type;
	private String state = "pending";
	private float amount;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(long exp_id, long fk_e_id, String type, String state, float amount) {
		super();
		this.exp_id = exp_id;
		this.fk_e_id = fk_e_id;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	@Override
	public String toString() {
		return "Expenses [exp_id=" + exp_id + ", fk_e_id=" + fk_e_id + ", type=" + type + ", state=" + state
				+ ", amount=" + amount + "]";
	}

	
}

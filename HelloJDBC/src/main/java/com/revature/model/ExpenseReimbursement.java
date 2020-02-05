package com.revature.model;

public class ExpenseReimbursement {
	
	private int reimbursementType;
	double reimbursementAmount;
	String reimbursementDescription;
	
	public ExpenseReimbursement() {
		super();
	}

	public ExpenseReimbursement(int reimbursementType, double reimbursementAmount, String reimbursementDescription) {
		super();
		this.reimbursementType = reimbursementType;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementDescription = reimbursementDescription;
	}

	@Override
	public String toString() {
		return "ExpenseReimbursement [reimbursementType=" + reimbursementType + ", reimbursementAmount="
				+ reimbursementAmount + ", reimbursementDescription=" + reimbursementDescription + "]";
	}

	public int getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(int reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}
	
	
}

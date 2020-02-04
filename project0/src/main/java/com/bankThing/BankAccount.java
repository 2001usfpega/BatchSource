package com.bankThing;

public class BankAccount {
	
	private long accountid;
	private double checking;
	private double saving;
	private double credit1;
	private double credit2;
	private double credit3;
	
	public BankAccount(){};
	
	
	public BankAccount(long accountid, double checking, double saving, double credit1, double credit2, double credit3) {
		super();
		this.accountid = accountid;
		this.checking = checking;
		this.saving = saving;
		this.credit1 = credit1;
		this.credit2 = credit2;
		this.credit3 = credit3;
	}


	public long getAccountid() {
		return accountid;
	}


	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}


	public double getChecking() {
		return checking;
	}


	public void setChecking(double checking) {
		this.checking = checking;
	}


	public double getSaving() {
		return saving;
	}


	public void setSaving(double saving) {
		this.saving = saving;
	}


	public double getCredit1() {
		return credit1;
	}


	public void setCredit1(double credit1) {
		this.credit1 = credit1;
	}


	public double getCredit2() {
		return credit2;
	}


	public void setCredit2(double credit2) {
		this.credit2 = credit2;
	}


	public double getCredit3() {
		return credit3;
	}


	public void setCredit3(double credit3) {
		this.credit3 = credit3;
	}

	@Override
	public String toString() {
		return "BankAccount [accountid=" + accountid + ", checking=" + checking + ", saving=" + saving + ", credit1="
				+ credit1 + ", credit2=" + credit2 + ", credit3=" + credit3 + "]";
	}
	
}

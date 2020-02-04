package com.rev;

public class SuperVillain {
	private String name;
	private String power;
	private int bounty;
	
	
	public SuperVillain() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SuperVillain(String name, String power, int bounty) {
		super();
		this.name = name;
		this.power = power;
		this.bounty = bounty;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPower() {
		return power;
	}


	public void setPower(String power) {
		this.power = power;
	}


	public int getBounty() {
		return bounty;
	}


	public void setBounty(int bounty) {
		this.bounty = bounty;
	}


	@Override
	public String toString() {
		return "SuperVillain [name=" + name + ", power=" + power + ", bounty=" + bounty + "]";
	}

}

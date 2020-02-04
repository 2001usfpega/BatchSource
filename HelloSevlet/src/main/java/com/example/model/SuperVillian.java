package com.example.model;

public class SuperVillian 
{
	private String name;
	private String superpower;
	private int bounty;
	@Override
	public String toString() {
		return "SuperVillian [name=" + name + ", superpower=" + superpower + ", bounty=" + bounty + "]";
	}
	public SuperVillian(String name, String superpower, int bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}
	
	public SuperVillian() 
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperpower() {
		return superpower;
	}
	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}
	public int getBounty() {
		return bounty;
	}
	public void setBounty(int bounty) {
		this.bounty = bounty;
	}
	
}

package com.revarture.classtypes;

public class Shark extends Fish implements Hunt
{
	public void findPrey() 
	{
		System.out.println("I ate Fish");
	}
	
	public void swim() 	
	{
		System.out.println("I swim in water and im scary");
	}
	
	public void breathe() 
	{
		System.out.println("I breath underwater");
	}
	
}

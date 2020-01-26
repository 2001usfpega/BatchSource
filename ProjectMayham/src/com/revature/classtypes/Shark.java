package com.revature.classtypes;

public class Shark extends Fish implements Hunt{

	@Override
	public void swim() {
		System.out.println("i swim in water nad im terrifying");
	}

	@Override
	public void breathe() {
		System.out.println("i breath underwater");
		
	}

	@Override
	public void findPrey() {
		System.out.println("i ate fish");
	}
	

}

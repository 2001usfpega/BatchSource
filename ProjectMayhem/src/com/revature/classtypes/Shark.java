package com.revature.classtypes;

public class Shark extends Fish implements Hunt {

	@Override
	public void findPrey() {
		System.out.println("i ate fishes");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		System.out.println("I swim in water and im terrifying");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breathe() {
		System.out.println("I breathe underwater, meeeeeeegh");
		// TODO Auto-generated method stub
		
	}

}

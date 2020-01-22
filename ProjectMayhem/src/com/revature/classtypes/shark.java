package com.revature.classtypes;

public class shark extends fish implements Hunt {

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("I ate fishes!");
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("I breathe under water, meeeeeeeh");
	}

	@Override
	public void findPrey() {
		// TODO Auto-generated method stub
		System.out.println("I swim in wader and im terrifying");
	}

}

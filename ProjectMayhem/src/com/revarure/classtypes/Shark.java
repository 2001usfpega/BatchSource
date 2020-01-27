package com.revarure.classtypes;

public class Shark extends Fish implements Hunt {

	@Override
	public void findFrey() {
		// TODO Auto-generated method stub
		System.out.println("I ate fishes!");
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("I swim in water and Im terrifying.");
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("I breathe underwater, meeeeeeeeeeeeeeh");
	}
	
}

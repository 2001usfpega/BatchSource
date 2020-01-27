package com.revature.classtypes;

public class Shark extends Fish implements Hunt{

	@Override
	public void findPrey() {

		System.out.println("I ate fishes!");
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("I swim in water and im terrified");
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("I beathe underwater, meeeeegh");
	}

}

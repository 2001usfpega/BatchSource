package com.aj.classTypes;

public class Sharks extends Fish implements Hunt {

	@Override
	public void swim() {
		System.out.println("Just keep swimming just keep swimming.");
	}

	@Override
	public void breathe() {
		System.out.println("Breathe in... breathe out...");
		
	}

	@Override
	public void findPrey() {
		System.out.println("I ate fishies!");
		
	}

}

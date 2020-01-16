package com.aj.name;

public class Pitbull extends Mammal {
	static int sv;
	
	public void eat() {
		System.out.println("I'm a pitbull who is eating!");
	}
	
	public void eat1() {
		int a = 5;
		super.eat();
		System.out.println(a);
	}
}

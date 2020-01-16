package com.aj.name;

public class Pitbull extends Mammal {
	static int sv; // static variable - gets default value of 0;
	public String str; // instance variable - gets default value of null once object is initialized
	
	public void eat() {
		System.out.println("I'm a pitbull who is eating!");
	}
	
	public void eat1() {
		int a = 5; //does not get default value
		super.eat();
		System.out.println(a + sv);
		//Block scope
		if(a == 5) {
			int d = 33;
			System.out.println("I am equal to 5 " + d);
		}
	}
	
	{int a=67; //does not get default value
	System.out.println(a);
	}
}

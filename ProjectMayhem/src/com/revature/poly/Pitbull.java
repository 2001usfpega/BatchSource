package com.revature.poly;

public class Pitbull extends Mammal {
	
	
	static int sv;// gets a default value because "static"
	int x = 5;
	
	
	@Override
	public void eat() {
		System.out.println("I am a pitbull who is eating");
	}
	
	
	
	public void eat1() {
		
		int a = 5; //does not get a default value because "static" is not there
		super.eat();
		System.out.println(a + sv + x);
		if(a==5) {
			System.out.println("Right!");
		}
	}
	//Block Scope this  runs as an instance code block 
	// it runs before the constructor.
	
	{
		int a = 67; // does not get a default value
		System.out.println(a);
	}
	
}

package com.revature.poly;

public class Pitbull extends Mammal {
	static int sv;//gets default value
	public String str;//does get default value (null)
	@Override 
	public void eat() {
		System.out.println("I'm a pitbull who is eating!");}

	public void eat1() {
		int a=5;
		super.eat();
		System.out.println(a+sv);
		//Block Scope
		if(a==5) {
			int d=33;//does not get default value
			System.out.println("Go Tigers!!!!"+d);
		}
	}
	//Block Scope
	{int a = 67; //does not get default value
	System.out.println(a);
	}
}

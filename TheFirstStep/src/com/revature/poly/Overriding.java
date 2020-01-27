package com.revature.poly;

public class Overriding {
	/*Overriding methods
	 * Parent-Child relationship
	 * methods have same signature( modifiers,parameters, names, and any exceptions)
	 * Before java 1.5, had to have the same return type
	 * After 1.5, Co-variant return type(inheritance chain)
	 * Parent must have higher level object than child
	 */
	public static void main(String[] args) {
	
		Mammal m = new Mammal();
	//	m.eat();
		
		PitBull p = new PitBull();
		
		//p.eat();
		p.eat1();
		p.str ="Woo";
		p = new PitBull();
		System.out.println(p.str);
	}

}

package com.revarure.poly;

public class Overriding {
	/*Overriding methods
	 * 	Parent - Child relationship.
	 * 	Methods have the same signature (modifiers, return type, name and parameters, and exceptions).
	 * 	Before Java 1.5, had to have the same return type. After 1.5, Co-variant return type (inheritance chain 
	 *  - with LOWER return type from parent)
	 * 	Parent must have higher level object than child.
	 * 
	 * Shadow definition: same variable name but different scopes inside a class
	 */
	public static void main(String[] args) {
		Mammal myMammal = new Mammal();
		//myMammal.eat();
		
		PitBull myPitBull = new PitBull();
		//myPitBull.eat();
		myPitBull.eat1();
		myPitBull.str = "Woo";
		
		myPitBull = new PitBull();
		System.out.println(myPitBull.str);
		
	}

}

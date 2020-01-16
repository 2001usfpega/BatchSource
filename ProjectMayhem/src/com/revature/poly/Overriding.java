package com.revature.poly;

public class Overriding {
	
	/*
	 * Overriding
	 * Parent - Child class relationship
	 * methods have same signature - this includes modifiers, exceptions and parameters
	 * Before Java 1.5 you had to have the same return type 
	 * after that co-variant return types existed
	 * (inheritance chain) -what does this mean?
	 * Parent must have higher level object than a child 
	 * ex. if Parent is Animal and it has a method
	 * that returns an Animal object then a child will be 
	 * able to override that and return an animal object but not anything
	 * higher than the animal object
	 * like if there where a Creature class above Animal then we woudn't
	 *	be able to return a creature object.
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mammal myMammal = new Mammal();
		
		//Mammal myPitMam = new Pitbull();
		
		Pitbull pit = new Pitbull();
		
		Pitbull pitMam = (Pitbull) new Mammal();
		
		
		myMammal.eat();
		//myPitMam.eat();
		pit.eat();
		pit.eat1();
		//pitMam.eat();
		
	}

}

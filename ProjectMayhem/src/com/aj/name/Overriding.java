package com.aj.name;

public class Overriding {
	/*Overriding Methods
	 * Parent-child class relationship
	 * Methods have the same signature (modifiers, name, parameters, and any exceptions)
	 * Before Java 1.5, you had to have the same return type when overriding methods
	 * After Java 1.5, we have covariant return types (inheritance chain)
	 * Parent must have higher level object than child
	 */
	
	public static void main(String [] saraLance) {
		
		Mammal animal = new Mammal();
		Pitbull olive = new Pitbull();
		animal.eat();
		olive.eat();
		olive.eat1();
		olive.str = "wooo!";
		olive = new Pitbull();
		System.out.println(olive.str);
		
		
	}
}

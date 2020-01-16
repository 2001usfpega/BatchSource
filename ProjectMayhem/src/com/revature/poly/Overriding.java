package com.revature.poly;

public class Overriding {
	/* Overriding Methods
	 * Parent-Child class relationship
	 * methods have same signature (modifiers, name, parameters, and any exceptions)
	 * Before Java 1.5, had to have the same return type
	 * After 1.5, Co-variant reutrn type (inheritance chain)
	 * Parent must have higher level object than child
	 */
	public static void main(String[] args) {
		Mammal m = new Mammal();
		//m.eat();
		Chow c = new Chow();
		//c.eat();
		c.eat1();
		c.str="Woo";
		c= new Chow();
		System.out.println(c.str);
	

	}

}

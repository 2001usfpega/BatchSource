package com.revature.poly;

public class Overriding {
	/*Overriding methods
	 * Parent-Child Class Relationship
	 * methods have same signature (modifiers, name, parameters, and any exceptions)
	 * Before Java 1.5, you had to have same return type
	 * After Java 1.5, we have Co-variant return type (inheritance chain)
	 * Parent must have higher level object than child
	 */
	public static void main(String[] args) {
	Mammal m = new Mammal();
	//m.eat();
	Pitbull p = new Pitbull();
	//p.eat();
	p.eat1();
	
	p.str="Woo";
	p=new Pitbull();
	System.out.println(p.str);

	}

}

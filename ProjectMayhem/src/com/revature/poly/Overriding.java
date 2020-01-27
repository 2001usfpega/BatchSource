package com.revature.poly;

public class Overriding {
	/*Overriding methods
	 * Parent-Child class relationship
	 * methods have same signature (modifiers, parameters, name, and any exceptions
	 * Before Java 1.5 same return type was needed.
	 * After 1.5 co-variant return types (inheritance chain)
	 * Parent must have higher level object than child
	 */

	public static void main(String[] args) {
		Mammal m = new Mammal();
		//m.eat();
		Pitbull p = new Pitbull();
		p.eat();
		p.eat1();
		p.str ="Woo";
		p = new Pitbull();
		System.out.println(p.str);
		//int p =3; This does not work. We cannot change the type.
		
		
		
	}

}

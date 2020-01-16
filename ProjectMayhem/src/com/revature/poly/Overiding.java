package com.revature.poly;

public class Overiding {
	/*Overriding
	 *Parent child relationship
	 *methods have same signature(modifiers, name, parameters and any exceptions)
	 *Before Java 1.5, had to to have the same return type
	 *After 1.5 Co-variant return type(Inheritance chain)
	 *Parent must have higher level object than child 
	 * 
	 */

	public static void main(String[] args) {
		
		Mammal m= new Mammal();
	//	m.eat();
		Pitbull p = new Pitbull();
		//p.eat();
		p.eat1();
		p.str="Woo";
		p= new Pitbull();
		System.out.println(p.str);

	}

}

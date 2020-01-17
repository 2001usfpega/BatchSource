package com.revature.poly;

public class Overriding {

	public static void main(String[] args) {
		/*Overriding 
		 * Parent-Child relationship between classes
		 * methods have same signature (modifiers, name, parameters, and any exceptions)
		 * Before Java 1.5, had to have same return type
		 * After 1.5 co-variant return types
		 * parent must have the higher level object child
		 */
		
		Mammal m = new Mammal();
		//m.eat();
		Pitbull p = new Pitbull();
		//p.eat();
		p.eat1();
		p.str="woo";
		p=new Pitbull();
		System.out.println(p.str);
	}

}

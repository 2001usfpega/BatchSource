package com.revature.poly;

public class Overriding {
	
	/*
	 * Overriding
	 * Parent-Child relationship 
	 * methods have the same signature (modifiers, name, and parameters, and any exceptions
	 * before java 1.5, had to have the same return type
	 * after 1.5, we have co-variant return type (inheritance) 
	 * Parent must have higher level object than child
	 * 
	 */

	public static void main(String[] args) {
		
		Mammal m =  new Mammal();
		
		//m.eat();
		
		
		Pitbull p = new Pitbull(); 
		
		//p.eat();
		
		p.eat1();
		
		p.str="Woo";
		
		p= new Pitbull();
		
		System.out.println(p.str);
		

		 

		
		

	}

}

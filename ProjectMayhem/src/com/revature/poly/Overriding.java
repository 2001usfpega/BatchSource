package com.revature.poly;

public class Overriding {
<<<<<<< HEAD
	/*Overriding methods
	 * Parent-Child class relationship
	 * methods have same signature ( modifiers,  name,parameters, and any exceptions)
	 * Before Java 1.5, had to have same return type
	 * After 1.5, Co-variant return type (inheritance chain)
	 * Parent must have higher level object than child
	 */
	public static void main(String[] args) {
	Mammal m = new Mammal();
	//m.eat();
	Pitbull p = new Pitbull();
	//p.eat();
	p.eat1();
	p.str="Woo";
	p= new Pitbull();
	System.out.println(p.str);
	
	
=======

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
>>>>>>> 494dbe7d7201acd9f07197775f77d0032c64d4e3
	}

}

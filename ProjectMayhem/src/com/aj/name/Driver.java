package com.aj.name;

import com.aj.staticfun.FunWithStatic;
import com.revature.bean.Person;

public class Driver {

	//this is a single line comment
	
	/*this is a multi-
	 * line comment
	 * here
	 * 
	 * Naming conventions:
	 * Classes and Projects - Pascal case - capitalize first letter of every work
	 * Methods and Variables - Camel case - first letter lowercase, capitalize all other first letters of words
	 * packages - all lowercase, separated by periods
	 * constants - ALL_CAPS_SEPARATED_BY_UNDERSCORES
	 */
	
	public static void main(String [] args) {
		//public - access modifiers - everybody can 'see' it
		//static - belongs to class, no object needed to use method
		//void - doesn't return any data
		//String [] args - an array of parameters
		
		int a = 3;
		int b = 46;
		int c = a + b;
		System.out.println(a + b + c);
		
		/*
		 * Members of a class- can diff forms
		 * Variables, Methods, and Constructors
		 * Instance variables- property belongs to specific object
		 * Static variables- belong to class/all instances
		 * Instance methods- behavior related to a specific object
		 * Static methods - relative to the entire class
		 * Constructors- instantiates the class using the keyword "new"
		 */
		Person p = new Person();
		p.setName("Jim");
		System.out.println(p);
		Person q= new Person("BobPam", 81, 27);
		System.out.println(q);
		
		FunWithStatic fws = new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
	}
}

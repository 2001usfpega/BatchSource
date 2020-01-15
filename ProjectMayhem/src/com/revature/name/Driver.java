package com.revature.name;

import com.revature.bean.Person; //<-- fully Qualified Class Name

public class Driver {

	//single line comment
	/*
	 * Multi-line
	 * comment
	 * llala
	 * la
	 * Naming Conventions
	 * Classes and Projects - Pascal casing ex. ProjectMayhem
	 * methods and variables - Camel casing ex. firstSecondThird
	 * package - all lower case, seperated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	
	// main method - SERVES AS THE ENTRY POINT FOR AN APPLICATION
	public static void main (String [] args) {
	/* public - access modifiers, erbody can "see" it
	   static - belongs to the class, no object needed
	 * void- doesnt return anything
	 * main - name of method
	 * String - [] args - an array of Strings called args
	 */
	//int a;
	//int b; or
	//int a,b;
	int a = 3;
	int b= 46;
	int c = a + b;
	// sysout control space
	System.out.println("I like to eat "+ c +" tacos");
	/*
	 * Members of a class- can diff forms
	 * Vars., Methods, and constructors
	 * instance Vars. - property belong to specific object
	 * static vars.- belong to class/ all instances
	 * Instance methods- behavior related to a specific object
	 * Static methods - relative to the entire class
	 * Constructors - instantiates the class using the keyword "new"
	 * 
	 */
	Person p = new Person();
	p.setName("Jim");
	System.out.println(p);
	Person q= new Person("BobPAN", 81, 27);
	System.out.println(q);
}
}	

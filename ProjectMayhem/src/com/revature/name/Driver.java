package com.revature.name;

import com.revature.bean.Person;// <-- Fully Qualified Class Name

public class Driver {

		//This is how you do a single line comment
	/* This is how you 
	 * do a multi- line
	 * comment.
	 * 
	 * Naming Conventions
	 * Classes and Projects - Pascal casing ex. ProjectMayhem
	 * methods and variables - Camel casing ex. firstSecondThird
	 * package- all lower case, separated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	
	//Main method - serves as the entry point for an application
	public static void main(String [] args) {
		//public - access modifier, everybody can see it
		//static - belongs to the class, no object needed
		//void - doesn't return anything
		//main - is the name of the method
		//String [] args - an array of Strings called args
		int a = 3;
		int b = 46;
		int c = a + b;
		System.out.println("I like to eat " + c+" tacos!");
		/*
		 * Members of a class can have diff forms
		 * Variables, Methods, and Constructors
		 * Instance Variables - property belongs to specific object
		 * Static Variables - belong to class/all instances
		 * Instance Methods - behavior related to a specific object
		 * Static Method - relative to the entire class
		 * Constructors - instantiates the class using the "new" keyword
		 * 
		 */
		Person p = new Person();
		p.setName("Jim");
		System.out.println(p);
		Person q = new Person("BobPam",81, 27);
		System.out.println(q);
	}
}

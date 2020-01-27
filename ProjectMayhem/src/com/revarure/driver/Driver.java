package com.revarure.driver;

import com.revarure.bean.Person; //<--  Fully Qualified Class Name
import com.revarure.staticfun.FunWithStatic;

public class Driver {

	// Single line comment
	/*
	 * Multi line comment
	 * 
	 * Naming Conventions Classes and Projects - Pascal casing ex. ProjectMayhem.
	 * Methods and variables - Camel casing ex firstSecondThird. 
	 * Package - all lower case, separated by periods.
	 * Constant - ALL_CAPS_LOLZ
	 */

	// Inherit, Abstract, ..., ... class

	// Main Method - serves as the entry point for an application
	public static void main(String[] args) {
		// public - access modifiers everybody can see it
		// static - belong to the class, no object needed
		// void - does not return anything
		// main - name of the method
		// String [] args - an array of Strings called args

		int a = 3;
		int b = 6;
		int c = a + b;

		// Short key: sysout + Ctrl + Space
		System.out.println("I like to eat " + c + " tacos");

		/*
		 * Members of a class - can diff forms Variables, methods, and constructors
		 * Instance variable - property belongs to specific object 
		 * Static variables - belong to class / all instances 
		 * Instance methods - behavior related to a specific object 
		 * Static methods - relative to the entire class 
		 * Constructors - instantiates the class using the keyword "new"
		 */
		Person p = new Person(); //Ctrl+Shift+O to import package
		p.setName("Jim");
		p.setAge(32);
		System.out.println(p);
		
		Person q = new Person("BobPam", 81, 27);
		System.out.println(q);
		
		System.out.println(p.equals(q));
		
		p.increaseAgeBy(-3);
		System.out.println(p.getAge());
		/*
		 * Static area
		 */
		
		/*
		 * FunWithStatic fws = new FunWithStatic(); //Called by the object
		 * fws.nonStaticMethod(); //Called by the class FunWithStatic.staticMethod();
		 * 
		 * Object o =new Object();
		 */
		
		
		
	}

}

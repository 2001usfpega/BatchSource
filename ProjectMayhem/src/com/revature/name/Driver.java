package com.revature.name;

import com.revature.bean.Person; // Fully qualified class name
import com.revature.staticfun.FunWithStatic;

// This is a single line comment
	
	/*
	 * multiple
	 * line
	 * comment
	 */
	
	/* Naming convention:
	 * Classes and projects are PascalCasing 
	 * Methods and variables: camalCase
	 * package: all.lower.case.seperated.by.periods
	 * constants: ALL_CAPS_WITH_UNDERSCORES
	 */
public class Driver{
	// Main Method: Serves as the entry point for an application
	public static void main(String [] args) {
		
		//public: access modifier, everybody can 'see' it
		//static: belongs to the class, no object needed
		//void: doesn't return anything
		//main - name of method
		//String [] args: an array of strings called args
		int a = 3;
		int b = 46;
		int c = a+b;
		System.out.println("I have determined the answer is " + c);
		
		/*
		 *Members of a class: can have diff forms
		 *Variables, Methods, Constructors
		 *Instances and Static Variables:
		 *Instance Variables: property belonging to specific object
		 *Static variables: belong to class/all instances
		 *Instance Methods: Method/Behavior related to a specific object
		 *Static Methods: relative to the entire class
		 *Constructors: instantiates the class using the keyword "new"
		 *
		 */
		
		/*
		 * Person p = new Person(); p.setName("JIM"); System.out.println(p);
		 * 
		 * Person q = new Person("BobPam", 81, 27); System.out.println(q);
		 */
		p.increaseAgeBy(3);
		System.out.println(p.getAge());
		
		FunWithStatic fws = new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
		fws.staticMethod();
		
		Object o = new Object();
		
		
   

		
		
	}
}

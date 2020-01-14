package com.revature.mayhem;

public class Driver {
	/*
	 * Naming Convention:
	 * Classes and Projects: PascalCasing
	 * Functions and Variables: camelCasing 
	 * Package: all.lower.case.use.dots.to.separate.words, reversed domain name of company
	 * Constants: ALL_CAPS
	 * 
	 * */
	//Main Method: Serves as an entry point for the application
	public static void main(String [] args) {
		/*
		 * public: access modifier, everybody can see it
		 * static: belongs to class, no object needed
		 * void: nor return type
		 * main: name of method
		 * String [] args: array of string called args
		 */
		int a = 3, b = 46;
		int c = a + b;
		System.out.println(c);
	}
	
}

package com.revature.generics;

public class GenOne <T> {
	
	/*Generics
	 * using a type as parameter
	 * write code that can handle diff types of objects
	 * use angle brackets <> to denote that something is a generic
	 * Allows us to ensure type safety
	 * adds stability and reusability to our code
	 * placeholder (T, E, ? etc.) - use instead of an explicit type
	 * 
	 */
	//declare an object of tyep T
	
	T ob;
	//pass the constructor a reference to an object of tyep T
	GenOne(T o){
		ob = o;
	}
	//gettter
	T getOb() {
		return ob;
	}
	//method to show the type of T
	void showType() {
		System.out.println("Type of T is: "+ob.getClass().getName());
	}
}

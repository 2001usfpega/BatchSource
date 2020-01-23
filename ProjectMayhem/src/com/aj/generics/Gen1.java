package com.aj.generics;

public class Gen1<T>{
	/*
	 * Generics
	 * **Important Stuff**
	 * 	-ensures TYPE SAFETY
	 * 	-adds stability
	 *  -enhances reusability
	 * using a type as a parameter
	 * write code that can handle different types of objects
	 * uses angle brackets <> to denote that something is generic
	 * allows us to ensure type safety
	 * adds stability and reusability to our code
	 * placeholder (T, E, ?, etc) - used instead of an explicit type
	 *
	 */
	
	//declare an object of type T
	T ob;
	
	//pass the constructor a reference to an object of type T
	Gen1(T o)  {
		ob = o;
	}
	
	//getter
	T getOb() {
		return ob;
	}

	//show type of T
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}

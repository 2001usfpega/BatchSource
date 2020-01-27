package com.revarure.generic;

public class Gen1<T> {
	/*
	 * Generics
	 * using a type as parameter
	 * write code that can handle diff types of objects
	 * use angle brackets <> to denote that something is a generic
	 * Allow us to ensure type SAFETY
	 * and STABILITY and REUSABILITY to our code
	 * Placeholder(T,E,?,etc) - use instead of an explicit type
	 */
	
	//declare an object of type T
	T ob;
	
	//pass the constructor a reference to an object of type T
	Gen1(T o){
		ob = o;
	}
	
	//getter
	T getOb() {
		return ob;
	}
	
	//show type of T
	void showType() {
		System.out.println("Type of T is: " + ob.getClass().getName());
	}
}

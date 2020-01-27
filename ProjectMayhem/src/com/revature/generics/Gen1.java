package com.revature.generics;

public class Gen1<T> {
/*
 * Generics
 * using a type as a parameter
 * write code that can handle diff types of objects
 * use angle brackets to edenote that something is generic
 * allows us to ensure type safety
 * adds stability and reusability to our code
 * Placehoder(T,E, ?, etcs.) - use instead of an explicit type
 * declare an object of type T
 * 
 */
	
	T ob;
	//pass the constructor a refernce to an object of type T
	
	Gen1(T o){
		ob=o;
	}
	//getter
	T getOb() {
		return ob;
	}
	
	//show type of T
	void showType() {
		System.out.println("type of T is: "+ ob.getClass().getName());
	}
	
}

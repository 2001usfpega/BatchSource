package com.revature.generics;

public class Gen1 <T> {
	/*Generics
	 * using a type as parameter
	 * write code that can can handle all diff types of objects
	 * use angle brackets <> to denote that something is a generic
	 * Allows us to ensure type safety
	 * adds stability and reusability to our code
	 * placeholder (T,E,?,etc) - use instead of explicit type
	 * 
	 */
	
	T ob;
	//pass the constructor a reference to an object of object T.
	Gen1(T o){
		ob = o;
		
	}
	//getter
	T getOb() {
		return ob;
		
	}
	// Show type of T
	void showType(){
		System.out.println("Type of T is:" + ob.getClass().getName());
		// TODO Auto-generated method stub

	}

}

package com.revature.generics;

public class Gen1<T> {
/*Generics
 * using a type as parameter
 * write code tha can handle diff types of objects
 * use angle brackets <> to denote that something is generic
 * Allows us to ensure type safety
 * adds stability reusability to our code
 * Placeholder(T,E,?,etc.) use instead of an explicit type
 */
// 	declare an object of Type T
	T ob;
//pass the constructor a reference to an object of type 
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

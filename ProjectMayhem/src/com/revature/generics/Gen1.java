package com.revature.generics;

public class Gen1<T> {
	
	/*Generics 
	 * using a type as parameter
	 * write code that can handle diff type of object
	 * use angle brackets<> to denote that something ia a generic
	 * allows us to ensure type safety
	 * adds stability and reusability to our code
	 * placeholder(t,e,?,etc..) use instead of an explicit type
	 * 
	 * 
	 * */

	// delcalre a object of type t
	T ob;
	//pass the constructor a reference to an object o type
	Gen1(T o){
		ob=o;
		
	}
	public T getOb() {
		return ob;
	}
	public void setOb(T ob) {
		this.ob = ob;
	}
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
		
		
	}
	
}

package com.revature.generics;

public class Gen1<T> {
	
	/*
	 * Generics 
	 * using a type as a parameter
	 * ensure type safety
	 * add stability and resuablity 
	 * placeholder 
	 * 
	 * 
	 * 
	 */
	
	//declare an object of type t
	
	T ob;
	//pass a constructor a reference to an object of type T
	Gen1(T o){
		ob=o;
		
		
	}
	
	T getOb()
	{
		
		return ob;
		
	}
	
	void showType();
	{
		System.out.println("Type of T is:" + ob.getClass().getName());
		
		
		
		
	}

}

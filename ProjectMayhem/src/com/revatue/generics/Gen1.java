package com.revatue.generics;

public class Gen1<T> {
	/*
	 * Generics
	 * using a type as parameters
	 * write code that can handle dif types of objects
	 * use angle brackets<> */
   //DECLARE AN OBJECT OF TYPE t
	T ob;
	//pass the constructor a referecne to an object type T
	Gen1(T o){
		ob=o;
	}
	//getter
	T getOb() {
		return ob;
	}
	//she type of T
	void showType() {
		System.out.println("Type of T is"+ ob.getClass().getName());
	}
	
	
}

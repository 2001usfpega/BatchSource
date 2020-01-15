package com.revature.constructor;
/*
 * Constructors 
 * How we instantiate an object
 * No return type, not specified anyway. returns instance of class
 * If we don"t include a constructor in a class, a default constructor is 
 * automatically created.
 * If we make a constructor, we lose the default constructor
 */
public class ConstructorDemo {
	public static void main(String[] ralph) {
		C c = new C();
	}
}

class A{
	A(){
			System.out.println("Inside of A's constructor");
	}
}

class B extends A{
	/* 
	 * Example of default constructor:
	 * B(){
	 * 	super(); <-- implicit
	 * }
	 */
	
	B(){
	}
}
	
class C extends B{
	C(){
		System.out.println("Inside of C's constructor");
	}
}


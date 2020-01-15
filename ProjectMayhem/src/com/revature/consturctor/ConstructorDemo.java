package com.revature.consturctor;
/*
 * Constructors
 * How we instantiate an object
 * No return type, not specified anyway. returns instance of class
 * If we do not include a constructor in a class, a default
 *  constructor is automatically created
 *  If we make an constructor we lose default
 *  
 */
public class ConstructorDemo {
	public static void main(String[]ralph) {
		System.out.println("help");
		C c = new C();
		B b = new B();
		A a = new A();
		
	}	
}
class A{
	A(){
		System.out.println("Inside of A's Constructor");
	}
}
class B  extends A{
	/* Example of Default Constructor
	 * B() {
	 * super() <- implicit
	 * }
	 */
	B(){
		System.out.println("Inside of B's Constructor");
	}
	
}
class C extends B{
	C(){
		System.out.println("Inside of C's Consturctor");
	}
	
}
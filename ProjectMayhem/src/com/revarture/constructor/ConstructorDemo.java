package com.revarture.constructor;
/*
 * Constructors
 * How we instantiate an object
 * no return type
 * auto default if none made
 * if we make a constructor, we lose the default
 * 
 * 
 * 
 * 
 * */
public class ConstructorDemo 
{
	public static void main(String[]ralph) 
	{
		C c = new C();
		
	}
}

class A
{
	A()
	{
		System.out.println("Inside of A's Consturctor");
		
	}
}

class B extends A
{
	/*
	 * B(){
	 * 		super(0 <- implicit
	 * }
	 * */
	B()
	{
		System.out.println("Inside of B's Consturctor");
	}
	
}

class C extends B
{
	C()
	{
		System.out.println("Inside of C's Consturctor");
	}
}



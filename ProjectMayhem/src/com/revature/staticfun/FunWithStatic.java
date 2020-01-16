package com.revature.staticfun;

/*
 * Static - means that it belongs to the class
 * methods and variables(and inner classes) can be static
 * 
 */

public class FunWithStatic {
	
	public void nonStaticMethod() {
		System.out.println("Not static, belongs to an object");
	}

	public static void staticMethod() {
		System.out.println("Is Static Belongs to the Class");
	}
}

package com.revature.staticfun;
/*
 * Static: belongs to the class
 * Methods and variable (Inner classes) can be static
 */
public class FunWithStatic {
	public void nonStaticMethod() {
		System.out.println("Not Static, belongs to an object");
	}
	public static void staticMethod() {
		System.out.println("is static, belongs to class");
	}
	

}

package com.revature.staticfun;

public class FunWithStatic {
	public void nonStaticMethod() {
		System.out.println("not static, belongs to obj");
	}
	public static void staticMethod() {
		System.out.println("is static, belongs to class");
	}
	
}

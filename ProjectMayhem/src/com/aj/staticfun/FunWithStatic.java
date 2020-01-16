package com.aj.staticfun;

public class FunWithStatic {
	/*Static - belongs to class
	 * Methods and variables (and inner classes) can be static
	 */
	
	public void nonStaticMethod() {
		System.out.println("not static, belongs to an object");
	}
	
	public static void staticMethod() {
		System.out.println("is static, belogs to class");
	}
}

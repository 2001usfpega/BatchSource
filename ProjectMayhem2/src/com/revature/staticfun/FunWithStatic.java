package com.revature.staticfun;
/*Static- means it belongs to the class
 * Methods and Variables (and inner classes) can be static
 * 
 */
public class FunWithStatic {
	public void nonStaticMethod() {
		System.out.println("not static, belongs to an object");
	}
	public static void staticMethod() {
		System.out.println("is static, belongs to class");
	}

}

package com.revature.staticfun;

/*Static - belongsto class 
 * Methods and Variables(and inner classses) can be static
 * 
 */

public class FunWithStatic {
	public void nonStaticMethod() {
		System.out.println("not static, belongs to an object");
		
	}
	public static void staticMethod(){
		System.out.println("is static, belongs to a class");
		
	}

}

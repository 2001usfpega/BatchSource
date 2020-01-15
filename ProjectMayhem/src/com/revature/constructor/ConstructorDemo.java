package com.revature.constructor;
<<<<<<< HEAD
/* Constructors 
 * How we instantiate an object
 * No return type, not specified anyway, returns instance of class 
 * If we don't include a constructor in a class, a default constructor is automatically created.
 * If we make a constructor, we lose the default constructor  
 */



public class ConstructorDemo {
	
public static void main (String ralph []) {
	C c = new C(); 
	
}

}
class A {
	
	A(){      
		      
		System.out.println("Inside of A's Constructor"); 
		
	}

}
class B extends A {
		/*Example of default constructor 
		 * B() {
		 * super() <- implicit
		 *}
		 */
	
	B() {   
	System.out.println("Inside of B's Constructor");
	
	}
}

class C extends B {
	C() {
		System.out.println("Inside of C's Constructor");
	}
	
}

=======
/*
 * Constructors
 * How we instantiate an object
 * No return type, not specified anyway. returns instance of class
 * If we we don't include a constructor in a class, a default constructor is automatically
 * created
 * If we make a constructor, we lose the default
 */
public class ConstructorDemo {
	public static void main(String [] ralph) {
		C c = new C();
		
	}
}
class A{
	A(){
		System.out.println("Inside of A's Constructor");
	}
}
class B extends A{
	/* Example of default constructor
	 * B(){
	 *   super() <- implicit
	 * }
	 */
	B(){
		System.out.println("Inside of B's Constructor");
	}
}

class C extends B{
	C(){
		System.out.println("Inside of C's Constructor");
	}
}
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8

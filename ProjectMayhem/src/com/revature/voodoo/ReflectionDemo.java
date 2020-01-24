package com.revature.voodoo;
<<<<<<< HEAD
import java.lang.reflect.Constructor;
public class ReflectionDemo {

	public static void main(String[] args) {
		
		
		Class<?> c;
		try {
			c=Class.forName("javax.swing.JFrame");
         
			System.out.println("Constructor");
			Constructor<?>[] con=c.getConstructors();
			
			for (Constructor<?> constructors : con) {
				System.out.println(constructors);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
=======

import java.lang.reflect.Constructor;

public class ReflectionDemo {

	public static void main(String[] args) {
		/* reflection api-
		 * a way for java to inspect itself at runtime
		 * breaks encapsulation!
		 * Contains methods for runtime inspection of objects
		 * i.e Class of object, fields methods constructors
		 * this includes private members!
		 * can also instantiate things and invoke methods
		 * java.lang.reflect
		 */
		Class<?> c;
		
		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.println("Constructors: ");
			Constructor<?>[] con= c.getConstructors();
			for(Constructor<?> constructor:con) {
				System.out.println(constructor);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8

	}

}

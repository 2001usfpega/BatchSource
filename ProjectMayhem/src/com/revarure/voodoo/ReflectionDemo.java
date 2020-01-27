package com.revarure.voodoo;

import java.lang.reflect.Constructor;

public class ReflectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Reflection API
		 * a way for java to inspect ifself at runtime
		 * Break encapsulation
		 * Contains methods for runtime inspection of objects
		 * Ex: Class of object, fields methods constructions
		 * this includes private members!
		 * Can also instantiate things and incoke methods
		 * java.lang.reflect
		 */
		
		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.println("Constructor:");
			Constructor<?>[] con = c.getConstructors();
			for(Constructor<?> constructor:con)
				System.out.println(constructor);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.aj.reflection;

import java.lang.reflect.Constructor;

public class ReflectionDemo {
	public static void main(String[] saraLance) {
		/*
		 * Reflection api-
		 * a way for java to inspect itself at runtime
		 * breaks encapsulation
		 * Contains methods for runtime inspection of objects
		 * i.e. Class of object, fields, methods, constructors
		 * this includes private members
		 * can also instantiate things and invoke methods
		 * java.lang.reflect
		 */
		Class<?> c;

		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.println("Constructors: ");
			Constructor<?>[] con = c.getConstructors();
			for(Constructor<?> cons : con ) {
				System.out.println(cons);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}

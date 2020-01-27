package com.revature.voodoo;

import java.lang.reflect.Constructor;

public class ReflectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * reflection api -
 * a way for java to inspect itself at runtime
 * breaks encapsulation
 * contains methods for runtime inspeciton of objects
 * i.e. class of objects, fields methods constructoers
 * this cinludes private members
 * can also instatiate things and invoke methods
 * java.lang.reflect
 */
		
		
		
		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.print("Constructors: ");
			Constructor<?>[] con = c.getConstructors();
			for(Constructor constructor:con) {
				System.out.println(constructor);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

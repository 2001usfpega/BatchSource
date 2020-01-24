package com.revature.voodoo;

import java.lang.reflect.Constructor;

public class ReflectionDemo {

	public static void main(String[] args) {
/*
 * relfecttion api
 */
		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.println("Constructors: ");
			Constructor<?>[] con = c.getConstructors();
			for(Constructor<?> constructor:con) {
				System.out.println(constructor);}
		
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
		
		
	
	}
}
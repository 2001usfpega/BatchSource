package com.revature.voodoo;

import java.lang.reflect.Constructor;

public class ReflectionDemo {

	public static void main(String[] args) {
		
		
		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.println("Constructor: ");
			Constructor<?>[] con = c.getConstructors();
			for(Constructor<?> constructor:con) {
			
			System.out.println("Constructor");
			
			}
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		}

		
	}



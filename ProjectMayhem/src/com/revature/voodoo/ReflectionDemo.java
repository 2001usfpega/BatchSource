package com.revature.voodoo;
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
		
		

	}

}

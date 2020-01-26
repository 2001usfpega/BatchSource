package com.revature.voodoo;
import java.lang.reflect.*;

public class ReflectionDeom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");

			System.out.println(" ");
			Constructor<?> [] con = c.getConstructors();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}

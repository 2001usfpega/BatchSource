package com.revature.name;


public class Driver {
	
	//single line comment
	/*
	 * Multi
	 * line
	 * comment
	 * 
	 * Naming conventions:
	 * Classes and Projects - Pascal casing ex. ProjectMayhem
	 * methods and variables - Camel casing ex. firstSecondThird
	 * package - all lower case, separated by by periods
	 * constants - ALL_CAPS
	 */
	//Main method - serves as the entry point for an application
	public static void main(String[] args) {
		/*
		 * public - access modifiers everybody can "see" it
		 * static - belongs to class, no object needed
		 * void - doesn't return anything
		 * main - name of method
		 * String[] args - array of Strings called args
		 */
		int a = 3;
		int b = 46;
		int c = a + b;
		System.out.println(c);
		
	}
}

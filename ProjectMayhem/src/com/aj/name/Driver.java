package com.aj.name;

public class Driver {

	//this is a single line comment
	
	/*this is a multi-
	 * line comment
	 * here
	 * 
	 * Naming conventions:
	 * Classes and Projects - Pascal case - capitalize first letter of every work
	 * Methods and Variables - Camel case - first letter lowercase, capitalize all other first letters of words
	 * packages - all lowercase, separated by periods
	 * constants - ALL_CAPS_SEPARATED_BY_UNDERSCORES
	 */
	
	public static void main(String [] args) {
		//public - access modifiers - everybody can 'see' it
		//static - belongs to class, no object needed to use method
		//void - doesn't return any data
		//String [] args - an array of parameters
		
		int a = 3;
		int b = 46;
		int c = a + b;
		System.out.println(a + b + c);
	}
}

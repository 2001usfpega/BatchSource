package com.revature.name;

import com.revature.bean.Person;  // Fully Qualified Class Name

public class Driver {

	/*Naming Conventions
	/* Classes and Projects are pascal casing ex. Project Mayhem
	 * Methods and variables - Camel case ex firstSecondThird
	 * package- all lowercase, seperated by periods
	 * constants- ALL_CAPS_LOLS
	 */
	
	//Main method - serves as the entry point for an application
	public static void main(String [] args) {
		//public - any class can access 
		//static - belongs to the class, no object needed. 
		/* void - doesnt return anything 
		 * main - name of the method
		 * String [] args - an array of Strings called args */
		 int a = 3;
		 int b = 46; 
		 int c = a + b;
		 System.out.println("I have the answer for " + c);    
		 /* Members of a class - can have different forms
		  * 
		  * Variables, Methods, Constructors
		  * instance and static variables - property belongs to that specific object
		  * Static variables - belong to the class/all instances
		  * Instance methods - behavior related to a specific object
		  * Static methods - relative to the entire class 
		  * Constructors - Instantiates the class using the "new keyword"; 
		  */
		    
		 Person p = new Person();
		 p.setName("Jim"); 
		 System.out.println(p);
		 Person q = new Person("BobPam", 81, 27); 
		 System.out.println(q);
		 
		 
	}
	
	
	
	
}

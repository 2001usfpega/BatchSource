package com.revature.name;

<<<<<<< HEAD
import com.revature.bean.Person; //<-- Fully qualified class name

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
		System.out.println("I like to eat " + c + " tacos");
		/*
		 * Members of a class - can be different forms
		 * Variables, Methods, and Constructors
		 * Instance variables - property belongs to specific object
		 * Static variables - belong to class/all instances
		 * Instance methods - behavior related to a specific object
		 * Static method - relative to the entire class
		 * Constructors - instantiates the class using the keyword "new"
=======
import com.revature.bean.Person; //<-- Fully Qualified Class Name

public class Driver {
	//single line comment
	/*
	 * multi line
	 * comment
	 *
	 * Naming Conventions
	 * Classes and Projects - Pascal casing ex. ProjectMayhem
	 * Methods and Variables - Camel casing ex. firstSecondThird
	 *
	 * package - all lower case, separated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	//Main method - serves as the entry point for an application
	public static void main(String [] args) {
		//public- access modifiers errbody can "see" it
		//static- belongs to class, no object needed
		// void- doesn't return anything
		// main- name of method
		// String [] args-  an array of Strings called args
		int a=3;
		int b=46;
		int c= a+b;
		System.out.println("I like to eat "+ c + " tacos" );
		/*
		 * Members of a class- can diff forms
		 * Variables, Methods, and Constructors
		 * Instance variables- property belongs to specific object
		 * Static variables- belong to class/all instances
		 * Instance methods- behavior related to a specific object
		 * Static methods - relative to the entire class
		 * Constructors- instantiates the class using the keyword "new"
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
		 */
		Person p = new Person();
		p.setName("Jim");
		System.out.println(p);
<<<<<<< HEAD
		Person q = new Person("BobPam", 81, 27);
		System.out.println(q);
=======
		Person q= new Person("BobPam", 81, 27);
		System.out.println(q);
		
		
		
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
	}
}

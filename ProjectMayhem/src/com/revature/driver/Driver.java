package com.revature.driver;

//wild card
//import static java.util.*;
import java.sql.Date;

import com.revature.bean.Person; //<-- Fully Qualified Class Name
<<<<<<< HEAD:ProjectMayhem/src/com/revature/driver/Driver.java
import com.revature.staticfun.FunWithStatic;
=======
import com.revature.saticfun.FunWithStatic;
>>>>>>> 494dbe7d7201acd9f07197775f77d0032c64d4e3:ProjectMayhem/src/com/revature/name/Driver.java

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
		Date d= new Date((long) 5.0);
		java.util.Date e= new java.util.Date();
		
		System.out.println("I like to eat "+ c + " tacos" );
		/*
		 * Members of a class- can diff forms
		 * Variables, Methods, and Constructors
		 * Instance variables- property belongs to specific object
		 * Static variables- belong to class/all instances
		 * Instance methods- behavior related to a specific object
		 * Static methods - relative to the entire class
		 * Constructors- instantiates the class using the keyword "new"
		 */
		Person p = new Person();
		p.setName("Jim");
		System.out.println(p);
<<<<<<< HEAD:ProjectMayhem/src/com/revature/driver/Driver.java
//		Person q= new Person("BobPam", 81, 27);
//		System.out.println(q);
		p.increaseAgeBy(-3);
		System.out.println(p.getAge());
		/*
		 * FunWithStatic fws= new FunWithStatic(); fws.nonStaticMethod();
		 * FunWithStatic.staticMethod(); fws.staticMethod(); Object o= new Object();
		 */
		
<<<<<<< HEAD:ProjectMayhem/src/com/revature/name/Driver.java
		FunWithStatic fws= new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
		fws.staticMethod();
		Object o = new Object();
=======
>>>>>>> origin/KnightenJ:ProjectMayhem/src/com/revature/driver/Driver.java
=======
		Person q= new Person("BobPam", 81, 27);
		System.out.println(q);
		
		FunWithStatic fws = new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
		fws.staticMethod();
>>>>>>> 494dbe7d7201acd9f07197775f77d0032c64d4e3:ProjectMayhem/src/com/revature/name/Driver.java
		
	}
}

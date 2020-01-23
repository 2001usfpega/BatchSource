package com.revature.driver;

import com.revature.bean.Person; //<--Fully Qualified Class Name
import com.revature.staticfun.FunWithStatic;

public class Driver {
	//single line comment
	/*
	 * Multi
	 * line
	 * comment
	 * lol
	 * 
	 * Naming Conventions
	 * Classes and Projects- Pascal casing ex. ProjectMayhem
	 * methods and variables- Camel casing ex. firstSecondThird
	 * package- all lower case, separated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	//Main method - serves as the entry point for an application
	public static void main(String [] args) {
	//public- access modifier errbody can "see" it
	//static- belongs to class, no object needed
	//void- doesn't return anything
	//main- name of method
	//String [] args- an array of strings called args
	int a = 3;
	int b = 46;
	int c = a + b;
	System.out.println("I like to eat " + c + " tacos");
	/*
	 * Members of a class- can have different forms
	 * Variables, Methods, Constructors
	 * instance variables- property belongs to specific object
	 * static variables- belong to class/all instances
	 * instance methods- behavior related to a specific object
	 * static method- relative to entire class
	 * Constructors- Instatntiates the class using the keyword "new"
	 */
	Person p = new Person();
	p.setName("Jim");
	System.out.println(p);
	Person q = new Person("BobPam", 81, 27);
	System.out.println(q);
	p.increaseAgeBy(3);
	System.out.println();
	
	FunWithStatic fws = new FunWithStatic();
	fws.nonStaticMethod();
	FunWithStatic.staticMethod();
	fws.staticMethod();
	Object o = new Object();
	
	}
}

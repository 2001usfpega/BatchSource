package com.revarture.driver;

import com.revarture.bean.Person; //fully qualified class name
import com.revature.staticfun.FunWithStatic;

public class Driver 
{
	
	//single line
	/*Multi line
	 * 
	 * Naming Conventions
	 * Classes and Projects-  Pascal
	 * Methods and Variables- Camel Case
	 * package- all lower case, separated by periods
	 * constants- ALL_CAPS
	 * 
	 * 
	 */
	
	//Main method - serves  as the entry point for an application
	public static void main(String[]args) 
	{
		//public- access modifer everyone can see
		//static- belongs to the class, no obj needed
		//void- no return type
		//main- name of the method
		//String [] args- an array of Strings called args
		int a = 3;
		int b = 46;
		int c = a+b;
		System.out.println("I like to eat " + c + " tacos");
		/*
		 * members of a class
		 *Variables Methods constructors
		 *Instance var- property belong to obj
		 *static var- belong class/ all instances
		 *instance methods- behavior related to a speicific object
		 *Static methods- relative to the entire class
		 *Constructors- instantiates class using keyword  " new " 
		 *
		 *
		 **/
		Person p = new Person();
		p.setName("Jim");
		System.out.println(p);
		Person q = new Person("BobPam" , 81, 27);
		System.out.println(q);
		p.increaseAgeBy(3);
		System.out.println(p.getAge());
		
	
		
		FunWithStatic fws = new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
		fws.staticMethod();
		Object o = new Object();
		
		
	}
}

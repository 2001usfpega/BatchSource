package com.revature.name;

import com.revature.bean.Person;
import com.revature.exceptions.IncreaseByNegativeNumberException;
import com.revature.staticfun.FunWithStatic;

public class Driver {
	
	//single
	
	/*
	 * multi
	 * line
	 * 
	 * Classes and projects are pascal case ex ProjectMayham
	 * methods and variable are camel case  ex oneTwoThree
	 * package lower seperated by dots		ex com.revature
	 * constants are all caps				ex PI_PLUS_TWO
	 * 
	 */
	
	//
	public static void main(String[] args) {
		/* public- visable by all
		 * static- belongs to the class, doesnt need an object
		 * void- doesnt return
		 * main- name of method
		 * String[] args- array of strings
		 */
		
		int a=3;
		int b=46;
		int c=a+b;
		System.out.println("i like to eat " + c + " tacos");
		
		/*
		 * members of a class- can diff forms
		 * instance variables- properties belong to object
		 * static variable - properties belong to class
		 * instance method- behavior
		 */
		Person p = new Person();
		p.setName("jim");
		System.out.println(p);
		p.setAge(82);
		
		Person q= new Person("jeff",18,150);
		System.out.println(q);
		
		FunWithStatic fws=new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
		try {
			p.increaseAgeBy(-3);
			System.out.println(p.getAge());
		}
		catch (IncreaseByNegativeNumberException e) {
			
		}
	}
	
}

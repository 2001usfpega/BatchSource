package com.revarure.loops;

import java.time.Period;

import com.revarure.bean.Person;

public class LoopyLoops {
	/*
	 * If statement
	 * For decision making
	 * provides multiple paths of execution
	 * 
	 * if(<conditional>){
	 * 		<what to do if true>
	 * }else if(<second conditional>){
	 * 		<what to do if second conditional is true>
	 * }else{
	 * 		<what to do if false>
	 * }
	 */

	private static void oldCheck(int age) {
		if (age > 60) {
			System.out.println("Hey, you are old");
		}else {
			System.out.println("You're cool");
		}
	}
	
	/*
	 * Switch cases:
	 * 	Provide multiple paths of execution based on some value
	 * 	The "switch" is based on an integer numeric, a string, a char, a boolean or enum
	 */
	public static void whatColors(String color) {
		switch (color) {
		case "green":
			System.out.println("Grass");
			break;
			
		case "pink":
			System.out.println("Alia's Hair");
			break;
			
		case "yellow":
			System.out.println("Amanda's Sweet Blazer");
			break;

		case "brown":
			System.out.println("A delicious monster");
			break;
			
		default:
			System.out.println("You're dumb");
			break;
		}
	}
	
	/*
	 * For loops
	 * 	for(a;b;c)
	 * 		{do something}
	 * 
	 * a: variable declaration (counter)
	 * b: the condition that controls how far the loop will go
	 * c: is the incrementor/decrementor
	 */
	private static void forLoopFunness(int p) {
		for (int i = p; i >0; i--) {
			if (i==10) {
				//break;
				continue; //skip that iteration
			}
			System.out.println(i);
		}
	}
	
	/*
	 * Enhanced for loop aka for each
	 * 	for(x<Array or Collection)
	 * 		{do thing}
	 * Good for moving through collections, arrays, and other iterable more CPU efficient
	 * No issues with index out of bounds - not size dependent 
	 * Good for access elements in one collection
	 * Bad for adding and removing
	 */
	
	static int [] myArray = {11,32,45,65,76,8,9};
	public static void forEachFun(int [] a) {
		/*
		 * for (int i = 0; i < a.length; i++) 
		 * 		{ System.out.println(a[i]); }
		 */
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
	
	/*
	 * While loops:
	 * 	while(<condition>)
	 * 		{<do something>}
	 * 
	 * Do - While loops:
	 * do{<do something>}
	 * 		while(<condition>)
	 */
	public static void wileyWhile(int i) {
		while (i++<10) {
			System.out.println("Man, loops are so much fun");
			//i++;
		}
	}
	
	public static void doWileyWhile(int i) {
		do {
			System.out.println("Do THING!!!!!!!!!");
			i++;
		} while (i<10);
	}
	
	/*
	 * Conditionals
	 * 	Logical Operators 
	 * < > <= >= != ==
	 * OR:
	 * 		a|b - (pipe in reading) bit wise
	 * 		a||b - short circuit (at least one is true). If a is true, return true without b
	 * AND:
	 * 		a&b - bit wise
	 * 		a&&b - checks boths and evaluates true iff both are true
	 * EQUALS:
	 * 		== : compare values of primitives
	 * 			 compare the reference for objects. NOT THE CONTENTS
	 * 		!= : is good for checking nulls
	 * .equals():
	 * 		method inherited Object. All reference types have it. LOOKING AT CONTENT 
	 */
	
	
	public static void main(String[] args) {
		/*
		 * oldCheck(1237); oldCheck(59);
		 * 
		 * whatColors("green");
		 * 
		 * forLoopFunness(25);
		 */
		
		//forEachFun(myArray);
		
		//doWileyWhile(10);
		Person p = new Person("Matt",33,260);
		Person q = new Person("Matt",33,260);
		System.out.println(p==q); //Reference is not the same
		System.out.println(p==p); 
		System.out.println(p.equals(q)); //The content inside both object is not the same
	}
}

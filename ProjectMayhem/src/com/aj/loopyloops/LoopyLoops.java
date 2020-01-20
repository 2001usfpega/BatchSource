package com.aj.loopyloops;

import com.revature.bean.Person;

public class LoopyLoops {
	/*
	 * If statement
	 * For decision-making
	 * provides multiple paths of execution
	 * 
	 * if(<conditional>){
	 * 	<what to do if true>
	 * }
	 * else{
	 * 	<what to do if false>
	 * }
	 */
	
	public static void oldCheck(int age) {
		if(age > 60) {
			System.out.println("Hey you're old.");
		}
		else {
			System.out.println("you're cool");
		}
	}
	
	/*
	 * Switch cases
	 * provides multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string, a char, a boolean, or an enum.
	 */
	
	public static void whatColor(String color) {
		switch(color) {
		case "red": 
			System.out.println("The color is red");
			break;
		case "green": 
			System.out.println("grass");
			break;
		case "pink":
			System.out.println("alia's hair");
			break;
		default: 
			System.out.println("I don't recognize this color");
		}
	}
	
	/*
	 * For loops
	 * for(a;b;c) {do something}
	 * a is the variable declaration (counter)
	 * b is the condition that controls how far the loop will go
	 * c is the incrementor/decrementor
	 */
	
	public static void forLoopFunness(int p) {
		for(int i = p; i> 0; i--) {
			if(i == 10) {
//				break;
				continue; // skips the iteration that is true
			}
			System.out.println(i);
		}
	}
	
	/*
	 * For each loops
	 * for (x:<Array or collection>) {do thing}
	 * good for moving through collections, arrays, and other iterables
	 * more CPU efficient
	 * no issues with index out of bounds - not size-dependent
	 * good for accessing elements in one collection
	 * bad for adding and removing
	 */
	
	static int[] myArr = {1, 3, 5, 7, 8, 9, 123, 432};
	
	public static void forEachFun(int[] a) {
		for(int i:a) {
			System.out.println(i);
		}
	}
	
	
	/*
	 * While loops
	 * while(<condition>){do something}
	 * 
	 * do while
	 * do {<thing to do>} while (<condition>)
	 */
	
	public static void wileyWhile(int i) {
		while(++i < 10) {
			System.out.println("Man, loops are so much fun.");

		}
	}
	
	public static void doWileyWhile(int o) {
		do {
			System.out.println("This do while loop is cool.");
		} while(o++<10);
		
	}
	
	
	public static void main(String [] saraLance) {
//		oldCheck(1237);
//		oldCheck(12);
//		whatColor("pink");
//		forLoopFunness(25);
//		forEachFun(myArr);
//		wileyWhile(3);
//		doWileyWhile(3);
		
		Person p = new Person("AJ", 30, 200);
		Person q = new Person("AJ", 30, 200);
		

			System.out.println(p.equals(q));
	}
}

/*
 * Conditionals
 * Logical Operators
 * <  >  <= >= != == 
 * 
 * OR
 * a|b - bit wise
 * a||b - short circuit OR -- if a is true, return true w/o b
 * 
 * AND
 * a&b - bit wise
 * a&&b - checks both and evaluates false if a is false, doesn't check b; if a is true, continues on to check b. if b is true,
 * evaluates true.
 * 
 * EQUALS
 * ==
 * compares values of primitives
 * compare the reference for objects, NOT THE CONTENTS
 * != is good for checking nulls
 * 
 * .equals()
 * method inherited from Object class
 * all reference types have it
 * looking at content
 */

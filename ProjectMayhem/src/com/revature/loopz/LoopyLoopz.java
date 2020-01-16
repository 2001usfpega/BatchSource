package com.revature.loopz;

import com.revature.bean.Person;

public class LoopyLoopz {
/*If Statement
 * For decision making
 * provides multiple paths of execution
 * 
 * if(<conditional>) {
 * <what to do if true>
 * } else if(<second conditional>){
 * <what to do if 2nd conditional is true>
 * } else {
 * <what to do if false>
 * }
 */
	public static void oldCheck(int age) {
		if(age>60) {
			System.out.println("Hey, youre old");
		}
		else {
			System.out.println("Get off my lawn");
		}
	}
	/*Switch Case
	 * provide multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string
	 * a char, a boolean, or enum. 
	 */
	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("grass");
			break;
		case "pink":
			System.out.println("Alia's Hair");
			break;
		case "yellow":
			System.out.println("Amanda's Blazer");
			break;
		case "brown":
			System.out.println("a delicious monster");
			break;
		default:
			System.out.println("You're Dumb");
			break;
		
		
		}
	}
	
	/*For Loops
	 * for(a;b;c){do something}
	 * a is variable declaration (counter)
	 * b is the condition that controls how far the loop will go
	 * c is the incrementor/decrementor 
	 */
	public static void forLoopFun(int p) {
		for(int i=p; i>0; i--) {
			if(i==10) {
				//break;
				continue;//skips the previous iteration
			}
			System.out.println(i);
		}
	}
	/* Enhanced for loop aka for each
	 * for(x:<Array or Collection>){do thing}
	 * good for moving through collections, arrays and other iterables
	 * more CPU efficient
	 * no issues w/ index out of bounds- not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing 
	 */
	
	static int [] myArray= {11,22,63,74,56,39,15};
	public static void forEachFun(int[] a) {
		//for(int i=0;i<a.length;i++)
		for(int i:a) {
			System.out.println(i);
		}
	}
	/*While loops
	 * while(<condition>){<do something>}
	 * 
	 * do while
	 * do {<do thing>} while (<condition>)
	 * 
	 */
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("Man, loops are so much fun");
			//i++;
		}
	}
	
	public static void doWileyWhile(int i) {
		do {
			System.out.println("do thing");
		}
		while(i++<10);
	}
	public static void main(String[] args) {
		//oldCheck(1237);
		//oldCheck(59);
		//whatColor("green");
		//forLoopFun(25);
		forEachFun(myArray);
		wileyWhile(3);
		doWileyWhile(3);
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		System.out.println(p.equals(q));
		System.out.println(p==p);
	}
	/*
	 * Conditionals
	 * Logical Operators
	 * <  > <= >= != ==
	 * OR
	 * a|b - bit wise
	 * a||b- short circuit OR If a is true, return true w/o b 
	 * AND
	 * a&b - bit wise
	 * a&&b - checks both and evaluates true iff both are true
	 * EQUALS
	 * ==
	 * compare values of primitives
	 * compare the reference for objects. NOT THE CONTENTS
	 * != is good for checking nulls
	 * .equals()
	 * method inherited Object
	 * All reference types have it
	 * looking at the content
	 */

}

package com.revature.loops;

import com.revature.bean.Person;

public class LoopyLoops {
/* if statement - for decision making
 * provides multiple paths of execution
 * 
 * if(<conditional>){
 * <what to do if true?
 * } else if(<second conditional>){
 * <what to do if 2d conditional is true>
 * } else{
 * <what to do if false>}
 */
	
	public static void oldCheck(int age) {
		if(age>60) {
			System.out.println("Damn, you old!!");
		}else {
			System.out.println("you a youngun...");
		}
	}
	/*Switch Cases:
	 * provides multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string, 
	 * a char, a boolean, or enum.
	 */
	public static void whatColor(String color) {
		switch (color) {
		case "green": 
			System.out.println("You're at least as cool as Rob.");
			break;
		case "pink":
			System.out.println("Alia!!");
			break;
		case "yellow":
			System.out.println("Amanda's blazer");
			break;
		case "brown":
			System.out.println("How now brown cow?");
			break;
		default:
			System.out.println("you have no soul");
		}
	}
	/*For loops
	 * for(a;b;c)(do something)
	 * a is variable declaration (counter)
	 * b is the condition that controls how far the loop will go
	 * c is the increment/decrement
	 */
	
	public static void forLoopFunness(int p) {
		for(int i = p; i>0; i--) {
			if(i==10) {
				//break;
				continue;//skip that iteration
			}
			System.out.println(i);
		}
	}
	/*Enhanced for loop aka "for each" loop
	 * for (x:<Array or Collection>){do thing}
	 * good for moving through collections, arrays, and other iterables
	 * more CPU efficient
	 * no issues w/ index out of bounds - not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing
	 */
	static int [] myArray= {3,4,5,6,7,8,8,100};
	public static void forEachFun(int [] a) {
		//for(int i=0; i<a.length; i++){}
		for(int i:a) {
			System.out.println(i);
		}
	}
	/*While loops
	 * while(<condition>){<do something>1]
	 * 
	 * do while
	 * do{<do thing>}
	 * while (<condition>)
	 */
	public static void wileyWhile(int i) {
		while(i<10) {
			System.out.println("Man loops are so much fun!");
			i++;
		}
	}
	public static void doWileyWhile(int i) {
		do {
			System.out.println("Do your thang!!");
			i++;
		} while (i<10);
	}
	/*Conditionals
	 * Logical Operators
	 * < > <= >= != ==
	 * OR
	 * a|b - bit wise
	 * a||b - short circuit OR if a is true, return true w/o b
	 * AND
	 * a&b = bit wise
	 * a&&b checks both and evaluates true iff both are true
	 * EQUALS
	 * ==
	 * compare values of primitives
	 * compare the reference for objects - NOT THE CONTENTS
	 * != is good for checking nulls
	 * .equals()
	 * method inherited Object
	 * All reference types have it
	 * looking at content
	 */
	public static void main(String[] args) {
		/*oldCheck(1237);
		oldCheck(59);
		whatColor("brown");
		whatColor("burnt sienna");
		forLoopFunness(15);
		System.out.println();
		forEachFun(myArray);
		wileyWhile(4);
		doWileyWhile(6);
		*/
		
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		System.out.println(p.equals(q));
		System.out.println(p==p);
	}
}

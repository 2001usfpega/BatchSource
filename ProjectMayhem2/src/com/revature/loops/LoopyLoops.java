package com.revature.loops;

import com.revature.bean.Person;

public class LoopyLoops {
	/*
	 * If statement
	 * For decision making
	 * provides multiple paths of execution
	 * 
	 * if(conditional){
	 * <what to do if true>
	 * }else if (second conditional){
	 * <what to do if 2nd conditional is true>
	 * }else{
	 * <what to do if false>
	 * }
	 */
	public static void oldCheck(int age) {
		if(age>60) {
			System.out.println("Hey, youre old");
		}else {
			System.out.println("Youre cool");
		}
	}
	/*Switch Cases
	 * provides multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string
	 * a char, a boolean, or enum
	 * 
	 */
	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("Grass");
			break;
		case "pink": 
			System.out.println("Alia's Hair");
			break;
		case "yellow":
			System.out.println("Amanda's sweet blazer");
			break;
		case "brown":
			System.out.println("a delicious monster");
			break;
		default:
			System.out.println("youre dumb");
		}		
	}
	/*
	 * For Loops
	 * for (a;b;c)(do something)
	 * a is variable declaration (counter)
	 * b is the condition that controls how far the loop will go
	 * c is the incremenator/decrementor
	 */
	
	public static void forLoopFunness(int p) {
		for(int i=p; i>0; i--) {
			if(i==10) {
				//break; 
				continue;//skip that iteration
			}
			System.out.println(i);
		}
	}
	/*Enhanced for loop aka for each
	 * for (x:<Array or Collection>{do thing}
	 * good for moving through collections, arrays and other iterables
	 * mor CPU efficient
	 * no issues w/index out of bounds- not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing
	 */
	static int [] myArray = {11,32,45,67,76,8,9};
	public static void forEachFun(int[] a) {
		for(int i:a) { System.out.println(i);}
	}
	
	/*While loops
	 * while(<conditional>){do something}
	 * 
	 * do while
	 * do(<do thing>) while (<condition>)
	 */
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("Man, loops are so much fun");
			//i++;
		}
	}
	public static void doWileyWhile (int i) {
		do {
			System.out.println("do thing");
			i++;
		}
		
		while(i<10);
	}
	public static void main (String[] args) {
//		oldCheck(1237);
//		oldCheck(59);
//		whatColor("green");
//		forLoopFunness(25);
//		forEachFun(myArray);
//		//wileyWhile(3);
//		doWileyWhile(30);
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		System.out.println(p==p);
	}

}

/*
 * Conditionals
 * Logical Operators
 * < > <= => != ==
 * OR
 * a|b - bit wise
 * a||b - short circuit OR If a is true, return w/o b
 * AND
 * a&b - bitwise
 * a&&b checks boths and evaluates true if both are true
 * Equals
 * ==
 * compare values of primitives
 * compare the reference objects, NOT THE CONTENTS
 * != is good for checking nulls
 * .equals()
 * method inherited Object
 * ALl reference types have it
 * looking at content
 */

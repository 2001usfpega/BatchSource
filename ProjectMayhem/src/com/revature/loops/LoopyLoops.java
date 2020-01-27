package com.revature.loops;

import com.revature.bean.Person;

public class LoopyLoops {

	/*
	 * If statement
	 * for decision making
	 * provides multiple paths of execution
	 * 
	 * 
	 * if(<conditional>){
	 * <what to do if true>
	 * }
	 * else if(<second condition>){
	 * <what to do if second conditon true>
	 * } else{
	 * <what to do if false>}
	 * 
	 */
	
	public static void oldCheck(int age) {
		if(age > 60) {
			System.out.println("You're old.");
		}
		else {
			System.out.println("You're not old.");
		}
		
	}
	
	/*
	 * 
	 * Switch cases
	 * provide multiple paths of execution be=ased on some value
	 * the "switch" is based on an integer numeric or string
	 * a char, a boolean, or enum.
	 * 
	 */
	
	public static void whatColor(String color) {
		switch(color) {
		default:
			System.out.println("You're dumb");
			break;
		case"green":
			System.out.println("Grass");
			break;
		case "pink":
			System.out.println("Alia's hair");
			break;
		case "yellow":
			System.out.println("Amanda's Blazer");
			break;
		case "brown":
			System.out.println("A delicious monster");
			break;
		
		}
	}
	
	/*
	 * 
	 * For loops
	 * for(a;b;c)
	 * a is variable declaration(counter)
	 * b is the condition that controls how far the loop will goo
	 * c is the incrementor/decrementor
	 * 
	 */

	public static void forLoopFunness(int p) {
		
		for (int i =p; i>0; i--) {
			
			if(i==10) {
				//break;
				continue; // skip that iteration
			}
			System.out.println(i);
		}
		
	}
	
	/*
	 * Enhanced for loop aka for each loop
	 * for(x:<arrsy or collection>){do something}
	 * good for moving through collections, arrays, or other iterables
	 * more cpu efficient
	 * no issues w/ index out of bounds - not size depenent
	 * good for access elements in one collection
	 * bad for adding and removing
	 */
	
	static int [] myArray = {11,32,45,65,76,8,9};
	public static void forEachFun(int [] a) {
		//for(int i =0; i<a.length; i++){}
		for(int i:a) {
			System.out.println(i);
		}
	}
	
	public static void wileyWhile(int i) {
		
		while(i++<10) {
			System.out.println("Man, loops are so much fun");
			//i++;
		}
	}
	
	public static void doWileyWhile(int i) {
		do {
			System.out.println("do thing");
			i++;
		}
		while(i<10);
	}
	public static void main(String[] args) {
		

		/*
		 * oldCheck(63); oldCheck(59); whatColor("yellow"); forLoopFunness(25);
		 */
		//forEachFun(myArray);
		
//		wileyWhile(3);
//		doWileyWhile(3);
		
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		System.out.println(p==q);
		
		
	}

	
	
	
}

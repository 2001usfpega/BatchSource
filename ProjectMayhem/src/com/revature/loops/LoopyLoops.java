package com.revature.loops;

import com.revature.bean.Person;

public class LoopyLoops {
	
	public static void oldCheck(int age) {
		if(age>60) {
			System.out.println("You're old!");
		}else {
			System.out.println("You're not old yet!");
		}
	}
	
	
	public static void caseCheck(String color) {
		switch(color) {
		case "green": 
			System.out.println("Grass");
			break;
		case "red":
			System.out.println("Ferrari!");
			break;
		case "yellow": 
			System.out.println("Amanda's blazer");
			break;
		default:
			System.out.println("I don't know!");
			break;
		
		}
	}

	
	public static void forLoopFunness(int p) {
		for(int i =p; i>0; i--) {
			if(i==10) {
				continue; //skips what happens when it reaches 10;
			}
			System.out.println(i);
		}
		
		
		
	}
	
	static int [] myArray = {20,11,15,6,11};
	public static void forEachFun(int[] a) {
		for(int i:a) {
			System.out.println(i);
			
			//this is supposedly better than just a regular forLoop
		}
	}
	
	
	
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("Loops are fun");
			//i++;
		}
	}
	
	
	public static void doWileyWhile(int i) {
		do {
			System.out.println("do thing iteration " + i);
			i++;
		}while(i<10);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//oldCheck(67);
		//oldCheck(59);
		
		caseCheck("green");
		
		//forLoopFunness(11);
		
		//forEachFun(myArray);
		doWileyWhile(3);
		
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		
		System.out.println(p==q);
		
		System.out.println(p.equals(q));
		System.out.println(p.getName().equals(q.getName()));
		
	}

	/*
	 * Conditionals
	 * Logical operators
	 * OR
	 * a|b - bit wise
	 * a||b - if either are true
	 * AND
	 * a&b - bit wise
	 * a&&b - both must be true
	 * EQUALS
	 * ==
	 * compare values of primitives
	 * compare the reference for objects. Not the contents
	 * != is good for checking nulls
	 * .equals() actually looks at content inside to see if
	 * its equal
	 * method inherited Object
	 * All reference types have it
	 * looking at content
	 * 
	 */
	
	
	
	
}

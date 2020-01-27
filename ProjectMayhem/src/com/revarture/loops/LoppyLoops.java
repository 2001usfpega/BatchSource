package com.revarture.loops;

import com.revarture.bean.Person;

public class LoppyLoops 
{
	/*If statement
	 * For decision making
	 * Provides multiple paths of
	 * 
	 * if(conditional)
	 * {
	 * 	what to do if true
	 * }
	 * else if(second conditional)
	 * {
	 * 	second conditional is true
	 * }
	 * else
	 * {
	 * 	what to do if false
	 * }
	 * 
	 * */
	public static void oldCheck(int age) 
	{
		if(age > 60) 
		{
			System.out.println("Hey, you're old");
		}
		else 
		{
			System.out.println("youre cool");
		}
	}
	/*
	 * Switch Cases
	 * provides multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string
	 * a char , bool, or enum*/
	
	public static void whatColor(String color) 
	{
		switch (color) 
		{
		case "green":
			System.out.println("grass");
			break;
		case "pink":
			System.out.println("Alia's Hair");
			break;
		case "yellow":
			System.out.println("Amanda's Sweet Blazer");
			break;
		case "brown":
			System.out.println("a delicious Monster");
			break;
		default:
			System.out.println("youre dumb");
			
		}
	}
	/* For Loops 
	 * for(a;b;c){do something}
	 * a is a variable declaration (counter)
	 * b is the condition that controls how far the loops will go
	 * c is a the incrementor/decrementor
	 * */
	public static void forLoopFunness(int p) 
	{
		for(int i=p; i>0; i--) 
		{
			if(i==10) 
			{
				//break;
				continue;// skip that iteration
			}
			System.out.println(i);
		}
	}
	
	/*For Each
	 * for(x:<Array or collection>)
	 * {
	 * 	do thing
	 * }
	 * good for moving through collections, arrays and other iterables
	 * more CPU effiecent
	 * no issues w/ index out of bounds- not siz dependent
	 * good for access elements in one collections
	 * bad for adding and removing
	 * */
	static int [] myArray= {11,32,45,65,76,8,9};
	public static void forEachFun(int[] a) 
	{
		for(int i:a) 
		{
			System.out.println(i);
		}
	}
	
	/*While Lopps
	 * while(Condictional)
	 * {
	 * 	do this
	 * }
	 * do {do thing}
	 * while
	 * {
	 * 	condictional
	 * }
	 * */
	public static void wileyWhile(int i) 
	{
		while(i<10) 
		{
			System.out.println("Man loops are so  fun");
			i++;
		}
	}
	
	public static void doWileyWhile(int i) 
	{
		do 
		{
			System.out.println("Do the thing");
		}
		while(i<10);
	}
	
	/*Conditionals
	 * Logical Operators
	 * < > <= >= != ==
	 * OR
	 * alb - bit wise
	 * allb - short circuit or if a is true, return true w/o b
	 * and
	 * a&b - bitwise
	 * a&&b checks both and evaluates true if both are true
	 * EQUALS
	 * ==
	 * compares values of primitive
	 * compare the reference for objects, NOT THE CONTENTS
	 * != is good for checking nulls
	 * .equals()
	 * method inherited object
	 * all refer types have it
	 * looking at content
	 * */
	
	public static void main(String[] ags) 
	{
		//oldCheck(1237);
		//oldCheck(59);
		//whatColor("green");
		//forLoopFunness(25);
		//forEachFun(myArray);
		//wileyWhile(3);
		//doWileyWhile(3);
		Person p = new Person ("Matt", 33, 260);
		Person q = new Person ("Matt", 33, 260);
		System.out.println(p.equals(q));
		System.out.println(p==p);
	}
	
}

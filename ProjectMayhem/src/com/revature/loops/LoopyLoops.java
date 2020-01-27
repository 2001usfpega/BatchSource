package com.revature.loops;

import com.revature.bean.Person;

public class LoopyLoops {
/*If Statement 
 * for decusion making
 * provides multiple paths of execution
 * 
 * if(<condition>){
 * <what to do if true>
 * }else if (<second conditional>){
 * <what to do if 2nd condition is true>
 * } else{
 * <what to do if false>
 * }
 */
	public static void oldCheck(int age) {
		if(age > 60) {
			System.out.println("Hey, you are old");
		}else {
			System.out.println("youre cool");
		}
	}
	
	/* Swich Cases
	 * provides mulitiple paths of execution based on some value 
	 * the "switch" is the based on an integer numeric, a string
	 *  a char, a boolean, or enum
	 *  
	 */
	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("grass");
			break;
		case "pink":
			System.out.println("ali's Hair");
			break;
		case "yellow":
			System.out.println("Amandas Blazer");
			break;
		case "Brown":
			System.out.println("a delicious monster");
			break;
		default:
			System.out.println("your dumb");
		}
	}
	/* For Loops
	 * for(a;b;c){do something}
	 * a is variable declaation(counter)
	 * b is the condition that controls how far the lool will go
	 * c is the incemento/decremento
	 * 
	 * 
	*/
	public static void forLoopFunness(int p) {
	for (int i=p;i>0;i--) {
		if (i==10) {
			//break;
			continue; //skip that iteration
		}
		System.out.println(i);
	}
		
	}
	/* Enhanced for loop aka for each
	 * for(x:<Array or collection>){do thing}
	 * good for moving through collectiopn, array and other iterables
	 * more CPU efficient
	 * no issues w/ index out of bounds- not size dependent
	 * good for access elements in one collection
	 * bd for addung and removing
	 */
	static int [] myArray= {1,2,3,4,5,6,7};
	public static void forEachFun(int[] a) {
		
		for (int i:a) {
			System.out.println(i);
			}
		}
	/*
	 * While loops
	 * while(<condition){do somthing}
	 * 
	 * do while
	 * do{dothing} whilr(condition
	*/	
	public static void wileyWhile(int i) {
		while(i++<10)
			System.out.println("man, loops are fun");
		// i++	
		}
	public static doWileyWhile(int i) {
		do {
			System.out.println("do thing");
		}
	
	}
		
	
	public static void main(String[] args) {
		oldCheck(1237);
		oldCheck(59);
		whatColor("green");
		forLoopFunness(20);
		wileyWhile(3);
		doWileyWhile(30);
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		System.out.println(p==q);
		System.out.println(p.equals(q));
		System.out.println(p==p);
	}

}
		
/* conditions
 * logical oprators
 * <> <+ >+ != ==
 * or
 * a|b
 * a||b
 * AND
 * a&b - bit wise
 * a&&b check boths eval iff both ae true
 * EQUALS 
 * ==
 * .EQUALS()
 * METHOID INHERITED FROM object
 * all reference types have it looking at content

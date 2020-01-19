package com.revature.loops;

import com.revature.bean.Person;

public class LoopyLoops {
	
	/*
	 * If Statement
	 * for decision making
	 * provides multiple paths of execution 
	 * 
	 * if(Conditional) {
	 * <what to do if true> 
	 * }
	 * else if(<Second cond.>){
	 * <what to do if the 2nd conditon is false> 
	 * }
	 * else{
	 * <what to do if false
	 * }
	 * 
	 */
	
	public static void oldCheck(int age) {
		if(age>60) {
			
			System.out.println("Hey, youre old");
			
			
		}
		else {
			System.out.println("Youre Cool!");
			
		}
	}
		
		/*
		 * Switch cases
		 * provides multiple paths of execution 
		 * 
		 */
		
		public static void whatColor(String color) {
			switch (color) {
			default: System.out.println("Not a color"); break;
			case "green": System.out.println("Grass"); break;
			case "Pink": System.out.println("Alia's Hair"); break;
			case "Yellow": System.out.println("Amanda's Blazer"); break;
			case "brown": System.out.println("Monster"); break;
			
			
			}
			
		}
		
		/*
		 * For Loops
		 * for(a;b;c) {do something}
		 * a is variable declaration (counter)
		 * b condition that controls how far the loop goes
		 * c is the incrementor/decrementor
		 * 
		 * 
		 */
		
		public static void forLoopFunness(int p) {
			for(int i=p; i>0 ; i--) {
				if(i==10) {
					//break;
					continue; //Skip that iteration
					
				}

				System.out.println(i);
				
			}

			
		}
		
		
		/*For Each Loop
		 * 
		 * 
		 * 
		 */
		
		
		static int [] myArray= {11,32,45,65,76,8,9};
		public static void forEachFun(int[] a) {
			for(int i:a) {
				System.out.println(i);
		}

		}
		
		
		/*
		 * while(<conditional){<do something>}
		 * 
		 * do while
		 * do{<do thing>} while (<condition>)
		 */

		public static void wileyWhile(int i) {
		while(i<10) {
			
			System.out.println("Man loops are so much fun");
			i++;
			
		}
		
		
		
		
	}

	public static void main(String[] args) {
		oldCheck(1237);
		oldCheck(59);
		whatColor("green");
		forLoopFunness(25);
		forEachFun(myArray);
		wileyWhile(3);
		
		
		Person p = new Person("Matt", 33, 260);
		Person q = new Person("Matt", 33, 260);
		System.out.println(p.equals(q));
		System.out.println(p==q);
		System.out.println(p==p);
		
	}

}

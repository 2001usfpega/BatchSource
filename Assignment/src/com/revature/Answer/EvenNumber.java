package com.revature.Answer;

public class EvenNumber {
	
	public static void isEven( int num) {
		boolean even=false;
		
		int div=num /2;
		int mul=div *2;
		if (mul==num) {
			even = true;
			System.out.println(" is a even number");
			
		}else { System.out.println("is not a even number");}
		
		
	}

}

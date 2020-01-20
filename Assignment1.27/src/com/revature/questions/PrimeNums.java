package com.revature.questions;

import java.util.ArrayList;
import java.util.List;

public class PrimeNums {
	
	public static boolean primeOrNot = false;

public static void addIntegers(ArrayList nums) {
	for(int i =1; i<101; i++) {
		Integer num = i;
		
		nums.add(num);
	}
}
	
	
	public static void findPrimes(ArrayList nums) {
		
		 
		for(int i=0; i<nums.size(); i++) {
			boolean isItPrime = true;
			Integer curNum = (Integer) nums.get(i);
			
			  
			if(curNum <=1) {
				
				isItPrime = false;
				
			}
				for(Integer l = 2; l<curNum-1 ; l++) {
					if(curNum%l==0) {
						
						isItPrime = false;
					
						
					}
					
				}
				
			
			
			
			if(isItPrime == true) {
				System.out.print(curNum + ", ");
			}
		}
	
		
	}

}

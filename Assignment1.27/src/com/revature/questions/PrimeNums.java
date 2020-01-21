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
	
	
	public static boolean findPrimes(int nums) {
		
		boolean isItPrime = true;
		
			
			Integer curNum = nums;
			
			  
			if(curNum <=1) {
				
				return false;
				
			}
				for(Integer l = 2; l<curNum-1 ; l++) {
					if(curNum%l==0) {
						
						return false;
					
						
					}
					
				}
				
			
			
			
	
		return isItPrime;
		
	}

}

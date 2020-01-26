package com.revature.Answer;

import java.util.Scanner;

public class Q4Solved {
	
	public long factorialN(long num) {
		
		long factorial=1;
		
		while(num>=1) {
			
			factorial = num * factorial;
			
			num=num-1;
			
					}
		
		return factorial;
		
	}
	

}

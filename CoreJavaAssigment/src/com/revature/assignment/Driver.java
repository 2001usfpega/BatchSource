package com.revature.assignment;

import com.revature.assignment.Methods;

public class Driver {

	public static void main(String[] args) {
		
		int myArray[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		Methods.Q1(myArray);
		
		for(int C=0; C < myArray.length; C++ )
		{
			System.out.print(myArray[C] + " ");
			
		}
		
		Methods.Q2();
		
		Methods.Q3();
		
		Methods.Q4();
		
		System.out.println(Methods.Q5("QUESTION 5", 5));
		
		Methods.Q10();


	}

}

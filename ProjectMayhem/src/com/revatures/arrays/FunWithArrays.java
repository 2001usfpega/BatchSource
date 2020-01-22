package com.revatures.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args)
	{

		//Give it a size 
		int [] myArray= new int[7];
 		//hardcode values
		int myOtherArray []= {2,5,6,7,7,8,8};
		//doesn't help me
		//System.out.println(myOtherArray.toString());
		//Arrays class!
		System.out.println(Arrays.toString(myOtherArray));
		
		for(int i=0; i<myOtherArray.length;i++)
		{
			
			myOtherArray[i]=myOtherArray[i]*7;
			
			
		}
		
		System.out.println(Arrays.toString(myOtherArray));
	
		
	

	
	for(int i:myOtherArray)
	{
		System.out.println(i);
		
		
	}
	
}
}

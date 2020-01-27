package com.revature.q11;
import static com.revature.q11_2.Package2.value1;
import static com.revature.q11_2.Package2.value2;

public class Package1 {
	public static void main (String[] args) {
			
	System.out.println("the values from the class in the other package are: value1 " + value1+ " value2 " +value2);
		}


	
}

//this code works by importing the values from another package which are 
//set to public. This makes it possible to pull the features from another 
//package.  Those values are set as floats in the second package.
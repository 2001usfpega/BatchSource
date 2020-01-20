package com.revature.questions;

public class Triangle {
	
static String[] zeroArr = {"0", "1", "0", "1"};

	static String triangle ="";
	
	public static void traingleMethod(String[] arr) {
		for(int i =0; i<arr.length; i ++) {
		 triangle +=arr[i];
		 System.out.println(triangle);
		}
	}
	
	
	
}

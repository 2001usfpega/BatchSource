package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		//Create a Gen1 reference for Integers....
		GenOne <Integer> i;
		i = new GenOne <Integer>(88);
		i.showType();
		//get value of i		
		int v =i.getOb();
		System.out.println("value:"+v);
		
		GenOne <String> s = new GenOne<String>("Generics Test!");
		s.showType();
		String str = s.getOb();
		System.out.println("value: "+str);
		
		
	}
	

}

package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a Gen1 references for Integers
		Gen1<Integer>i;
		i = new Gen1<Integer>(88);
		i.showType();
		
		int v=i.getOb();
		System.out.println("value: " + v) ;
		
		Gen1<String> s = new Gen1<String>("Generics Test");
		s.showType();
		String str = s.getOb();
		System.out.println("value: " + str);
	}

}

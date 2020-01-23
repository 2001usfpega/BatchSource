package com.aj.generics;

public class GenDemo {

	public static void main(String[] args) {
		//create a Gen1 reference for Integers
		Gen1<Integer> intGen;
		intGen = new Gen1<Integer>(88);
		
		intGen.showType();
		//get value of intGen
		int v = intGen.getOb();
		System.out.println(v);
		
		Gen1<String> s = new Gen1<String>("Sara Lance is badass.");
		s.showType();
		String st = s.getOb();
		System.out.println(st);
	}

}

package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
<<<<<<< HEAD
		//create a Gen1 refernce for integers
		Gen1<Integer> i;
		i = new Gen1<Integer>(88);
		i.showType();
		//get value of 1
		int v = i.getOb();
		System.out.println("value" + v);
		
		Gen1<String> s = new Gen1<String>("Generics Test");
		s.showType();
		String str = s.getOb();
		System.out.println("value" + str);
		
		
	}
=======
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
	
>>>>>>> 494dbe7d7201acd9f07197775f77d0032c64d4e3

}

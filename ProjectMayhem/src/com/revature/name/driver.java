package com.revature.name;

import com.revature.bean.Person; // Fully qualified Class Name

public class driver {

	public static void main(String [] args) {
		int a = 3;
		int b = 46;
		int c = a+b;
		System.out.println("I like to eat "+ c +" tacos");
	Person p = new Person();
	p.setName("Jim");
	System.out.println(p);
	Person q=new Person("BobPam", 81, 27);
	System.out.println(q);
}
	
	
}

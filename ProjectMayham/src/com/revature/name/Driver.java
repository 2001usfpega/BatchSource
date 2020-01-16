package com.revature.name;

import com.revature.bean.Person;

public class Driver {
	//Single line comment
	/*multiple-line
	 * comment
	 * classes and projects PascalCase
	 * methods and variables camelCase
	 * package - all.lower.case.period.spaced
	 * constants CAPS
	 * */
	public static void main (String [] args){
		int a = 3;
		int b = 46;
		int c = a+b;
		System.out.println(a+"+"+b+"="+c);
		Person p = new Person();
		System.out.println(p);
		Person q = new Person("Sally",25,167);
		System.out.println(q);
	}
}

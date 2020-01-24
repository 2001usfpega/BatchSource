package com.aj.IO;

import com.revature.bean.Person;

public class IOxDemo {
	public static void main(String[] saraLance) {
		IO io = new IO();
		// String strang = new String("strung");

		// io.writeOutputStreamContents(strang);
		// System.out.println(io.readInputStreamContents());
//		Person p1 = new Person("AJ", 30, 150);
//		Person p2 = new Person("Zen", 37, 190);
//		Person p3 = new Person("Matt", 30, 150);
//		Person p4 = new Person("Torres", 32, 150);
//
//		IOwithCollections.personList.add(p1);
//		IOwithCollections.personList.add(p2);
//		IOwithCollections.personList.add(p3);
//		IOwithCollections.personList.add(p4);
		
//		IOwithCollections.writeToFile();
		IOwithCollections.readFromFile();
		System.out.println(IOwithCollections.personList.toString());
	}
}

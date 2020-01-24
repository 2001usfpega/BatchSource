package com.revature.io;

import com.revature.bean.Person;

public class IODemo {

	public static void main(String[] args) {

		InputOutput io = new InputOutput();
		/*String a = "Roll Tide!";
		io.writeOutputStreamContents(a + " Lady Gaga");*/

		//read from a file
		/*System.out.println(io.readInputStreamContents());
		Person p1 = new Person("Matt", 33, 23456);
		Person p2 = new Person("AJ", 30, 100000);
		Person p3 = new Person("Torres", 32, 27);
		IOWithCollections.personList.add(p1);
		IOWithCollections.personList.add(p2);
		IOWithCollections.personList.add(p3);
		
		IOWithCollections.writePersonFile();
		*/
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
	}
}

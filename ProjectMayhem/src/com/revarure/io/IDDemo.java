package com.revarure.io;

import com.revarure.bean.Person;

public class IDDemo {

	public static void main(String[] args) {
		IO io = new IO();
		/*
		 * String a = "Roll Tide"; io.writeOutputStreamContent(a+" Lady Gaga");
		 * 
		 * System.out.println(io.readInputStreamContent());
		 */
//		
//		Person p1 =new Person("Matt",33,31354);
//		Person p2 =new Person("AJ",30, 1000);
//		Person p3 =new Person("Torres",32,27);
//		
//		IOWithCollections.personList.add(p1);
//		IOWithCollections.personList.add(p2);
//		IOWithCollections.personList.add(p3);
//		
//		IOWithCollections.writePersonFile();
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
	}

}

package com.revature.io;

import com.revature.bean.Person;

public class IODemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IO io= new IO();
//		String a = "Roll Tide";
//		io.writeOutputStreamContents(a + "Lady Gaga");	
		System.out.println(io.readInputStreamContents());
		
//		Person p1 = new Person("Matt",33,243);
//		Person p2 = new Person("AJ",33,243);
//		Person p3 = new Person("Zain",33,243);
//		Person p4 = new Person("Jane",33,243);
//		
//		IOWithCollections.personList.add(p1);
//		IOWithCollections.personList.add(p2);
//		IOWithCollections.personList.add(p3);
//		IOWithCollections.personList.add(p4);
//		
//		IOWithCollections.writePersonFile();
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
	}

}

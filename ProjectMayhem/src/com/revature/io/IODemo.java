package com.revature.io;

import com.revature.bean.Person;

public class IODemo {

	public static void main(String[] args) {
		IO io= new IO();
		//String a= "Roll Tide";
		//io.writeOutputStreamContents(a+" Lady Gaga");
		
		
		
		//Read from a file
//		System.out.println(io.readInputStreamContents());
//		Person p1 = new Person("Colby",24,168);
//		Person p2 = new Person("AJ",30,1000000);
//		Person p3 = new Person("Colby",32,27);
//		IOWithCollection.personList.add(p1);
//		IOWithCollection.personList.add(p2);
//		IOWithCollection.personList.add(p3);
//		
//		IOWithCollection.writePersonFile();
		IOWithCollection.readPersonFile();
		System.out.println(IOWithCollection.personList.toString());
		
	}

}

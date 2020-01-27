package com.revarure.classtypes;

import com.revarure.bean.Person;

public class Driver {

	public static void main(String[] args) {
		Shark shark = new Shark();
		
		shark.breathe();
		shark.findFrey();
		shark.swim();
		Person p =new Person();
		p.findFrey();
	}
}

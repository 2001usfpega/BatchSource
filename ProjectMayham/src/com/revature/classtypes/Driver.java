package com.revature.classtypes;

import com.revature.bean.Person;

public class Driver {

	public static void main(String[] args) {
		Shark ss= new Shark();
		ss.breathe();
		ss.findPrey();
		ss.swim();

		Person le = new Person();
		le.findPrey();
	}

}

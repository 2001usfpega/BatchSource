package com.revarture.classtypes;

import com.revarture.bean.Person;

public class Driver 
{

	public static void main(String[] args) 
	{
		Shark shark = new Shark();
		
		shark.breathe();
		shark.findPrey();
		shark.swim();
		
		Person p = new Person();
		p.findPrey();
	}

}

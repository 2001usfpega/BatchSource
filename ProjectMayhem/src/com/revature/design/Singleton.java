package com.revature.design;

public class Singleton {
/*
 * singleton design patter
 * ensure a class only has one instance and prives global access to it
 * 
 * We need a private staic instance of the class
 */
	
	private static Singleton instance;
	
	//private constructor
	private Singleton() {
		//logic here
	}
	
	//ensure that outside classes can't try and instantiate this.
	//we only want one instance of the class
	//public static synchronized method to get 
	// the unique instance
	//if it doesn not exist, we will create it
	
	public static synchronized Singleton getInstance() {
		if(instance ==null) {
			instance = new Singleton();
			
		}
		return instance;
	}
	
	public void doSomething() {
		// what the object should do
	}
}


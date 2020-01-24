package com.aj.design;

public class Singleton {
	/*
	 * Singleton Design Pattern
	 * ensures that a class only has one instance
	 * and provides "global" access to it
	 */
	
	private static Singleton instance;
	
	private Singleton() {};
	
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public void doSomething() {
		//what the object should do
	}
}

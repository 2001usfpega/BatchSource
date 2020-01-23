package com.aj.classTypes;

public interface Hunt {
	/* 
	 * Interfaces specify what a class MUST do, but not how it does it (abstraction!)
	 * Also a special type of class that cannot be instantiated
	 * lack instance variables
	 * can mimic multiple inheritance with interfaces
	 * Methods are declared without a body
	 * classes can implement multiple interfaces 0+ times
	 * interfaces can extend other interfaces 0+ times
	 * All variables are implicitly static, public, and final (java8)
	 */
	
	void findPrey();
}

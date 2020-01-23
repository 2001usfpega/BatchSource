package com.revature.classtypes;

public abstract class Animal {
	
	/*special class that can't be instantiated
	 * they contain at least 1 abstract method
	 * can contain concrete methods
	 * "Contract based" = abstract methods MUST be overriden in subclass
	 * "default structure"
	 */
	
	public abstract void breathe();
}


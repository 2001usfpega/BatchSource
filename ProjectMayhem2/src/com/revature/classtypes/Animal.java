package com.revature.classtypes;
/*
 * spceial calss that cant be instantiated
 * they contain at least 1 abstract method
 * can contain concrete methods
 * Contract based - abstract methods MUST be overridden in subclass
 */
public abstract class Animal {
	public abstract void breathe();
}

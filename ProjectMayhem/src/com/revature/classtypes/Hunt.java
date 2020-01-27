package com.revature.classtypes;
/*
 * specify what a class must do, but not how it does it (abstraction)
 * specify what a class must do, but not how it does it (sounds like abstraction!)
Special type of classes that cannot be instantiated.
Interfaces lack instance variables.
We can mimic multiple inheritance with interfaces, since they don’t have any implementation.
Methods are declared without a body.

 * */
public interface Hunt {
	void findPrey();
}

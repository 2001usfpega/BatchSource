package com.revature.poly;

public class Pitbull extends Mammal {
	static int sv; //gets default value
	public String str; // Instance variable, does get default
	
	  @Override public void eat() {
	  
	  System.out.println("I'm a pitbull who is EATING"); }
	  
	  public void eat1(){
		  
		  int a = 6; //does not get default value
		  super.eat();
		  System.out.println(a+sv);
		  //Block scope
		  if(a == 5) {
			  int d = 33; // again does not get default value
			  System.out.println("You guessed it, Go Knights! " + d);
			  
		  }
	  }
	 
	  //Block scope
	  {int a =67; //does not get default value
	  System.out.println(a);
	  }

}

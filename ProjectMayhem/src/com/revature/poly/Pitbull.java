package com.revature.poly;

public class Pitbull extends Mammal{
	 static int sv;//gets default value
	public String str;//does get default value
	  @Override public void eat() {
	  System.out.println("I am pitbull who is eating"); }
	  
	  public void eat1() {
		  int a=6;//does not get default value
		  super.eat();
		  System.out.println(a+sv);
		  //Block Scope
		  if(a==5) {
			  int d=33;//does not get default value
			  System.out.println("Roll Tide" + d);
		  }
	  }
	  //Block Scope
	  { int a=67;// does not get default value
	  System.out.println(a);
	  }
	
}

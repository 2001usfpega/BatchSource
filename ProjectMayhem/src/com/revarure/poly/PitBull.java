package com.revarure.poly;

public class PitBull extends Mammal{
	static int sv; // get default value
	public String str; //does get default value
	  @Override public void eat() {
	  System.out.println("I am a PitBull who is eating"); }
	  
	  public void eat1() {
		int a=6;
		super.eat();
		System.out.println(a+sv);	
		//Block scope
		if (a==5) {
			int d=33; //DOES NOT get default value
			System.out.println("Roll Tide "+d);
			}
	  }
	  
	  {//Block scope
		  int a = 67; //DOES NOT get default value
		  System.out.println(a);
	  }
	 
}

package com.revature.poly;

public class Pitbull extends Mammal{
	static int sv;//gets default value 
	public String str;//does not get default value 
	public void eat() {
		System.out.println("Im a pitbull who is eating ");}
		
		public void eat1() {
			int a=6;// does get a default value
			super.eat();
			System.out.println(a+sv);
			if (a==5) {
				int d=33; //does not get default value 
				System.out.println("Roll Tide" + d);
			}
		}
		//Block Scope
		{int a=67;//does not get default value
		System.out.println(a);
		}
	

}

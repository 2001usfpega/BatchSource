package com.revature.poly;

public class PitBull extends Mammal{
	static int sv;// gets default value
public String str;//does get default value

		@Override public void eat() {
		System.out.println("Im a Pit bull who is eatting!");}
	
		public void eat1() {
			int a = 6;// doesnt get default value
			super.eat();
			System.out.println(a+sv);
			
			//BLOCK SCOPE	
			if(a==5) {
				int d=33;// no default
				System.out.println("Roll Tide" + d);
				
			}
	
			
		}
		//block scope
		{int a = 67;// DOES NOT GET DEFUALT VALUE
		System.out.println(a);
		}
}

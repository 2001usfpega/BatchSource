package com.revature.poly;

public class Pitbull extends Mammal {
	
	static int sv; //Does get default value
	public String str; //Does get a value 
	
	public void eat( ) {
		
		System.out.println("I am pitbull who is eating");
		
		
		
		
	}
	
	public void eat1() {
		
		int a=5;//Does NOT get default value
		super.eat();
		System.out.println(a+sv);
		
		if(a==5)
		{
			int d=33; //Does NOT get Default Value
			System.out.println("Roll Tide " + d);
			
			
			
		}
		
		

		
	}
	
	{int a=67;
	System.out.println(a);
}


}

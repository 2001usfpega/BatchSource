package com.revature.pooly;

public class Pitbul extends Mammal {

 static int sv;//gets default value
 public String str;
    
   public void eat() {
	System.out.println("i ma a pitbul");	
	
}
   public void eat1() {
	   int a=5;//does no get default value
	   super.eat();
	   
	   System.out.println(a+sv);
	   //block Scope
	   if (a==5) {
		   int d=33;
		   System.out.println("you get  roll tide"+ d);
		
	}
   }
   //block Scope
   
   {int e=67;//does no get default value
   System.out.println(e);
   }
   }


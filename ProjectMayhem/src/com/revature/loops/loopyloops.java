package com.revature.loops;

import com.revature.bean.Person;

/*lopps
 * if statement
 * for decision making
 * provide multiple paths of execution
 * 
 * if(<conditional>){
 * <what to do is if is true>
 * 
 * }else if(<second condition  >){
 * what to do if the condition is true
 * }else {
 * what to do if is false
 * }--------------------
 * if we have to many if,else stament is better to use switch
 * */
public class loopyloops {
	

public static  void oldCheck(int age) {
	if(age>60) {
		System.out.println("hey , youre old");
		
	}else {
		System.out.println("your are cool");
		
	}
}
/*switch cases
 * provide multiple paths of execution bases on some value
 * the switch is based on a integer numeric, a String ,a char,a boolean,or enum
 * 
 * 
 * */

public static void whatcolor(String color) {
	switch (color) {
	case "green":
		System.out.println("grass");
		break;
	case "pink":
		System.out.println("alia's hair");
		break;
	case "yelow":
		System.out.println("Amanda's sweet Blazer");
		break;
	case "brown":
		System.out.println("a delicious monter");
		break;
	default:
		System.out.println("youre dumb");
		break;
	}
	}

	/*For loops
	 * for(a;b;c){do something}
	 * a is variable declaration(counter)
	 * b is the condition that controls how far the loop will go
	 * c is the incrementor / decrementor
	 * 
	 * 
	 * */
 public static void forLoopFunnes(int p) {
	 
	 for(int i=p;i>0;i--) {
		 if(i==10)
			// break;
			 continue;// skip the interation
		System.out.println(i); 
		 
	 }
	 
 }

/*Enhanced for loop aka for each
 * 
 * 
 * 
 * */
 
 static int [] myArray= {11,5,48,15,55};
  public static void forEachFun(int[] a) {
	  
	  for(int i:a) {
		  System.out.println(i);
		  
	  }
	  
	  
  }
 /*while loops
  * while
  * 
  * do while
  * do{do thing}while(<condition>)
  * it run one al list
  * */
 public static void wileyWhile(int i) {
	 while(i<10) {
		 System.out.println("man, loops are si fun");
		i++; 
	 }
	 
	 
 }
  public static void doWhile(int i) {
	do {
		System.out.println("do the thing");
	}
	while(i<10);
	i++;
}
 
public static void main(String[] args) {
	
	//oldCheck(4884);
	
	//oldCheck(4);
	//whatcolor("green");
	forLoopFunnes(25);
	//forEachFun(myArray);
	//wileyWhile(15);
	//doWhile(30);
	
	
	Person p=new Person("matt",33,260);
	Person q=new Person("matt",33,260);
	System.out.println(p==q);
	System.out.println(p.equals(q));
}
}








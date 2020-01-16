package com.revature.loopz;

import com.revature.bean.Person;

public class LoopyLoops {
	public static void whatColor(String color) {
		switch(color) {
		case "green":
		case "Green":
			System.out.println("money");
		}
	}
	public static void oldCheck(int age) {
		if(age>60) {
			System.out.println("hey youre old");
		}
		else {
			System.out.println("youre cool");
		}
	}
	public static void forLoopFun(int p) {
		for(int i=p; i>0; i--) {
			if(i==10) break;
			System.out.println(i);
			
		}
	}
	public static void forEachFun(int [] a){
		for(int i:a) {
			System.out.println(i);
			i++;
		}
	}
	public static void whiley(int i) {
		while(i-->0) {
			System.out.println("loop"+i);
		}
		
	}
	public static void doWhiley(int i) {
		do {
			System.out.println("do");
		}while(i++<5);
	}
	static int [] myA= {2,3,4,6,8,2,11,03};
	public static void main(String[] args) {
//		oldCheck(1237);
//		oldCheck(59);
//		whatColor("green");
//		whatColor("Green");
//		forLoopFun(15);
		
//		forEachFun(myA);
//		forEachFun(myA);
//		int x = 1>2 ? 1 : 2;
//		System.out.println(x);
		
		//whiley(5);
		//doWhiley(4);
		
		Person p = new Person("mat",33,200);
		Person q = new Person("mat",33,200);
		System.out.println(p==q);
		System.out.println(p.equals(q));
		p=q;
		System.out.println(p==q);
	}
}

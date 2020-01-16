package com.revature.overload;

public class OverloadDemo {
	public static void main(String[] args) {
		long b = 4;
		Long e = new Long(6);
		int c = 5;
		foo(b);
		foo(c);
		foo(e);
		foo(b, c, e);
	}
	static void foo(long a){
		System.out.println("Foo i got my long!");
		System.out.println(a);
	}
	static void foo(long ... array){
		System.out.println("Foo, i got my longs!");
		for(long a: array) {
			System.out.println(a);
		}
	}
}

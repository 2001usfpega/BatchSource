package com.revature.gerneric;

public class Gen1<T> {

	T ob;
	
	Gen1(T o){
		ob=o;
	}
	
	T getOb() {
		return ob;
	}
	
	void showType() {
		System.out.println("ob is type "+ob.getClass());
	}
	
}

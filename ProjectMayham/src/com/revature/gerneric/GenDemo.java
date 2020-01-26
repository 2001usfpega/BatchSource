package com.revature.gerneric;

public class GenDemo {

	public static void main(String[] args) {
		
		Gen1<Integer> i;
		i =new Gen1<>(88);
		i.showType();
		int v=i.getOb();
		System.out.println("value: "+v);
		
		Gen1<String> g=new Gen1<>("gent est");
		g.showType();
		System.out.println("value: "+g.getOb());

		
	}

}

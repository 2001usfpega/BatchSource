package com.revature.brain;

public class overload {
	static int z=55;
	static int x=16;
	static Double d=24.33;

	public static void main(String [] args) {
		jeff(x,z);//exact
		jeff(x,d);//conversion  unboxxing
		jeff(z,x,d.intValue());//varargs
		//String g;
		//System.out.println(g);
		
		Integer i= 0;
		System.out.println(i);
		System.out.println(success(true));
		
		
		
	}
	
	public static void jeff(int a, int b) {
		System.out.println(a+b);
	}
	public static void jeff(double a, double b) {
		System.out.println(a+b);
	}
	public static void jeff(int ... a){
		for(int i:a) {
			System.out.print(i);
		}
	}
	public static String success(boolean b) {
		return "hello";
	}

}

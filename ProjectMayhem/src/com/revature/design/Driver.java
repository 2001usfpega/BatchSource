package com.revature.design;

public class Driver {
	private static HondaFactory hf= new HondaFactory();
	public static void main(String[] args) {
		Car c1=hf.getCar("crv", "matte grey");
		Car c2=hf.getCar("civic", "green");
		Car c3=hf.getCar("potato", "clear");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);


	}

}

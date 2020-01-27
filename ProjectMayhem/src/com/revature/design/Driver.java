package com.revature.design;

public class Driver {
	private static HondaFactory hf = new HondaFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car c1 = hf.getCare("crv", "matte - grey");
		Car c2 = hf.getCare("civic", "red");
		Car c3 = hf.getCare("ferrari", "blue");

		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}

}

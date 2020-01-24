package com.aj.design;

public class Driver {
	private static HondaFactory hf = new HondaFactory();

	public static void main(String[] saraLance) {
		Car c1 = hf.getCar("crv", "blue");
		Car c2 = hf.getCar("civic", "red");
		Car c3 = hf.getCar("potato", "clear");

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}

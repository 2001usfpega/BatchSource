package com.aj.design;
// factories create objects without exposing the creation logic to the client

public class HondaFactory {
	/*
	 * uses a "factory" method to return a Car model based on what String is given
	 * if the method is given a parameter of something besides CRV or Civic, it will
	 * return null
	 */
	public Car getCar(String whatCar, String color) {
		if ("civic".equals(whatCar)) {
			return new Car("Honda", 2020, "civic", color);

		} else if ("crv".equals(whatCar)) {
			return new Car("Honda", 2020, "crv", color);
		}
		return null;
	}
}

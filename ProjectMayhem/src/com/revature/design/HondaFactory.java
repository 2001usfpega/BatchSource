package com.revature.design;
//Factories create objects w/o
//exposing creation logic to the client
public class HondaFactory {
	
	/*
	 * use a factory method to return a car model based on 
	 * what string is given
	 * if the method is given a parameter of something besides crv
	 * or civic
	 * it will return null
	 * 
	 */

	public Car getCare(String whatCar, String color) {
		if("civic".equals(whatCar)) {
			return new Car("Honda", 2020, "civic", color);
				
			}else if("crv".equals(whatCar)) {
				return new Car("Honda", 2020, "crv", color);
			}return null;
		}
	}


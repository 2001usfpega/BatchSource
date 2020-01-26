package com.revature.design;
//Factories create objects w/o exposing creation logic to the client
public class HondaFactory {
	/*
	 * us a factory method to return a Car Model based on what String is given
	 * if the method is given a parameter of something besides crv or civic, it
	 * 
	 */
	public Car getCar(String whatCar, String color) {
		if("civic".equals(whatCar)) {
			return new Car("Honda",2020,"Civic",color);
		}else if("crv".equals(whatCar)) {
			return new Car("Honda",2020,"CRV",color);
		}
		return null;
	}
	
}

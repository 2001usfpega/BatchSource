package com.revature.design;

public class HondaFactory {
	
	public static getCar(String whatCar, String color) {
		
		if("civic".equals(whatCar))
		{
			
			return new Car("Honda", 2020, "Civic", color);
			
			
		}else if("crv".equals(whatCar)) {
			
			
			
			
			
		}
		
		
	}

}

package com.revature.design;

public class HondaFactory 
{
	public Car getCar(String whatCar, String color) 
	{
		if ("civic".equals(whatCar)) 
		{
			return new Car("Honda" ,2020, "Civc", color);
		}
		else if("crv".equals(whatCar)) 
		{
			return new Car ("Honda" , 2020, "CRV", color);
			
		}
		return null;
	}
	
}

package com.revature.design;

public class HondaFactory {
	
	public Car getCar(String what,String col) {
		
		if(what.equals("civic")) {
			return new Car("honda",2020,"Civic",col);
		}
		return null;
	}

}

package com.revature.design;

public class Car {
	private String make;
	private int year;
	private String model;
	private String color;
	
	public Car(String make, int year, String model, String color) {
		this.make = make;
		this.year = year;
		this.model = model;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", year=" + year + ", model=" + model + ", color=" + color + "]";
	}
	
}

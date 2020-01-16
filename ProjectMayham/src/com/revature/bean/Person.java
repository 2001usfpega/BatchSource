package com.revature.bean;

public class Person {
	/*
	 *beans represent entities
	 *more data structure than logic
	 *made of
	 *private fields
	 *default constructor
	 *field constructors
	 * getters and setters
	 * toString()
	 * equals()
	 */
	private String name; 
	private int age;
	private int weight;
	
	public Person() {
		name = "John Doe";
		age = 30;
		weight = 180;
	}

	public Person(String name, int age, int weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	{System.out.println("This is an instance block");}
	static {System.out.println("This is a static block");}
	public String getName(){
		return name;
		}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
}

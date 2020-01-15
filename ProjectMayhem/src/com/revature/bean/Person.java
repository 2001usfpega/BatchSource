package com.revature.bean;

public class Person {
/* Code block - defined by {} things between
 *static code block - belongs to the class, runs once when class is used by complier
 *instance code block -  run every time an object is instantiated (for that class)
 * 
 * 
 */
	//Static code block
	static {System.out.println("I'm in a static code block");}
	//Instance code block
	{System.out.println("I'm in an instance code block");}
	private String name;

	private int age;
	
	private int weight; 
	//No Args Constructor
	public Person() {
		//super(); implicitly there
	}
	
	//Construcotr w/fields
	public Person (String name, int age, int weight) {
		//this. is referring to the object
		//-name is referring to the parameter 
		System.out.println("Inside Person constructor");
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setWeight() {
		this.weight=weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}


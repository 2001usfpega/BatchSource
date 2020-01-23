package com.revarure.bean;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreaseByNegativeNumberException;

public class Person implements Hunt {
	/*Code Block - define by {}.
	 * 	static code block - belong to class. Run once when class is used by compiler.
	 *  instance code block - belongs to object. Run every time and object is instantiated (for that class)
	 * 
	 * Java Bean. 
	 * Represent some entity. 
	 * More for data structure than logic. 
	 * Made up of: private fields. 
	 * Default constructor. 
	 * Constructor with fields. 
	 * Getters and Setters. toString(). method equals()
	 */
	
	//Static code block
	static {
		System.out.println("I'm in a static code block");
	}
	
	{
		System.out.println("I'm in an instance code block");
	}
	
	private String name;
	private int age;
	private int weight;

	// No args constructor
	public Person() {
		// TODO Auto-generated constructor stub
		// super(); implicitly there
	}

	// Constructors with fields
	public Person(String name, int age, int weight) {
		// "this." refers to the object.
		// =name is refer to the parameter.
		System.out.println("Inside Person Constructor");
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return this.weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override //compare two objects to avoid reference issue
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	public void increaseAgeBy(int x) {
		if(x<0) {
			throw new IncreaseByNegativeNumberException();
		}		
		this.age+=x;
	}

	@Override
	public void findPrey() {
		System.out.println("I go to McDonald's, meeegh");
		
	}
}

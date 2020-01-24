package com.revature.bean;

import com.revature.classtypes.Hunt;

public class Person implements Hunt{
/*Code Block- defined by {}  {Things between}
 * static code block - runs once when class is used by compiler
 * instance code block-  run every time an object is instantiated (for that class)
 * 
 * Java Bean
 * Represents some entity
 * More for data structure than logic
 * Made up of:
 * 				private fields
 * 				No-Arg Constructor
 * 				Constructor w/ fields
 * 				Getters and Setters
 * 				toString()
 * 				equals()
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
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	//Example of Shadowing
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	//Constructor w/ fields
		public Person(String name, int age, int weight) {
			//this. is referring to the object
			//=name is referring to the parameter
			System.out.println("Inside Person Constructor");
			this.name=name;
			this.age=age;
			this.weight=weight;
		}
		
		
		public void increaseAgeBy(int x) {
			if (x<0) {
				
			}
			
			
		}

		@Override
		public void findPrey() {
			// TODO Auto-generated method stub
			
		}
	
}

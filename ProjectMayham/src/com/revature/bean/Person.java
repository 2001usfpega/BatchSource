package com.revature.bean;

public class Person {
/*
 * java bean / POJO
 * repersents some entity
 * more for structure than logic
 * made of:
 * 		private fields
 * 		default constructor
 * 		constructor w/ fields
 * 		getters and setters
 * 		to String()
 * 		equals()
 */
	
	
	//static code block
	static {System.out.println("im in a static code block");}
	//instance code block
	{System.out.println("im in an instance code block");}
	
	
	private String name;
	private int age;
	private int weight;
	
	//no args constructor
	public Person(){
		
	}
	public Person(String name, int age, int weight){
		//this. refers to object
		System.out.println("inside person constructor");
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	
	//name
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	//age
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	//weight
	public void setWeight(int weight) {
		this.weight=weight;
	}
	public int getWeight() {
		return weight;
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
	
	
}



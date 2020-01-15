package com.revarture.bean;

public class Person 
{
	/*Code Block defines by {}
	 * static code blocks- run once when the class is compiler
	 * 
	 * instance code blocks- run every time an obj is instantiated for the class
	 * 
	 * 
	 * Java Bean POJO
	 * Represents some entity
	 * More for data structure than logic
	 * Made up of:
	 * 	Private fields
	 * 	Default Constructor
	 * 	Constructor w/ fields
	 * 	Getters and Setters
	 * 	toString()
	 * 	equals()
	 * 
	 * 
	 * 
	 * */
	
	//Static code block
	static {System.out.println("Im in a static code block");}
	//Instance code block
	{System.out.println("Im in a instance code block");}
	private String name;
	private int age;
	private int weight;
	
	//No args constructor
	public Person() 
	{
		//super() ; implicitly there
	}
	//Constructor w/ field
	public Person(String name, int age , int weight) 
	{
		//this. is referring to the object
		//=name is the parameter
		System.out.println("Inside Person Constructor");
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	
	public void setName(String name) 
	{
		this.name=name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setAge(int age) 
	{
		this.age=age;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setWeight(int weight) 
	{
		this.weight=weight;
	}
	
	public int getWeight() 
	{
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

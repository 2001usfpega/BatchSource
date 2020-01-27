package com.revature.bean;

import java.io.Serializable;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Hunt, Serializable {
<<<<<<< HEAD
	
	/*Code Block: Defined by {} {things}
	 * static code block: runs once when class is used by compiler
	 * instance code block: run every time an object is instantiated(for that class)
	 * 
	 * Java Bean
	 * Represents some entity
	 * More for a data structure rather than logic
	 * Made up of:
	 * 			Private fields
	 * 			No-Arg constructor
	 * 			Constructor with fields
	 * 			Getters and Setters
	 * 			toString()
	 * 			equals()
	 */
	
	//Static code block
	static{
		System.out.println("I'm in a static code block");
	}
	
	//Instance code block
	{System.out.println("I'm in an instance codeblock");}
=======
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
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
	private String name;
	private int age;
	private int weight;
	
<<<<<<< HEAD
	// No-Args constructor
=======
	//No Args Constructor
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
	public Person() {
		//super(); implicitly there
	}
	
<<<<<<< HEAD
	//Constructor with fields
	
	public Person(String name, int age, int weight) {
		//this. is referring to the object
		// =name is referring to the parameter
		System.out.println("We are inside person constructor");
		this.name = name;
		this.age = age;
		this.weight = weight;

		
	}

    public void increaseAgeBy(int x) {
        this.age +=x;
        if(x<0) {
            throw new IncreasedByNegativeNumberException();
        }
        
    }
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setAge(int age) {
		this.age =age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
		
	}
	
	public int getWeight() {
		return weight;
	}

=======
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
<<<<<<< HEAD

=======
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}
<<<<<<< HEAD

=======
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8
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
<<<<<<< HEAD
	
}

=======
	//Constructor w/ fields
		public Person(String name, int age, int weight) {
			//this. is referring to the object
			//=name is referring to the parameter
			System.out.println("Inside Person Constructor");
			this.name=name;
			this.age=age;
			this.weight=weight;
		}

        @Override
        public void findPrey() {
            System.out.println("I like turtles");
            
        }
	
}
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8

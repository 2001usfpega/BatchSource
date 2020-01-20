package com.revature.assignment;

import java.util.Comparator;

public class Question7 {
	
	String name;
	int age;
	String department;
	
	public Question7(String name, int age, String department)
	{
		this.name = name;
		this.age = age;
		this.department= department;
		
	}
	
	public String toString()
	{
		return "Name: " + name + ", Age: " + age + ", Department: " + department;
		
		
	}
}
	
class NameSort implements Comparator<Question7>
	{
		
		public int compare(Question7 first, Question7 second) 
		{
			return first.name.compareTo(second.name);
			
			
		
		}

	}

class AgeSort implements Comparator<Question7>
{
	
	public int compare(Question7 first, Question7 second) 
	{
		return first.age-second.age;
		
		
	
	}
	
}


class DepartmentSort implements Comparator<Question7>
{
	
	public int compare(Question7 first, Question7 second) 
	{
		return first.department.compareTo(first.department);
		
		
	
	}
}


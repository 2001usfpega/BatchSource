//reference https://www.geeksforgeeks.org/comparator-interface-java/
package com.revature.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Q7 
{
	int rollmaybe;
	String name, department, age;
	
	public Q7(int rollmaybe, String name, String department, String age) 
	{
		this.rollmaybe = rollmaybe;
		this.name = name;
		this.department = department;
		this.age = age;
	}
	//loads string to be read later
	public String toString() 
	{
		return this.rollmaybe + " " + this.name + " " + this.department + " " + this.age;
	}
}
//compares rollmaybe
class Sortbyrollmaybe implements Comparator<Q7>
{
	public int compare(Q7 a, Q7 b) 
	{
		return a.rollmaybe - b.rollmaybe;
	}
}
//compares name
class Sortbyname implements Comparator<Q7>
{
	public int compare (Q7 a, Q7 b) 
	{
		return a.name.compareTo(b.name);
	}
}
//compares department
class Sortbydepartment implements Comparator<Q7>
{
	public int compare (Q7 a, Q7 b) 
	{
		return a.name.compareTo(b.department);
	}
}
//compares age
class Sortbyage implements Comparator<Q7>
{
	public int compare (Q7 a, Q7 b) 
	{
		return a.name.compareTo(b.age);
	}
}

class Driver
{
	public static void main(String[] args) 
	{
		ArrayList<Q7> bruh = new ArrayList<Q7>();
		//adds info individually
		bruh.add(new Q7(111, "xxxx", "Tokyo", "26"));
		bruh.add(new Q7(222, "yyyy", "Maimi", "69"));
		bruh.add(new Q7(333, "zzzz", "Italy", "46"));
		//run array unorganized
		System.out.println("Unorganized");
		for(int d=0; d<bruh.size(); d++) 
		{
			System.out.println(bruh.get(d));
		}
		//sorts by rollmaybe
		Collections.sort(bruh, new Sortbyrollmaybe());
		
		System.out.println("\nSorted by rollmaybe");
		for(int d=0; d<bruh.size(); d++) 
		{
			System.out.println(bruh.get(d));
		}
		//sorts by name
		Collections.sort(bruh, new Sortbyname());
		
		System.out.println("\nSorted by name");
		for(int d=0; d<bruh.size(); d++) 
		{
			System.out.println(bruh.get(d));
		}
		//sorts for department
		Collections.sort(bruh, new Sortbydepartment());
		
		System.out.println("\nSorted by department");
		for(int d=0; d<bruh.size(); d++) 
		{
			System.out.println(bruh.get(d));
		}
		//sorts for age
		Collections.sort(bruh, new Sortbyage());
		
		System.out.println("\nSorted by age");
		for(int d=0; d<bruh.size(); d++) 
		{
			System.out.println(bruh.get(d));
		}

	}
}


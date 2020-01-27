package com.revature.coreassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Employee {

	private int id = -1;
    private String firstName = null;
    private String lastName = null;
    private int age = -1;
 
    public Employee(int id, String fName, String lName, int age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }
 
    // Setters and Getters
 
    @Override
    public String toString() {
        return "Employee : " + id + " - " + firstName + " - " + lastName
        + " - " + age + "n";
    }
public static class Xmen{
	public Xmen(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public static void main (String [] professorX) {
		Xmen x1 = new Xmen(1, "Scott", "Summers");
		Xmen x2 = new Xmen(2, "James", "Howlett");
		
		
		List<Xmen> best = new ArrayList<Xmen>();
		best.add(x1);
		best.add(x2);
		
		System.out.println(best);
		
		Collections.sort(best, new );
		
		
	}

}
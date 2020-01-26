package com.revature.core;
import java.util.ArrayList;
import java.util.Collections;

public class Question7 {
	public String question7() {
		System.out.println("Welcome to question 7!");
		employee e1 = new employee(53,"Kyle", "Research");
		employee e2 = new employee(34,"Howard", "Marketing");
		ArrayList<employee> emps = new ArrayList<employee>();
		emps.add(e1);
		emps.add(e2);
		
		System.out.println("Unsorted");
		for(int i = 0; i < emps.size(); i ++) {
			System.out.println(emps.get(i));
		}
		System.out.println("Sorted By Age");
		Collections.sort(emps,new SortByAge());
		for(int i = 0; i < emps.size(); i ++) {
			System.out.println(emps.get(i));
		}
		System.out.println("Sorted By Name");
		Collections.sort(emps,new NameSort());
		for(int i = 0; i < emps.size(); i ++) {
			System.out.println(emps.get(i));		
		}
		System.out.println("Sorted By Department");
		Collections.sort(emps,new SortByDepartment());
		for(int i = 0; i < emps.size(); i ++) {
			System.out.println(emps.get(i));

		}
		return "Done";
	}
}


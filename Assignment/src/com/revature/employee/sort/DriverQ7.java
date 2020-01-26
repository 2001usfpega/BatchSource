package com.revature.employee.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverQ7 {

	public static void main(String[] args) {
		
	
		ArrayList<Employee> empl=new ArrayList<>();
		empl.add(new Employee("Maria", 2, 25));
		empl.add(new Employee("Fatima", 4, 20));
		empl.add(new Employee("Teresa", 1, 30));
		empl.add(new Employee("Sidiki", 6, 35));
		
		System.out.println("unsorted");
		for (int i = 0; i < empl.size(); i++) {
			System.out.println(empl.get(i).getName()+" department is "+ +empl.get(i).getDept()+" and Age is "+empl.get(i).getAge());
			
		}
		
	Collections.sort(empl, new SortByAge() );
	System.out.println("sorted by age");
	for (int i = 0; i < empl.size(); i++) {
		System.out.println(empl.get(i).getAge());
		
	}
	
	Collections.sort(empl, new SortByDept() );
	System.out.println("sorted by department");
	for (int i = 0; i < empl.size(); i++) {
		System.out.println(empl.get(i).getDept());
		
	}
	
	Collections.sort(empl, new SortbyName() );
	System.out.println("sorted by name");
	for (int i = 0; i < empl.size(); i++) {
		System.out.println(empl.get(i).getName());
		
	}
	}

}

package com.aj.corejava;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int age1 = Integer.parseInt(o1.getAge());
		int age2 = Integer.parseInt(o2.getAge());
		
		return age1 - age2;
		
		
	}

}

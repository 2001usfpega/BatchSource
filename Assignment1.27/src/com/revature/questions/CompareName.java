package com.revature.questions;

import java.util.Comparator;

public class CompareName implements Comparator<Employee> {

	
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.name.compareTo(employee2.name);
	}
}

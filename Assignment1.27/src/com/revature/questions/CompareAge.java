package com.revature.questions;

import java.util.Comparator;

public class CompareAge implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getAge() - employee2.getAge();
	}
}

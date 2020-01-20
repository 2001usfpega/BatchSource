package com.revature.questions;

import java.util.Comparator;

public class CompareDept implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getDepartment() - employee2.getDepartment();
	}
}

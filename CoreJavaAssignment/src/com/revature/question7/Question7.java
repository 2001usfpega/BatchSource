package com.revature.question7;

import java.util.Comparator;

public class Question7 implements Comparator<Employee> {

	/**
	 * Sorts two employees based on their name, department, and age using the
	 * Comparator interface.
	 */
	@Override
	public int compare(Employee emp0, Employee emp1) {
			int result = emp0.getName().compareTo(emp1.getName());
			if(result == 0) {
				result = emp0.getDepartment().compareTo(emp1.getDepartment());
				if(result == 0) {
					result = Integer.compare(emp0.getAge(), emp1.getAge());
				}
			}
		return result;
	}

}

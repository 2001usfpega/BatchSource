package com.revature.question7;

import java.util.Comparator;

public class Question7 implements Comparator {

	/**
	 * Sorts two employees based on their name, department, and age using the
	 * Comparator interface.
	 */
	@Override
	public int compare(Object arg0, Object arg1) {
		int result = Integer.MIN_VALUE;
		if(arg0 instanceof Employee && arg1 instanceof Employee) {
			Employee emp0 = (Employee) arg0;
			Employee emp1 = (Employee) arg1;
			result = emp0.getName().compareTo(emp1.getName());
			if(result == 0) {
				result = emp0.getDepartment().compareTo(emp1.getDepartment());
				if(result == 0) {
					result = Integer.compare(emp0.getAge(), emp1.getAge());
				}
			}
		}
		return result;
	}

}

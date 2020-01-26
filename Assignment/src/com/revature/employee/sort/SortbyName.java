package com.revature.employee.sort;

import java.util.Comparator;

public class SortbyName implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		
		return e1.getName().compareTo(e2.getName());
	}

}

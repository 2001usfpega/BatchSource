package com.revature.core;

import java.util.Comparator;

public class SortByDepartment implements Comparator<employee>{

	@Override
	public int compare(employee a, employee b) {
		// TODO Auto-generated method stub
		return a.department.compareTo(b.department);
	}

}

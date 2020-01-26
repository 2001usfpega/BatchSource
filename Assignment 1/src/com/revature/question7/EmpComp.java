package com.revature.question7;

import java.util.Comparator;

public class EmpComp implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int res = o1.getName().compareTo(o2.getName()); //compare name of of emp o1 to emp o2
		if(res ==0) {
			res = o1.getDepartment().compareTo(o2.getDepartment()); //compare dept of emp o1 to emp o2
			if (res == 0) {
				res = Integer.compare(o1.getAge(), o2.getAge()); // compare age of emp o1 to emp o2
		}
			
		}
		return res;
	}

}

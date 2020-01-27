package com.evanna.johnson;

import java.util.Comparator;

class EmployeeComparatorName implements Comparator<Employee> {

	public int compare(Employee employee1, Employee employee2) {
		return employee1.name.compareTo(employee2.name);
	}

}

class EmployeeComparatorAge implements Comparator<Employee> {

	public int compare(Employee employee1, Employee employee2) {
		return employee1.age - employee2.age;
	}

}

class EmployeeComparatorDept implements Comparator<Employee> {

	public int compare(Employee employee1, Employee employee2) {
		return employee1.department.compareTo(employee2.getDepartment());
	}
}
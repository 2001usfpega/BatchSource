package com.revature.problem11;

import com.revature.employee.Employee;

public class Admin{

	public void accessingFloat() {
		Employee employee = new Employee("le", 1233, 32);
		employee.setWorkExp(1.5f);
		employee.setEvaluation(4.5f);
		
		System.out.println("Employee " + employee.getEmName()+" has " +employee.getWorkExp()+ " year of working experience"+
				" and his evaluation is "+employee.evaluation);
	}
}

package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.employee.Employee;

class KProblemEleven {

	@Test
	void test() {
		Employee employee = new Employee("Le", 1111, 32);
		employee.setEvaluation(4.7f);
		employee.setWorkExp(3.0f);
		assertEquals(4.7f, employee.getEvaluation());
		assertEquals(3.0f, employee.getWorkExp());
	}

}

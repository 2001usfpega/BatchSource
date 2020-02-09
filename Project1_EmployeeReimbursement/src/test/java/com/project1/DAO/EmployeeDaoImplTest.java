package com.project1.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeDaoImplTest {

	@Test
	void testReadEmployee() {
		EmployeeDaoImpl db = new EmployeeDaoImpl();
		db.readEmployee("employee", "password");
	}

}

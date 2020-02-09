package com.project1.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReimburseDAOImplTest {
	
	ReimburseDAOImpl db = new ReimburseDAOImpl();

	@Test
	void testEmployeeRecords() {
		db.employeeRecords(1);
	}

	@Test
	void testReadRecords() {
		db.readRecords();
	}

	@Test
	void testNewRecord() {
		db.newRecord(1, 4, 100.34, "Test");
	}

	@Test
	void testUpdateRecord() {
		db.updateRecord("Approved", 1);
	}

}

package com.gonuts.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gonuts.dao.ReqService;
import com.gonuts.model.Employee;

class Testing {
	public static ReqService service=new ReqService();

	@Test
	void testLogin() {
		Employee bob=service.login("tod", "123");
		assertEquals("Emert", bob.getLastName());
	}

}

package com.proyect1.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.proyect1.model.Employee;
import com.proyect1.service.impl.RequestServiceImpl;

class GetEmpTest {

	@Test
	void test() {
		RequestServiceImpl serv=new RequestServiceImpl();
		Employee emp=serv.getEmployee("skade");
		
		String out="Sidiki";
		assertEquals(out, emp.getFirstname());
		
	}

}

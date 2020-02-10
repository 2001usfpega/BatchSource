package com.proyect1.junittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.proyect1.model.Ticket;
import com.proyect1.service.impl.RequestServiceImpl;

class PendingListTest {

	@Test
	void test() {
		RequestServiceImpl serv=new RequestServiceImpl();
		List<Ticket> tic= serv.getAllRequest();
 
		assertEquals(tic.get(1).getTicket_amount(), serv.getAllRequest().get(1).getTicket_amount());
		
		
		
	}

}

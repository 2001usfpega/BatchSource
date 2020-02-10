package com.ers.app;

import java.sql.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.ers.model.ExpenseTicket;
import com.ers.service.EmployeeService;
import com.ers.service.EmployeeServiceImpl;
import com.ers.service.ExpenseTicketService;
import com.ers.service.ExpenseTicketServiceImpl;

public class Driver {
	
	private static EmployeeService es = new EmployeeServiceImpl();
	
	private static ExpenseTicketService ets = new ExpenseTicketServiceImpl();
	
	final static Logger LOGGER = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		LOGGER.setLevel(Level.ALL);
		
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("This is info: loggers are cool, right? Sugoi!");
		}
		
		LOGGER.warn("This is a warning: it comes for me at dawn......");
		LOGGER.error("This is an error: pineapples don't go on pizza....", new IndexOutOfBoundsException());
		LOGGER.fatal("This is fatal....like the DragonBallZ live action movie....");
		LOGGER.info("--------");
	}
}

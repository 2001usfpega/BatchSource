package com.revature.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ExpenseLogger {
	
	static final Logger LOGGER = Logger.getLogger(ExpenseLogger.class);
	
	public static void main(String [] args) {
		BasicConfigurator.configure();
		LOGGER.debug("Hello World!");
	}
	
	

}

package com.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/*
 * LOGGING LEVELS INCLUDE
 * 
 * (lowest priority)						(higher priority)
 * All < debug < info < warn < error < fatal < off
 * 
 */
public class MainDriver {

	final static Logger LOGGY_THE_LOG = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		LOGGY_THE_LOG.setLevel(Level.ERROR);
		//LOGGY_THE_LOG.setLevel(Level.ALL);
		
		if( LOGGY_THE_LOG.isInfoEnabled()) {
			LOGGY_THE_LOG.info("This is info: loggers are cool, right? Sugoi!");
		}
		
		LOGGY_THE_LOG.warn("This is a warning: it comes for me at dawn.....");
		LOGGY_THE_LOG.error("This is an error: pineapples don't go on pizza.....",
				new IndexOutOfBoundsException());
		LOGGY_THE_LOG.fatal("This is fatal....like the DragonBallZ live action movie....");
		LOGGY_THE_LOG.info("---------");

	}

}

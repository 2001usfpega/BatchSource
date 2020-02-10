package com.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class testmain {
	
final static Logger LOGGY = Logger.getLogger(testmain.class);

	public static void main2(String[] args) {
		LOGGY.setLevel(Level.ALL);
		
		if (LOGGY.isInfoEnabled()) {
			LOGGY.info("logggggggggg");
		}
		
		LOGGY.warn("warning");
		LOGGY.error("error",new IndexOutOfBoundsException());
		
		LOGGY.fatal("fatal");
		LOGGY.info("info---------");

		
	}

}

package com.project1.main;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerExample {
	final static Logger loggyTheLog= Logger.getLogger(LoggerExample.class);

	public static void main(String []args) {
		loggyTheLog.setLevel(Level.ALL);
		if(loggyTheLog.isInfoEnabled()) {
			loggyTheLog.info("This Info: loggers are cool?");
		}
		loggyTheLog.warn("This is a warning");
		loggyTheLog.error("This is an error",
				new IndexOutOfBoundsException());
		loggyTheLog.fatal("This is a fatal");
		loggyTheLog.info("----");
	}
	
}

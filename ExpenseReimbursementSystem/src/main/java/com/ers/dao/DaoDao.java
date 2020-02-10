package com.ers.dao;

import org.apache.log4j.Logger;

import com.ers.app.Driver;

public interface DaoDao {
	public static final String url = System.getenv("TRAINING_DB_URL");

	public static final String username = System.getenv("TRAINING_DB_USERNAME");

	public static final String password = System.getenv("TRAINING_DB_PASSWORD");
	
	final static Logger LOGGER = Logger.getLogger(Driver.class);
}

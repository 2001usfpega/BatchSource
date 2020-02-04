package com.bankdao.interfaces.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	
	    protected Connection conn;
        private static String url=System.getenv("BANK_DB_URL");
		private final String username1=System.getenv("BANK_DB_USERNAME"); 
	    private final String password1=System.getenv("BANK_DB_PASSWORD");
	     
	    public void getConected() throws  Exception{
	    	try {
	    		conn=DriverManager.getConnection(url, username1, password1);
	    			
	    	}catch (Exception e) {
				// TODO: handle exception
	    		throw e;
			}
	    	
	    }
	    	
	    public void closeConnection() throws SQLException {
	    		 
	    		 if (conn!=null) {
	    			 if (!conn.isClosed()) {
	    				 
	    				 conn.close();
						
					}
					
				} 
	    		 
	    	 }
	    			 		
	    }
	    
	    
	



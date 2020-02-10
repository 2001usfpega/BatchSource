package com.proyect1.model;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.proyect1.dao.interf.RequestDao;
import com.proyect1.daoimpl.RequestDaoImpl;

public class Driver {
	
	/* logging level include 
	 * (lower priotrity)
	 * ALL debug info 
	 * */

	final static Logger logger=Logger.getLogger(Driver.class);
	
	
	public static void main(String[] arg) {
		logger.setLevel(Level.ERROR);

		//logger.setLevel(Level.ALL);
		
		if (logger.isInfoEnabled()) {
			logger.info("this is info : logger ara cool");
			
		}
		
		logger.warn("hthis is a warning it come for me a dawn");
		logger.error("this is a error ",         new IndexOutOfBoundsException());
       logger.fatal("This is fatal....like the DragonBallZ live action movie....");
      logger.info("---------");

		RequestDao mydao=new RequestDaoImpl();
		
	//	Scanner scan=new Scanner(System.in);
	//int ticke_id=	mydao.insertRequest("travel", 25, 120,"the gass expenses");
	//System.out.println(ticke_id);
	//List<Ticket> myTicket= mydao.selectAllTicket();
	//System.out.println(myTicket);
		
		 // mydao.updateRequestStatus(200);
		  
		  List<Ticket> requestList=mydao.selectAllTicket(); 
		  for (int i = 0; i<requestList.size(); i++) {
		  
		  System.out.println(requestList.get(i));
		  
		  }
		 
		System.out.println(mydao.selectAllEmployee());
	}
}

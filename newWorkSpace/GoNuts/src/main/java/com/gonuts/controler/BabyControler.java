package com.gonuts.controler;


import javax.servlet.http.HttpServletRequest;

import com.gonuts.Util;

public class BabyControler {

	
	public static String badLogin(HttpServletRequest req){
		String cont="Invalid username or password";
		return Util.pageBuilder(req,"Nope",cont,"/GoNuts/index.html","Retry");
	}
	
	public static String idk(HttpServletRequest req){
		String cont="Your request has been submitted. ";
		cont+="Click below to submit another request or click the logout button up top to quit.";
		return Util.pageBuilder(req,"Request Submitted",cont,"/GoNuts/home.chan","More");
	}
}

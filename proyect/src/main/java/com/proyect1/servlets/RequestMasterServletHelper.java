package com.proyect1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UDecoder;

import com.proyect1.controller.SubmitMoreRequestController;
import com.proyect1.controller.SubmitRequestController;
import com.proyect1.controller.UpadateTicketRequetsController;
import com.proyect1.controller.loginController;

public class RequestMasterServletHelper {

	public static String process(HttpServletRequest req) throws IOException, ServletException {
		System.out.println("HELPER SIDE");
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		//1.going to the logging process 
		case "/Proyect1Servlet/login.test":
			System.out.println("in login.test");
			return loginController.login(req);
        //2.if ins a employee go the submit requuest.html
		case "/Proyect1Servlet/submitRequest.test":
			System.out.println("in home.test");
			return SubmitRequestController.submit();
			//3. int the submit request controller process
			// and still in that page until wanto to log out

		case "/Proyect1Servlet/submittedRequest.test":
			return SubmitRequestController.process(req);
          //4. employee log out
		case "/Proyect1Servlet/finishRequest.test":
			return SubmitRequestController.empLogOut();
      //6. once the admin is in the page  it can approve tickets
		case "/Proyect1Servlet/approveRequest.test":
			return UpadateTicketRequetsController.approve(req);
			  //5. if is an admin it go to the approve request page
		case "/Proyect1Servlet/approveProcess.test":
			return UpadateTicketRequetsController.submit();
		case "/Proyect1Servlet/adminlogout.test":
			return UpadateTicketRequetsController.admLogout();
			
		/*
		 * //7.admin log out case"/Proyect1Servlet/finishApprove.test": return
		 * UpadateTicketRequetsController.adminLogOut(); //8. trying to show the lis of
		 * pending request case "/Proyect1Servlet/pendinglist.test": return
		 * UpadateTicketRequetsController.list(res);
		 */
		default:
			System.out.println("in default case");
			return "ProyectHtml/badLogin.html";

		}

	}
}

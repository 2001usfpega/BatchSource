/*    */ package com.project.controller;
/*    */ 
/*    */ import com.project.model.Employee;
/*    */ import com.project.service.EmployeeServImp;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ 
/*    */ public class LoginControl
/*    */ {
/*    */   public static String login(HttpServletRequest req) {
/* 11 */     if (!req.getMethod().equals("POST")) {
/* 12 */       return "resources/html/login.html";
/*    */     }
/*    */     
/* 15 */     String username = req.getParameter("username");
/* 16 */     String password = req.getParameter("password");
/* 17 */     int rank = req.getIntHeader("rank");
/* 18 */     EmployeeServImp employeeServImp = new EmployeeServImp();
/*    */     
/* 20 */     Employee jack = employeeServImp.checkUsernameAndPassword(username, password, rank);
/*    */ 
/*    */     
/* 23 */     if (jack == null) {
/* 24 */       return "bad.html";
/*    */     }
/* 26 */     if (jack.getRank() == 1) {
/* 27 */       return "/resources/html/Admin.do";
/*    */     }
/* 29 */     if (jack.getRank() == 2) {
/* 30 */       return "/resources/html/Employee.html";
/*    */     }
/*    */ 
/*    */     
/* 34 */     req.getSession().setAttribute("loggedusername", username);
/*    */     
/* 36 */     return "/resources/html/Employee.html";
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\controller\LoginControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
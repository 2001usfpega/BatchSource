/*    */ package com.project.serlets;
/*    */ 
/*    */ import com.project.controller.LoginControl;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RequestHelper
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
/* 22 */     System.out.println(req.getRequestURI());
/*    */     String str;
/* 24 */     switch ((str = req.getRequestURI()).hashCode()) { case -1896792420: if (!str.equals("/Project1/resources/html/Admin.do")) {
/*    */           break;
/*    */         }
/*    */ 
/*    */         
/* 29 */         System.out.println("in Admin.change");
/* 30 */         return "*.employee";
/*    */       case -897485927:
/*    */         if (!str.equals("/project1/resources/html/Employee.do"))
/* 33 */           break;  System.out.println("in Employee.change");
/* 34 */         return "resources/html/Employee.html";
/*    */       case 1095083074: if (!str.equals("/Project1/resources/html/Login.do"))
/* 36 */           break;  System.out.println("in login.change"); return LoginControl.login(req); }  System.out.println("in default case");
/* 37 */     return "resources/html/badlogin.html";
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\serlets\RequestHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
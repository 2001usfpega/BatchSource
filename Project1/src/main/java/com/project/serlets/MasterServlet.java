/*    */ package com.project.serlets;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MasterServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 19 */     System.out.println("In Master server, Get");
/* 20 */     request.getRequestDispatcher(RequestHelper.process(request, response))
/* 21 */       .forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 26 */     System.out.println("In Master server, Post");
/* 27 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\serlets\MasterServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
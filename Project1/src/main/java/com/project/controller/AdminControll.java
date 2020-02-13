/*    */ package com.project.controller;
/*    */ 
/*    */ import com.project.dao.ReimburstmentImp;
/*    */ import com.project.model.Employee;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdminControll
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static String doGet(HttpServletRequest request) {
/* 17 */     HttpSession in = request.getSession();
/* 18 */     Employee jim = (Employee)in.getAttribute("id");
/* 19 */     ReimburstmentImp reimburstmentImp = new ReimburstmentImp();
/*    */     
/* 21 */     if (jim == null) {
/* 22 */       return "bad.html";
/*    */     }
/*    */     
/* 25 */     int type = Integer.parseInt(request.getParameter("type"));
/* 26 */     int amount = Integer.parseInt(request.getParameter("amount"));
/* 27 */     int status = Integer.parseInt(request.getParameter("Status"));
/* 28 */     String description = request.getParameter("description");
/*    */     
/* 30 */     reimburstmentImp.insertReimburstment(type, amount, status, null, null, status, description, jim.getEmployeeid());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 37 */     return "Login.html";
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\controller\AdminControll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
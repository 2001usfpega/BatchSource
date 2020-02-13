/*    */ package com.project.controller;
/*    */ 
/*    */ import com.project.dao.ReimburstmentImp;
/*    */ import com.project.model.Employee;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdminControlll
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 29 */     ReimburstmentImp reimburstmentImp = new ReimburstmentImp();
/* 30 */     Employee there = new Employee();
/*    */ 
/*    */     
/* 33 */     int userid = Integer.parseInt(request.getParameter("userid"));
/* 34 */     int type = Integer.parseInt(request.getParameter("type"));
/* 35 */     int amount = Integer.parseInt(request.getParameter("Amount"));
/* 36 */     int status = Integer.parseInt(request.getParameter("status"));
/* 37 */     String description = request.getParameter("description");
/* 38 */     int empid = there.getEmployeeid();
/*    */     
/* 40 */     reimburstmentImp.insertReimburstment(userid, type, amount, null, null, status, description, empid);
/*    */ 
/*    */     
/* 43 */     HttpSession session = request.getSession();
/*    */     
/* 45 */     session.setAttribute("id", Integer.valueOf(userid));
/* 46 */     session.setAttribute("typeof", Integer.valueOf(type));
/* 47 */     session.setAttribute("amountof", Integer.valueOf(amount));
/* 48 */     session.setAttribute("status", Integer.valueOf(status));
/* 49 */     session.setAttribute("empid", Integer.valueOf(empid));
/* 50 */     PrintWriter out = response.getWriter();
/* 51 */     out.println("<html>");
/*    */     
/* 53 */     out.println("<title> Submission Confirmation </title>");
/*    */     
/* 55 */     out.println("<body>");
/*    */     
/* 57 */     out.println("<h2>Your ticket has been submitted.</h2>");
/*    */     
/* 59 */     out.println("</body></html>");
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\controller\AdminControlll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
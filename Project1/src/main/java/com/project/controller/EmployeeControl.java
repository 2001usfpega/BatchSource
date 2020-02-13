/*     */ package com.project.controller;
/*     */ 
/*     */ import com.project.dao.ReimburstmentImp;
/*     */ import com.project.model.Reimburstment;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EmployeeControl
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  25 */     ReimburstmentImp burst = new ReimburstmentImp();
/*  26 */     List<Reimburstment> tic = burst.selectAllReimburstment();
/*     */     
/*  28 */     PrintWriter out = response.getWriter();
/*  29 */     String output = "<html><style type=\"text/css\" media=\"all\">\r\n  .form_table { text-align: center; }\r\n  .full_width .segment_header { text-align: center !important; }\r\n  .q { float:none;display: inline-block; }\r\n  table.matrix, table.rating_ranking { margin-left:auto !important;margin-right:auto !important; }\r\ntext-align: center</style><title> All Reimbursement Requests </title><link rel=stylesheet type=\"text/css\" href=\"../css/Stylus.css\">\r\n<body><h2>Reimbursement Requests</h2><table><tr> <th>User Id</th> <th>Type</th> <th>Amount</th> <th>Date Submitted</th> <th>Date Resolved</th> <th>Status</th> <th>Description</th> <th>Ticket Id</th> </tr>";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     for (Reimburstment t : tic) {
/*  54 */       output = String.valueOf(output) + "<tr> <td>" + t.getTicketid() + "</td>" + 
/*  55 */         "<td>" + t.getType() + "</td>" + 
/*  56 */         "<td>" + t.getAmount() + "</td>" + 
/*  57 */         "<td>" + t.getDatesub() + "</td>" + 
/*  58 */         "<td>" + t.getDateres() + "</td>" + 
/*  59 */         "<td>" + t.getStatus() + "</td>" + 
/*  60 */         "<td>" + t.getDescription() + "</td>" + 
/*  61 */         "<td>" + t.getEmpid() + "</td> </tr>";
/*     */     }
/*     */ 
/*     */     
/*  65 */     output = String.valueOf(output) + "</table>";
/*     */ 
/*     */ 
/*     */     
/*  69 */     output = String.valueOf(output) + "</body></html>";
/*     */     
/*  71 */     out.println(output);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  80 */     ReimburstmentImp burst = new ReimburstmentImp();
/*  81 */     List<Reimburstment> tic = burst.selectAllReimburstment();
/*     */     
/*  83 */     PrintWriter out = response.getWriter();
/*  84 */     String output = "<html><style type=\"text/css\" media=\"all\">\r\n  .form_table { text-align: center; }\r\n  .full_width .segment_header { text-align: center !important; }\r\n  .q { float:none;display: inline-block; }\r\n  table.matrix, table.rating_ranking { margin-left:auto !important;margin-right:auto !important; }\r\ntext-align: center</style><title> All Reimbursement Requests </title><link rel=stylesheet type=\"text/css\" href=\"../css/Stylus.css\">\r\n<body><h2>Reimbursement Requests</h2><table><tr> <th>User Id</th> <th>Type</th> <th>Amount</th> <th>Date Submitted</th> <th>Date Resolved</th> <th>Status</th> <th>Description</th> <th>Ticket Id</th> </tr>";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     for (Reimburstment t : tic) {
/* 109 */       output = String.valueOf(output) + "<tr> <td>" + t.getTicketid() + "</td>" + 
/* 110 */         "<td>" + t.getType() + "</td>" + 
/* 111 */         "<td>" + t.getAmount() + "</td>" + 
/* 112 */         "<td>" + t.getDatesub() + "</td>" + 
/* 113 */         "<td>" + t.getDateres() + "</td>" + 
/* 114 */         "<td>" + t.getStatus() + "</td>" + 
/* 115 */         "<td>" + t.getDescription() + "</td>" + 
/* 116 */         "<td>" + t.getEmpid() + "</td> </tr>";
/*     */     }
/*     */ 
/*     */     
/* 120 */     output = String.valueOf(output) + "</table>";
/*     */ 
/*     */ 
/*     */     
/* 124 */     output = String.valueOf(output) + "</body></html>";
/*     */     
/* 126 */     out.println(output);
/*     */   }
/*     */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\controller\EmployeeControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package com.project.dao;
/*     */ 
/*     */ import com.project.model.Reimburstment;
/*     */ import java.sql.Date;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Scanner;
/*     */ 
/*     */ public class ReimburstmentImp
/*     */   implements ReimburstmentDao
/*     */ {
/*     */   static {
/*     */     try {
/*  15 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/*  16 */     } catch (ClassNotFoundException e) {
/*  17 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*  21 */   private static String url = System.getenv("TRAINING_DB_URL");
/*  22 */   private static String username = System.getenv("TRAINING_DB_USERNAME");
/*  23 */   private static String password = System.getenv("TRAINING_DB_PASSWORD");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int insertReimburstment(int id, int type, int amount, Date submitdate, Date resolvedate, int status, String decription, int empid) {
/*     */     try {
/*  31 */       Exception exception2, exception1 = null;
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
/*     */     }
/*  49 */     catch (SQLException e) {
/*  50 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/*  54 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Reimburstment> selectAllReimburstment() {
/*  60 */     List<Reimburstment> ticket = new ArrayList<>();
/*     */     try {
/*  62 */       Exception exception2, exception1 = null;
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
/*     */     }
/*  74 */     catch (SQLException e) {
/*  75 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  78 */     return ticket;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int selectReimburstmentById(Scanner in) {
/*     */     try {
/*  85 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  95 */     catch (SQLException e) {
/*  96 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/* 100 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int updateReimburstment(Reimburstment burst) {
/* 107 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int deleteReimburstment(Reimburstment burst) {
/* 113 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\dao\ReimburstmentImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
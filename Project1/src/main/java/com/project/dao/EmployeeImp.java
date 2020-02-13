/*     */ package com.project.dao;
/*     */ 
/*     */ import com.project.model.Employee;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EmployeeImp
/*     */   implements EmployeeDao
/*     */ {
/*     */   static {
/*     */     try {
/*  17 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/*  18 */     } catch (ClassNotFoundException e) {
/*  19 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*  23 */   private static String url = System.getenv("TRAINING_DB_URL");
/*  24 */   private static String username = System.getenv("TRAINING_DB_USERNAME");
/*  25 */   private static String password = System.getenv("TRAINING_DB_PASSWORD");
/*     */   
/*     */   public int insertEmployee(int id, String user, String pass, String firstname, String lastname, int rank) {
/*     */     try {
/*  29 */       Exception exception2, exception1 = null;
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
/*  43 */     catch (SQLException e) {
/*  44 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/*  48 */     return 0;
/*     */   }
/*     */   
/*     */   public List<Employee> selectAllEmployee() {
/*  52 */     List<Employee> select = new ArrayList<>();
/*     */     try {
/*  54 */       Exception exception2, exception1 = null;
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
/*  65 */     catch (SQLException e) {
/*  66 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  69 */     return select;
/*     */   }
/*     */   
/*     */   public Employee selectEmployeeById(int id) {
/*     */     try {
/*  74 */       Exception exception2, exception1 = null;
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
/*  85 */     catch (SQLException e) {
/*  86 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Employee selectEmployeeByName(String uname, String pass, int rank) {
/*  97 */     Employee Gin = null;
/*     */     try {
/*  99 */       Exception exception2, exception1 = null;
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
/*     */     }
/* 119 */     catch (SQLException e) {
/* 120 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 123 */     System.out.println(Gin);
/* 124 */     return Gin;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int updateEmployee(Employee emp) {
/* 130 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int deleteEmployee(Employee emp) {
/* 136 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\dao\EmployeeImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
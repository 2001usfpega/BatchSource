/*    */ package com.project.model;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Employee
/*    */ {
/*    */   int employeeid;
/*    */   String username;
/*    */   String password;
/*    */   String firstname;
/*    */   String lastname;
/*    */   int rank;
/*    */   
/*    */   public int getEmployeeid() {
/* 17 */     return this.employeeid;
/*    */   }
/*    */   public void setEmployeeid(int employeeid) {
/* 20 */     this.employeeid = employeeid;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUsername() {
/* 26 */     return this.username;
/*    */   }
/*    */   public void setUsername(String username) {
/* 29 */     this.username = username;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPassword() {
/* 36 */     return this.password;
/*    */   }
/*    */   public void setPassword(String password) {
/* 39 */     this.password = password;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFirstname() {
/* 46 */     return this.firstname;
/*    */   }
/*    */   public void setFirstname(String firstname) {
/* 49 */     this.firstname = firstname;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLastname() {
/* 56 */     return this.lastname;
/*    */   }
/*    */   public void setLastname(String lastname) {
/* 59 */     this.lastname = lastname;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRank() {
/* 66 */     return this.rank;
/*    */   }
/*    */   public void setRank(int rank) {
/* 69 */     this.rank = rank;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     return "Employee [employeeid=" + this.employeeid + ", username=" + this.username + ", password=" + this.password + 
/* 79 */       ", firstname=" + this.firstname + ", lastname=" + this.lastname + ", rank=" + this.rank + "]";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Employee(int employeeid, String username, String password, String firstname, String lastname, int rank) {
/* 85 */     this.employeeid = employeeid;
/* 86 */     this.username = username;
/* 87 */     this.password = password;
/* 88 */     this.firstname = firstname;
/* 89 */     this.lastname = lastname;
/* 90 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   public Employee() {}
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\model\Employee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
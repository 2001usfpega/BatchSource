/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.EmployeeDao;
/*    */ import com.project.dao.EmployeeImp;
/*    */ import com.project.model.Employee;
/*    */ import java.util.List;
/*    */ 
/*    */ public class EmployeeServImp
/*    */   implements EmployeeServ
/*    */ {
/* 11 */   private EmployeeDao employeedao = (EmployeeDao)new EmployeeImp();
/*    */ 
/*    */   
/*    */   public List<Employee> getAllEmployee() {
/* 15 */     List<Employee> select = this.employeedao.selectAllEmployee();
/* 16 */     return select;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Employee getEmployee(Employee employee) {
/* 24 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void accountCreate(String user) {}
/*    */ 
/*    */ 
/*    */   
/* 33 */   private EmployeeDao login = (EmployeeDao)new EmployeeImp();
/*    */ 
/*    */   
/*    */   public Employee checkUsernameAndPassword(String u, String p, int r) {
/* 37 */     return this.login.selectEmployeeByName(u, p, r);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean login(String u, String p) {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Employee checkUsernameAndPassword(String u, String p) {
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\service\EmployeeServImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
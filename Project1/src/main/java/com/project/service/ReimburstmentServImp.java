/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.ReimburstmentImp;
/*    */ import com.project.model.Reimburstment;
/*    */ import java.sql.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReimburstmentServImp
/*    */   implements ReimburstmentServ
/*    */ {
/*    */   public List<Reimburstment> getAllReimburstment() {
/* 15 */     ReimburstmentImp reimburstmentImp = new ReimburstmentImp();
/* 16 */     reimburstmentImp.selectAllReimburstment();
/*    */ 
/*    */     
/* 19 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int createReimburstment(int id, int type, int amount, Date submitdate, Date resolvedate, int status, String decription, int empid) {
/* 26 */     ReimburstmentImp reimburstmentImp = new ReimburstmentImp();
/*    */     
/* 28 */     reimburstmentImp.insertReimburstment(id, type, amount, submitdate, resolvedate, status, decription, empid);
/*    */     
/* 30 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\service\ReimburstmentServImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
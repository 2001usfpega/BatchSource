/*    */ package com.project.main;
/*    */ 
/*    */ import org.apache.log4j.Level;
/*    */ import org.apache.log4j.Logger;
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
/*    */ 
/*    */ 
/*    */ public class MainDriver
/*    */ {
/*    */   static {
/*    */     try {
/* 22 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 23 */     } catch (ClassNotFoundException e) {
/* 24 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/* 28 */   private static String url = System.getenv("TRAINING_DB_URL");
/* 29 */   private static String username = System.getenv("TRAINING_DB_USERNAME");
/* 30 */   private static String password = System.getenv("TRAINING_DB_PASSWORD");
/*    */ 
/*    */   
/* 33 */   static final Logger LOGGY_THE_LOG = Logger.getLogger(MainDriver.class);
/*    */   
/*    */   public static void main(String[] args) {
/* 36 */     LOGGY_THE_LOG.setLevel(Level.ALL);
/*    */     
/* 38 */     if (LOGGY_THE_LOG.isInfoEnabled()) {
/* 39 */       LOGGY_THE_LOG.info("This is info: loggers are cool, right? Sugoi!");
/*    */     }
/*    */     
/* 42 */     LOGGY_THE_LOG.warn("This is a warning: it comes for me at dawn.....");
/* 43 */     LOGGY_THE_LOG.error("This is an error: pineapples don't go on pizza.....", 
/* 44 */         new IndexOutOfBoundsException());
/* 45 */     LOGGY_THE_LOG.fatal("This is fatal....like the DragonBallZ live action movie....");
/* 46 */     LOGGY_THE_LOG.info("---------");
/*    */   }
/*    */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\main\MainDriver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
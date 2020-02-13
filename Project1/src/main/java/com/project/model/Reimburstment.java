/*     */ package com.project.model;
/*     */ 
/*     */ import java.sql.Date;
/*     */ 
/*     */ 
/*     */ public class Reimburstment
/*     */ {
/*     */   private int ticketid;
/*     */   private int type;
/*     */   private int amount;
/*     */   private Date datesub;
/*     */   private Date dateres;
/*     */   private int status;
/*     */   private String description;
/*     */   private int empid;
/*     */   
/*     */   public int getTicketid() {
/*  18 */     return this.ticketid;
/*     */   }
/*     */   
/*     */   public void setTicketid(int ticketid) {
/*  22 */     this.ticketid = ticketid;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  26 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(int type) {
/*  30 */     this.type = type;
/*     */   }
/*     */   
/*     */   public int getAmount() {
/*  34 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(int amount) {
/*  38 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Date getDatesub() {
/*  42 */     return this.datesub;
/*     */   }
/*     */   
/*     */   public void setDatesub(Date datesub) {
/*  46 */     this.datesub = datesub;
/*     */   }
/*     */   
/*     */   public Date getDateres() {
/*  50 */     return this.dateres;
/*     */   }
/*     */   
/*     */   public void setDateres(Date dateres) {
/*  54 */     this.dateres = dateres;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/*  58 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/*  62 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  66 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  70 */     this.description = description;
/*     */   }
/*     */   
/*     */   public int getEmpid() {
/*  74 */     return this.empid;
/*     */   }
/*     */   
/*     */   public void setEmpid(int empid) {
/*  78 */     this.empid = empid;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  83 */     return "Reimburstment [ticketid=" + this.ticketid + ", type=" + this.type + ", amount=" + this.amount + ", datesub=" + this.datesub + 
/*  84 */       ", dateres=" + this.dateres + ", status=" + this.status + ", description=" + this.description + ", empid=" + this.empid + 
/*  85 */       "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reimburstment() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Reimburstment(int ticketid, int type, int amount, Date datesub, Date dateres, int status, String description, int empid) {
/*  96 */     this.ticketid = ticketid;
/*  97 */     this.type = type;
/*  98 */     this.amount = amount;
/*  99 */     this.datesub = datesub;
/* 100 */     this.dateres = dateres;
/* 101 */     this.status = status;
/* 102 */     this.description = description;
/* 103 */     this.empid = empid;
/*     */   }
/*     */ }


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\model\Reimburstment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
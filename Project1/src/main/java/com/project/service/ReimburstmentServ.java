package com.project.service;

import com.project.model.Reimburstment;
import java.sql.Date;
import java.util.List;

public interface ReimburstmentServ {
  List<Reimburstment> getAllReimburstment();
  
  int createReimburstment(int paramInt1, int paramInt2, int paramInt3, Date paramDate1, Date paramDate2, int paramInt4, String paramString, int paramInt5);
}


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\service\ReimburstmentServ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
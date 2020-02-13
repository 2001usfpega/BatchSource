package com.project.dao;

import com.project.model.Reimburstment;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public interface ReimburstmentDao {
  int insertReimburstment(int paramInt1, int paramInt2, int paramInt3, Date paramDate1, Date paramDate2, int paramInt4, String paramString, int paramInt5);
  
  List<Reimburstment> selectAllReimburstment();
  
  int selectReimburstmentById(Scanner paramScanner);
  
  int updateReimburstment(Reimburstment paramReimburstment);
  
  int deleteReimburstment(Reimburstment paramReimburstment);
}


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\dao\ReimburstmentDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
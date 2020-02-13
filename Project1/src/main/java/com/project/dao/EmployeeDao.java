package com.project.dao;

import com.project.model.Employee;
import java.util.List;

public interface EmployeeDao {
  int insertEmployee(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2);
  
  List<Employee> selectAllEmployee();
  
  Employee selectEmployeeById(int paramInt);
  
  Employee selectEmployeeByName(String paramString1, String paramString2, int paramInt);
  
  int updateEmployee(Employee paramEmployee);
  
  int deleteEmployee(Employee paramEmployee);
}


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\dao\EmployeeDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package com.project.service;

import com.project.model.Employee;
import java.util.List;

public interface EmployeeServ {
  List<Employee> getAllEmployee();
  
  Employee getEmployee(Employee paramEmployee);
  
  void accountCreate(String paramString);
  
  Employee checkUsernameAndPassword(String paramString1, String paramString2, int paramInt);
  
  boolean login(String paramString1, String paramString2);
  
  Employee checkUsernameAndPassword(String paramString1, String paramString2);
}


/* Location:              C:\Users\jayka\OneDrive\Desktop\BatchSource\Project1\target\classes\com.jar!\com\project\service\EmployeeServ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package com.revature.Driver;

import java.util.Comparator;

public class Q7_SortEmployeesByDepartment implements Comparator<Employee> 
{ 
    // sorting in ascending order of 
    // department 
    public int compare(Employee a, Employee b) 
    { 
        return a.department.compareTo(b.department); 
    } 

}  

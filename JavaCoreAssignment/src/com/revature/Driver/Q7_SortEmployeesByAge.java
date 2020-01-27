package com.revature.Driver;

import java.util.Comparator;

public class Q7_SortEmployeesByAge implements Comparator<Employee> 
{ 
    // sorting in ascending order of 
    // age
    public int compare(Employee a, Employee b) 
    { 
        return a.age - b.age; 
    } 

}  
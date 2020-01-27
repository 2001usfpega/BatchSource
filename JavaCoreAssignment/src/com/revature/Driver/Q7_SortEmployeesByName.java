package com.revature.Driver;

import java.util.Comparator;

public class Q7_SortEmployeesByName implements Comparator<Employee> 
{ 
    // sorting in ascending order of 
    // name 
    public int compare(Employee a, Employee b) 
    { 
        return a.name.compareTo(b.name); 
    } 

} 



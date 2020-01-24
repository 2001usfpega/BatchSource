package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareName {

	public static void main(String[] args) {
		
		List<student> StuList=new ArrayList<student>();
		StuList.addAll(Arrays.asList(new student[] {
				new student(15, "Matt", 6.54),
				new student(45, "AJ", 10.54),
				new student(25, "Torres", 6.84),
				new student(14, "Amanda", 6.58),
				new student(58, "alia", 155.5),
				
				
		}));
          System.out.println("Original List");
          for (student s : StuList) {
        	  System.out.println(s);
			
		}
          System.out.println("===========================");
          Collections.sort(StuList);
          for (student s : StuList) {
        	  System.out.println(s);
			
		}
          System.out.println("===========================");
          System.out.println("sorted by GPA");
          Collections.sort(StuList,new StudentComparator());
          for (student s : StuList) {
        	  System.out.println(s);
			
		}
          
          System.out.println("============================");
          System.out.println(" Sorte by label w/ lambda");
          //fntional interfaces have 1 (not default)
          Collections.sort(StuList, (arg0,arg1)
        		  ->{
        			  return arg0.getLabel().compareTo(arg1.getLabel());
        		  }
        		  
        		  
        		  
        		  );
          for (student s : StuList) {
        	  System.out.println(s);
			
		}
          
          
          
	}

}

package com.revature.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		
		//create a array list
		List<String> a1=new ArrayList<>();
		// add element
		a1.add("c");
		a1.add("d");
		a1.add("g");
		a1.add("b");
		a1.add("a");
		a1.add("f");
		a1.add("e");
		//use iterator to dysplay constents of a1
		System.out.println("orifinal contents of a1");
		Iterator<String> itr=a1.iterator();
	  	System.out.println(itr.next());
		while (itr.hasNext()) {
			String element = (String) itr.next();
			System.out.print(element+" ");
		}
			// modify object being iterated
			ListIterator<String> listr=a1.listIterator();
			while (listr.hasNext()) {
				String element = (String) listr.next();
				listr.set(element+" ");}
				System.out.println("\nModified contents of a1");
				itr=a1.iterator();
				while (itr.hasNext()) {
					String element = (String) itr.next();
					System.out.print(element+" ");
				}
				
				// print modify list backwards
				System.out.println("\nModifed list backwards");
				while (listr.hasPrevious()) {
					String element = (String) listr.previous();
					System.out.print(element+" ");
					
				}
			
			
		}

	

}

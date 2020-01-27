package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an ArrayList

		List<String> a1 = new ArrayList<String>();
		// add elements
		a1.add("C");
		a1.add("11");
		a1.add("Seventeen");
		a1.add("Rick James");
		a1.add("L");
		a1.add("W");
		a1.add("E");
		// use iterator to display contents of a1
		System.out.print("Original Contents of a1:");
		Iterator<String> itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		// modify the objects being iterated
		ListIterator<String> litr = a1.listIterator();

		while (litr.hasNext()) {
			String element = litr.next();
			litr.set(element + "+");
		}
		System.out.println("\nModified Contents of a1:");
		itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");

		}
			System.out.println("\nModified list backwards: ");
			while(litr.hasPrevious()) {
				String element = litr.previous();
				System.out.print(element + " ");
				
			}
			
	}

}

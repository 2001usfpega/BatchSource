package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
	/*
	 * Iterator ALL of theses implement the iterable interface only iterables can be used
	 * in for each loops. Interface, when implemented allows the implementing
	 * type to be the subject of a for each loop. every collection has an iterator
	 * allows traversal between elements and safe removal of elements in place 
	 */
	public static void main(String[] args) {
		//create an ArrayList
		List<String> a1 = new ArrayList<String>();
		//add elements
		a1.add("C");
		a1.add("D");
		a1.add("G");
		a1.add("B");
		a1.add("A");
		a1.add("F");
		a1.add("E");
		//use Iterator to display contents of a1
		System.out.println("Original Contents of a1: ");
		Iterator<String> itr = a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		//Modify object being iterated
		ListIterator<String> litr = a1.listIterator();
		while(litr.hasNext()) {
			String element = litr.next();
			litr.set(element + "+");
		}
		System.out.println("\nModified contents of a1: ");
		itr = a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		//print modified list backwards
		System.out.println("\nModified list Backwards: ");
		while(litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}
		
	}
}

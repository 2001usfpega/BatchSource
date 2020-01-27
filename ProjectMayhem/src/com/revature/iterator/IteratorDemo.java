package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
	
	/*
	 * 
	 */

	public static void main(String[] args) {
		//create an array list
		List<String> a1 = new ArrayList<String>();
		//add elements
		a1.add("C");
		a1.add("B");
		a1.add("A");
		a1.add("D");
		a1.add("E");
		a1.add("G");
		a1.add("F");
		//use iterator to display contents of a1
		System.out.println("Original contents of a1: ");
		Iterator<String> itr = a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		//modify the object being iterated
		ListIterator<String> litr = a1.listIterator();
		while(litr.hasNext()) {
			String element =litr.next();
			litr.set(element+"+");
		}
		System.out.println("\n modified contents of a1: ");
		itr=a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		//print modified list backwords\
		System.out.println("\nModified List Backwards: ");
		while(litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}
	}

}

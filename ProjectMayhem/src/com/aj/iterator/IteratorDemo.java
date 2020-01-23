package com.aj.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	/*
	 * Only iterables can be used in for each loops Iterator Interface: when
	 * implemented, allows the implementing type to
	 */

	public static void main(String[] args) {
		List<String> a1 = new ArrayList<String>();
		a1.add("c");
		a1.add("d");
		a1.add("g");
		a1.add("b");
		a1.add("a");
		a1.add("f");
		a1.add("e");

		// use iterator to display contents of a1

		System.out.println("Original contents of a1: ");
		Iterator<String> it = a1.iterator();

		while (it.hasNext()) {
			String el = it.next();
			System.out.print(el + " ");
		}

		// modify the object being iterated
		ListIterator<String> listIt = a1.listIterator();
		while (listIt.hasNext()) {
			String el = listIt.next();
			listIt.set(el + " + ");
		}

		System.out.println("\nModified contents of a1: ");
		it = a1.iterator();
		while (it.hasNext()) {
			String el = it.next();
			System.out.print(el + " ");
		}
		System.out.println("\nModified list backward: ");
		while (listIt.hasPrevious()) {
			String el = listIt.previous();
			System.out.print(el + " ");
		}

	}

}

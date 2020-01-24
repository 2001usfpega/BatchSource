package com.revature.iterator;

<<<<<<< HEAD
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

	
=======
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
	/*
	 * Iterator All of these implement the Iterable interface only iterables can be
	 * used in for each loops Interface, when implemented, allows the implementing
	 * type to be the subject of a for each loop every collection has an iterator
	 * allows traversal between elements and safe removal of elements in place
	 * 
	 */
	public static void main(String[] args) {
		//create an arraylist
		List<String> a1= new ArrayList<String>();
		//add elements
		a1.add("C");
		a1.add("D");
		a1.add("G");
		a1.add("B");
		a1.add("A");
		a1.add("F");
		a1.add("E");
		//use iterator to display contents of a1
		System.out.println("Original Contents of a1: ");
		Iterator <String> itr= a1.iterator();
		while(itr.hasNext()) {
			String element= itr.next();
			System.out.print(element+ " ");
		}
		//Modify object being iterated
		ListIterator<String> litr= a1.listIterator();
		while(litr.hasNext()) {
			String element = litr.next();
			litr.set(element+"+");
		}
		System.out.println("\nModified Contents of a1:");
		itr=a1.iterator();
		while(itr.hasNext()) {
			String element= itr.next();
			System.out.print(element+ " ");
		}
		//print modified list backwards
		System.out.println("\nModifed list Backwards: ");
		while(litr.hasPrevious()) {
			String element= litr.previous();
			System.out.print(element+ " ");
		}
	}
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8

}

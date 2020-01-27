package com.revature.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

public class IteratorDemo 
{
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) 
	{
		//create an arraylist
		List<String> al = new ArrayList<String>();
		//add element
		al.add("C");
		al.add("A");
		al.add("B");
		al.add("D");
		al.add("E");
		al.add("F");
		al.add("G");
		
		System.out.println("Orininal Contents of al: ");
		Iterator<String> itr = al.iterator();
		
		while(itr.hasNext()) 
		{
			String element = itr.next();
			System.out.print(element + " ");
		}
		
		ListIterator<String> litr= al.listIterator();
		
		while(litr.hasNext()) 
		{
			String element = litr.next();
			litr.set(element+"+");
		}
		System.out.println("\n modify contents of al:");
		itr = al.iterator();
		
		while(itr.hasNext()) 
		{
			String element = itr.next();
			System.out.print(element + " ");
			
		}
		System.out.println("\n Modifyed list Backwards: ");
		while(litr.hasPrevious()) 
		{
			String element = litr.previous();
			System.out.print(element + " ");
		}
		
		
	}

}

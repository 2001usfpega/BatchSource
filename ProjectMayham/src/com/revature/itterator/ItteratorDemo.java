package com.revature.itterator;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ItteratorDemo {

	public static void main(String[] args) {
		
		//List<String> a1= new ArrayList<String>();
		List<String> a1= new LinkedList<String>();
		
		String [] g={"D","F","Q","S","C"};
		
		Collections.addAll(a1,g);
		
		
		Iterator <String> itr=a1.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		ListIterator<String> litr=a1.listIterator();
		while(litr.hasNext()) {
			litr.set(litr.next()+ "+");
		}
		System.out.println("\n\nwith plus");

		itr=a1.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		
		System.out.println("\n\nBackwards");
		while(litr.hasPrevious()) {
			System.out.print(litr.previous()+"");
		}

	}

}

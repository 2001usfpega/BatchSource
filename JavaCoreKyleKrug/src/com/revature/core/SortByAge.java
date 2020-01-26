package com.revature.core;

import java.util.Comparator;

public class SortByAge implements Comparator<employee> {

	@Override
	public int compare(employee a, employee b) {
		// TODO Auto-generated method stub
		return a.age - b.age ;
	}

}

package com.revature.core;

import java.util.Comparator;
//Kyle Howard Krug
public class NameSort implements Comparator<employee>{

	@Override
	public int compare(employee a, employee b) {

		return a.name.compareTo(b.name);
	}

}

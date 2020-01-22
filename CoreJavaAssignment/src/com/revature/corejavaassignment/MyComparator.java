package com.revature.corejavaassignment;

import java.util.Comparator;

public class MyComparator implements Comparator<ComparatorQuestion> {

	@Override
	//overriding the comparTo method to compare an elements name, dept, and age
	public int compare(ComparatorQuestion compQuest1, ComparatorQuestion compQuest2) {
		//comparing the names
		int result = compQuest1.getName().compareTo(compQuest2.getName());
		//adding an if statement for logic to occur when two names are equal
		if (result == 0) {
			//comparing the depts
			result = compQuest1.getDept().compareTo(compQuest2.getDept());
			//adding an if statement for logic to occur when two names are equal
			if (result == 0) {
				//comparing the ages
				result = Integer.compare(compQuest1.getAge(), compQuest2.getAge());
			}
		}
		return result;
	}
}

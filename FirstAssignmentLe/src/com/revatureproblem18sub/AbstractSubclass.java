package com.revatureproblem18sub;

import com.revature.problem18.StringMethods;

public class AbstractSubclass extends StringMethods{
	String string;
	
	public void setString(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}
	
	public boolean upperChecking() {
		for (int i = 0; i < string.length(); i++) {
			if (Character.isUpperCase(string.charAt(i))) {
				System.out.println("There is Uppercase charater inside the input String!");
				return true;
			}
		}
		System.out.println("There is not any Uppercase charater inside the input String!");
		return false;
	}
	
	public void intConvert() {
		
	}
	
	public void upperConvert() {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isUpperCase(string.charAt(i))) {
				setString(string.substring(0,i)+
						Character.toUpperCase(string.charAt(i)) + string.substring(i+1));
				
			}
		}
		System.out.println("The String after convert to uppercase is: "+ getString());
	}
}

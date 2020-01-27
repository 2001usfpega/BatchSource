package com.revarture.generics;

public class Gen1 <T> 
{
	/*generics
	 * using a type as parameter
	 * write code that can handle diff typres of objects
	 * use anfle brackets<> to denote that something is a generics
	 * allows us to ensure type safety
	 * adds stability and reusability to our code
	 * placeholder use in*/

	T ob;
	
	Gen1(T o)
	{
		ob=o;
	}
	//getter
	T getOb() 
	{
		return ob;
	}
	//show type
	void showType() 
	{
		System.out.println("Type of T is: " + ob.getClass().getName());
	}
	
	
	
	public static void main(String[] args) 
	{
		

	}

}

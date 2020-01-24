package com.revature.voodoo;
<<<<<<< HEAD
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public class ReflectionDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    A a=new A();
    Class<?> c=a.getClass();
    System.out.println("public method");
    Method m[]= c.getDeclaredMethods();
    for (int i = 0; i < m.length; i++) {
	    int modifier=m[i].getModifiers();
	    if (Modifier.isPublic(modifier)) {
	    	 System.out.println(m[i].getName());
		}
	   
	
}
		
		
	}
static class A{
	public static void a1() {
		
		
	}
	
    public void a2() {
	
	
      }	
}
	
	
=======

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {

	public static void main(String[] args) {
		A a= new A();
		Class<?> c= a.getClass();
		System.out.println("Private methods:");
		Method m[]=c.getDeclaredMethods();
		for(int i=0;i<m.length;i++) {
			int modifiers= m[i].getModifiers();
			if(Modifier.isPrivate(modifiers)) {
				System.out.println(m[i].getName());
			}
		}
	}

}

class A{
	public static void a1() {
		
	}
	public void a2() {
		
	}
	protected void a3() {
		
	}
	private void a4() {
		
	}
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8
}

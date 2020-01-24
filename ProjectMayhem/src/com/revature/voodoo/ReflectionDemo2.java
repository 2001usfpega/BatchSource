package com.revature.voodoo;
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
	
	
}

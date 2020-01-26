package com.revature.voodoo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class rfd {

	public static void main(String[] args) {
		A a=new A();
		Class<?> c=a.getClass();
		System.out.println("pub");
		Method m[]=c.getDeclaredMethods();
		
		for(int i=0;i<m.length;i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.println(m[i].getName());
			}
		}

		
		
	}

}

class A{
	public void a1() {}
	//private void a2() {}
	
	
}
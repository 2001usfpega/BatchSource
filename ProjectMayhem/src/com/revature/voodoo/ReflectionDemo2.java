package com.revature.voodoo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {

	public static void main(String[] args) {
		A a = new A();
		Class<?> c = a.getClass();
		System.out.println("Public Methods: ");
		Method meth[] = c.getDeclaredMethods();
		for(int i = 0; i < meth.length; i++) {
			int modifiers = meth[i].getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.println(meth[i].getName());
			}
		}
	}
}
class A {
	public void a1() {
		
	}
	public void a2() {
		
	}
	protected void a3() {
		
	}
	private void a4() {
		
	}
}
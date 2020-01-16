package com.revature.conversions;

import javax.sound.midi.Soundbank;

public class Cramit {
	/* estamos convirtiendo las vaviables de mayor a menor y vice versa
	 * 
	 * */
	 static float f=32.876f;
	static double d;
	static float g;
	public static void main(String[] args) {
		//widening
		d=f;
		//narrowing
		g=(float)d;
		System.out.println(d);
		System.out.println(g);
		Object o;
		o=new String("yeeeheee");
		System.out.println(o);
		
	}

}

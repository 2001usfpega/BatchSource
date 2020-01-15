package com.revature.brain;

class Raptor extends Bird{
	static {System.out.println("R1");}
	
	public Raptor() {
		System.out.println("R2");
	}
	
	{ System.out.println("R3"); }
	
	static {System.out.println("R4");}
}

class Bird {
	{ System.out.println("b1"); }
	
	Bird(){
		System.out.println("b2");
	}
	
	static {System.out.println("b3");}
}

public class Hawk extends Raptor{
	public static void main(String[] args) {
		System.out.println("init");
		new Hawk();
		System.out.println("hawk");
	}
	
	public Hawk() {
		
	}
}


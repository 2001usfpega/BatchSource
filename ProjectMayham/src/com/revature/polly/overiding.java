package com.revature.polly;

public class overiding {

	public static void main(String[] args) {
		
		Mammal m = new Mammal();
		PitBull p = new PitBull();
		
		m.eat();
		p.eat();
		p.eat();
		
		for(int i=0;i<10;i++) {
			System.out.println(10-i);
		}
		//System.out.println(i);

	}

}

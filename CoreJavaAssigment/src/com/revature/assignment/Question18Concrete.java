package com.revature.assignment;

public class Question18Concrete extends Question18Abstract {



	@Override
	public boolean part1(String a) {
		
		
		for(int b=0; b<a.length(); b++) {
			
			if(Character.isUpperCase(a.charAt(b))) {
				
				System.out.println("True");
				return true;
			}
		}
		System.out.println("False");
		return false;
	}

	@Override
	public String part2(String b) {
		b=b.toUpperCase();
		System.out.println(b);
		return b;
	}

	@Override
	public int part3(String c) {
		// TODO Auto-generated method stub
		int d= Integer.parseInt(c);
		

		return d += 10;
	}
	
	

}

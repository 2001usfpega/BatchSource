package com.revature.coreassignment;

public class TriangleNumbers {
	public static void main(String[] args) {
		
		String z = "0";
		String o = "1";
		String s = "0";
		System.out.println(s);
		for (int i = 1; i < 5; i++) {
			if (i%2 != 0) {
				s = o + s;
				System.out.println(s);
				s = s + o;
				System.out.println(s);
			}
			else {
				s = z + s;
				System.out.println(s);
				s = s + z;
				System.out.println(s);
			}
				
			
			
		}

	}

}
//using the for loop and else loop we iterate with the numbers.
//the for loop says if the remainder of i/2 does't equal 0 then it will
//print the variables.
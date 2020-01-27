//reference https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

package com.revature.assignment;

public class Q2 
{
	 
	//adds the two previous numbers together then stores the resulting number
		static int num(int p) 
		{
			int a = 0,
				b = 1,
				c;
			
			if(p == 0) 
			{
				return a;
			}
			
			for(int i = 2; i <= p; i++) 
			{
				c = a + b;
				a = b;
				b = c;
			}
			return b;
		}
		
	// print number in the series based on is position
	public static void main(String[] args) 
	{
		int g = 0;
		System.out.println(num(g));
		
		int h = 1;
		System.out.println(num(h));
		
		int i = 2;
		System.out.println(num(i));
		
		int j = 3;
		System.out.println(num(j));
		
		int k = 4;
		System.out.println(num(k));
		
		int l = 5;
		System.out.println(num(l));
		
		int m = 6;
		System.out.println(num(m));
		
		int n = 7;
		System.out.println(num(n));
		
		int o = 8;
		System.out.println(num(o));
		
		int p = 9;
		System.out.println(num(p));
		
		int q = 10;
		System.out.println(num(q));
		
		int r = 11;
		System.out.println(num(r));
		
		int s = 12;
		System.out.println(num(s));
		
		int t = 13;
		System.out.println(num(t));
		
		int u = 14;
		System.out.println(num(u));
		
		int v = 15;
		System.out.println(num(v));
		
		int w = 16;
		System.out.println(num(w));
		
		int x = 17;
		System.out.println(num(x));
		
		int y = 18;
		System.out.println(num(y));
		
		int z = 19;
		System.out.println(num(z));
		
		int ran = 20;
		System.out.println(num(ran));
		
		int out = 21;
		System.out.println(num(out));
		
		int of = 22;
		System.out.println(num(of));
		
		int letters = 23;
		System.out.println(num(letters));
		
		int so = 24;
		System.out.println(num(so));
		
		int yea = 25;
		System.out.println(num(yea));
	}
	
	

}

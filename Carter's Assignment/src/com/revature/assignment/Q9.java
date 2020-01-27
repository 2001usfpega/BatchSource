//reference https://www.javatpoint.com/program-to-print-all-prime-numbers-between-1-to-100
package com.revature.assignment;

public class Q9 
{
	
	public static void main(String[] args) 
	{
		int ct = 0, n = 0, i = 1, j = 1;
		// as n is 0 it will count till it reaches 25
		while(n<25) 
		{
			j = 1;
			ct = 0;
			
			while(j <= i) 
			{
				//divide by 0??????????????
				if(i%j ==  0) 
				{
					ct++;
					j++;
				}
				//prints prime numbers
				if(ct==2) 
				{
					System.out.printf("%d ", i);
					n++;
				}
				i++;
			}
		}
	}

}

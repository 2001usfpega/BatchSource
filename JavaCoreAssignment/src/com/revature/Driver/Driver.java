package com.revature.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
	


	public static void main(String[] args){
		

		
		System.out.println("Q1:");
		Q1 q1 = new Q1();
//		q1.bubbleSort( 1,0,5,6,3,2,3,7,9,8,4 );
		int[] q1Array = q1.bubbleSort( 1,0,5,6,3,2,3,7,9,8,4 );
		for (int x: q1Array) {
			System.out.print(x + " ");
		}
		System.out.println("\n");
		
		
		System.out.println("Q2:");
		Q2 q2 = new Q2();
		int fiboNum = 25;
		int [] fibo = new int[fiboNum];
		fibo = q2.fibonacci(fiboNum);
		for (int ans : fibo) {
			System.out.print(ans + " ");
		}
		System.out.println("\n");
		
		
		System.out.println("Q3:");
		Q3 q3 = new Q3();
		String strQ3 = q3.reverseString("abcdefg");
		for (int i = 0; i < strQ3.length(); i++) {
			System.out.print(strQ3.charAt(i));
		}
		System.out.println("\n");
		
		
		System.out.println("Q4:");
		Q4 q4 = new Q4();
		int N = 4;   ///////////////////// change N here
		int intQ4 = q4.factorial(N);
		System.out.println(intQ4);
		System.out.println("\n");
		
		
		System.out.println("Q5:");
		Q5 q5 = new Q5();
		String str = "abcdefghijklmn";  //put your string here
		int idx = 7;
		String strQ5  = q5.substring(str , idx);
		System.out.println( strQ5  + "\n");
		
		
		System.out.println("Q6:");
		Q6 q6 = new Q6();
		int integer = 202;                    //put your int here
		String ansQ6 = q6.evenOrNot(integer);
		System.out.println(ansQ6);
		System.out.println("\n");
		
		
		System.out.println("Q7:");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Mike", "Fire" , 28));
		employees.add(new Employee("John", "Police" , 29));
		employees.add(new Employee("Jack", "Medical" , 34));
		
		System.out.println("Unsorted:");
		for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i)); 
		
		Collections.sort(employees, new Q7_SortEmployeesByName()); 
        System.out.println("\nSorted by name:"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
        
		Collections.sort(employees, new Q7_SortEmployeesByDepartment()); 
        System.out.println("\nSorted by department:"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
        
		Collections.sort(employees, new Q7_SortEmployeesByAge()); 
        System.out.println("\nSorted by age:"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
        System.out.println("\n");
        
        
        System.out.println("Q8:");
        Q8 q8 = new Q8();
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> palindrome = new ArrayList<String>();
        al.add("karan");
        al.add("madam");
        al.add("tom");
        al.add("civic");
        al.add("radar");
        al.add("jimmy");
        al.add("kayak");
        al.add("john");
        al.add("refer");
        al.add("billy");
        al.add("did");
        palindrome = q8.splitPalindrome(al);
        for(int i = 0; i < palindrome.size(); i++) {   
		    System.out.print(palindrome.get(i));
		} 
        System.out.println("\n");
        
        
        
        
        System.out.println("Q9:");
		Q9 q9 = new Q9();
		ArrayList<Integer> alQ9 = new ArrayList<Integer> ();
		ArrayList<Integer> ansQ9 = new ArrayList<Integer> ();
		
		for (int i = 1; i <= 100; i++ ) {
			alQ9.add(i);
		}
		
		
		ansQ9 = q9.prime(alQ9);
		for (int i=0; i<ansQ9.size(); i++) 
            System.out.print(ansQ9.get(i) + " ");
		System.out.println("\n");
		
		
		
		System.out.println("Q10:");
		Q10 q10 = new Q10();
		int box1 = 5;
		int box2 = 9;
		int ansQ10 = q10.ternary(box1, box2);
		System.out.println("the minimum is " + ansQ10);
		System.out.println("\n");
		
		
		
		System.out.println("Q11:");
		Q11 q11 = new Q11();
		float[] flQ11 = q11.readFloat();
		for (int i = 0; i< flQ11.length; i++) {
			System.out.println(flQ11[i]);
		}
		System.out.println("\n");
		
		
		System.out.println("Q12:");
		Q12 q12 = new Q12();
		int[] ansQ12 = q12.enhancedForLoop();
		System.out.println("\n");
		
		
		System.out.println("Q13:");
		Q13 q13 = new Q13();
		q13.triangle();
		System.out.println("\n");

		
		System.out.println("Q14:");
		Q14 q14 = new Q14();
		q14.switchCase();
		System.out.println("\n");
		
		
		System.out.println("Q15:");
		Q15 q15 = new Q15();
		double a,b;
		a = 30d;
		b = 2.5d;
		System.out.println(q15.addition(a, b));
		System.out.println(q15.subtraction(a, b));
		System.out.println(q15.multiplication(a, b));
		System.out.println(q15.division(a, b));
		System.out.println("\n");
		
		System.out.println("Q16:");
		Q16 q16 = new Q16();
		System.out.println("the num of characters in command line is : "
		+ q16.numOfCharacters(args) );
		System.out.println("\n");
		
		System.out.println("Q17:");
		Q17 q17 = new Q17();
		q17.fromCustomer();
		System.out.println("\n");
		
		System.out.println("Q18:");
		Q18child q18 = new Q18child();
		String big= " I AM BIG";
		String numStr = "10976";
		System.out.println( q18.isUppercase(big) + " ");
		System.out.println( q18.toLowerCase(big) + " ");
		System.out.print( q18.add10(numStr) );
		System.out.println("\n");
		
		System.out.println("Q19:");
		Q19 q19 = new Q19();
		q19.doArrayList();
		System.out.println("\n");
		
		
		
		
		System.out.println("Q20:");
		Q20 q20 = new Q20();
		File file = new File("Q20.txt");
		
		@SuppressWarnings("resource")
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content = "";
		
		while (scan.hasNextLine()) {
			content = content.concat(scan.nextLine() + ":");
		}
		
		q20.workingAt20(content);
		System.out.println("\n");
		
	
		
		
		
		
		

		

		
		
		
		
		
		
		

	}
}

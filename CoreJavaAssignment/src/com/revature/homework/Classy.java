package com.revature.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.revature.otherpackage.Princess;

public class Classy {

	public static void main(String [] cheese) {		
		
		bubbleSort(1,0,5,6,3,2,3,7,9,8,4);		//Q1
		fib(25);								//Q2
		reverseString("Roll Tide!");			//Q3
		factorial(5);							//Q4
		subString("Roll Tide!", 6);				//Q5
		evenOdd(2);								//Q6
		sortEmployees();						//Q7
		palindromes("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did");//Q8
		primeNums(100);							//Q9
		minimum(14,3);							//Q10
		printFloatsFromElsewhere();				//Q11
		printEvenTo(100);						//Q12
		makeTriangle(4);						//Q13
		switchCases(0);						//Q14
		switchCases(1);						//Q14
		switchCases(2);						//Q14
		calculations(53.5,33.2);				//Q15
		countLetters(cheese);					//Q16
		interesting();							//Q17
	}

	//Q1 bubble sort
	public static void bubbleSort(int ... list) {
		System.out.println("Q1. Bubble Sort");
		printArray(list);
		for(int i=0;i<list.length-1;i++) {
			for(int j=0;j<list.length-i-1;j++) {
				if(list[j]>list[j+1]) {
					int temp=list[j];
					list[j]=list[j+1];
					list[j+1]=temp;
				}
			}
		}
		printArray(list);
		System.out.println();
	}
	
	
	//Q2 fibonacci
	public static void fib(int x) {
		System.out.println("Q2. Fibonacci");
		if(x<=0) {
			System.out.println("must be greater than zero");
		}
		else if (x==1) {
			System.out.println("0");
		}
		else {
			int [] arr=new int [x];
			arr[0]=0;
			arr[1]=1;
			for(int i=2;i<x;i++) {
				arr[i]=arr[i-1]+arr[i-2];
			}
			
			printArray(arr);
		}
		System.out.println();
	}
	
	//Q3 Reverse string
	public static void reverseString(String s) {
		System.out.println("Q3. Reverse String");
		System.out.println(s);
		for(int i= s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println('\n');
	}
	
	//Q4 Factorial
	public static void factorial(int n) {
		System.out.println("Q4. Factorial");
		System.out.println(fact(n));
		System.out.println();
	}

	//recursive factorial method
	private static int fact(int n) {
		if(n>1) {
			return n*fact(n-1);
		}
		return 1;
	}
	
	//Q5 sub string
	public static void subString(String s, int idx) {
		System.out.println("Q5. Substring");
		for(int i=0;i<idx;i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println('\n');		
	}
	
	
	//Q6 Even 
	public static void evenOdd(int x) {
		System.out.println("Q6. Even or Odd?");
		System.out.print(x+" is ");
		int t = x/2;
		if(t*2==x) {
			System.out.println("even!");
		}
		else {
			System.out.println("odd!");
		}
		System.out.println();
	}
	
	//Q7 Sort Employees
	public static void sortEmployees() {
		System.out.println("Q7. Sort Employees");
		ArrayList<Employee> roster = new ArrayList<>();
		roster.add(new Employee("Todd", "AI", 31));
		roster.add(new Employee("Jake", "IT", 25));

		System.out.println("\tOriginal");
		printEmployees(roster);
		Collections.sort(roster, new SortByName());
		System.out.println("\tSort by name");
		printEmployees(roster);
		Collections.sort(roster, new SortByDepartment());
		System.out.println("\tSort by department");
		printEmployees(roster);
		Collections.sort(roster, new SortByAge());
		System.out.println("\tSort by age");
		printEmployees(roster);
		System.out.println();
	}
	
	//Q8 palindromes
	public static void palindromes(String ... s) {
		System.out.println("Q8. Palindromes");
		ArrayList <String> a = new ArrayList<>();
		ArrayList <String> pally = new ArrayList<>();
		Collections.addAll(a, s);
		for(String test:a) {
			boolean isPal=true;
			for(int i=0; i<test.length()/2;i++) {
				if(test.charAt(i)!=test.charAt(test.length()-1-i)) {
					isPal=false;
					break;
				}
			}
			if(isPal) {
				pally.add(test);
			}
		}
		for(String test:pally) {
			System.out.print(test+" ");
		}
		System.out.println('\n');
	}
	
	//Q9 Primes
	public static void primeNums(int x) {
		System.out.println("Q9. Primes");
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2;i<=x;i++) {
			boolean isPrime = true;
			for(int j:primes) {
				if(i%j==0) {
					isPrime=false;
					break;				
				}
			}
			if(isPrime) {
				primes.add(i);
			}
		}
		for(int i:primes) {
			System.out.print(i + " ");
		}
		System.out.println('\n');
	}
	
	//Q10 Ternary Minimum
	public static void minimum(int a, int b) {
		System.out.println("Q10. Ternary Minimum");
		System.out.println(a>b?b + " is smaller than " + a:a + " is smaller than " + b);
		System.out.println();
	}
	
	//Q11 Floats from another package
	public static void printFloatsFromElsewhere(){
		System.out.println("Q11. Floats from another package");
		Princess p = new Princess();
		System.out.println("The princess is in another package at");
		System.out.println(p.getX()+ ", " + p.getY());
		System.out.println();
	}
	
	//Q12 Print Even
	public static void printEvenTo(int x) {
		System.out.println("Q12. Print Even");
		int [] numbers = new int [x];
		for(int i=0; i<x; i++) {
			numbers[i]=i+1;
		}
		for(int i:numbers) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		System.out.println('\n');
	}
	
	//Q13 Triangle
	public static void makeTriangle(int rows) {
		System.out.println("Q13. Triangle");
		int swap =0;
		for(int i =0; i<rows;i++) {
			for(int j=0; j<=i;j++) {
				System.out.print(swap);
				swap=1-swap;
			}
			System.out.println();
		}
		System.out.println();		
	}
	
	//Q14 Switch Case
	public static void switchCases(int x){
		System.out.println("Q14. Switch Case " + x);
		switch(x){
			case 0:
				System.out.println(Math.sqrt(Math.PI));
				break;
			case 1:
				LocalDate d = LocalDate.now();
				System.out.println(d);
				break;
			case 2:
				String s = "I am learning Core Java";
				String [] splited=s.split(" ");
				for(String i : splited) {
					System.out.println(i);
				}
				break;
			default:
				System.out.println("nope!");		
		}
		System.out.println();
	}
	
	//Q15 Implimentation of math interface
	public static void calculations(double a, double b) {
		System.out.println("Q15. Implimentation of math interface");
		Calculate ti83=new Calculate();
		System.out.println(a+ " + " + b + " = " +ti83.addition(a, b));
		System.out.println(a+ " - " + b + " = " +ti83.subtraction(a, b));
		System.out.println(a+ " x " + b + " = " +ti83.multiplication(a, b));
		System.out.println(a+ " / " + b + " = " +ti83.division(a, b));
		System.out.println();	
	}
	
	//Q16 String Count
	public static void countLetters(String ... s) {
		//String [] s2= {"hi","bob"};
		//s=s2;
		System.out.println("Q16. String Count");
		if(s.length>0) {
			System.out.println(s[0] + " has " + s[0].length() + " characters");
		}
		else {
			System.out.println("nothing to print");
		}
		System.out.println();
	}
	
	//Q17 Interest
	public static void interesting() {
		double principal;
		double rate;
		double time;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Q17. Interest");
		System.out.println("Enter the principal:");
		principal=input.nextDouble();
		System.out.println("Enter the rate of interest:");
		rate=input.nextDouble();
		System.out.println("Enter the numbers of years:");
		time=input.nextDouble();
		
		input.close();
		
		System.out.println(principal*rate*time);
		System.out.println();
	}
	
	//prints an array of ints with spaces between
	public static void printArray(int ... a) {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//print an arrayList of employees
	public static void printEmployees(ArrayList<Employee> a) {
		for(Employee e:a) {
			System.out.println(e.toString());
		}
		
	}
}

//Q7 Employee
class Employee{
	String name;
	String department;
	int age;
	
	Employee(String name,String department,int age){
		this.name=name;
		this.department=department;
		this.age=age;
	}

	@Override
	public String toString() {
		return "\t\tEmployee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
}
class SortByName implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}
class SortByDepartment implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}
class SortByAge implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.age-b.age;
	}
}

	

//	Q14. 
//	Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
//	Case 1: Find the square root of a number using the Math class method.
//	Case 2: Display today’s date.
//	Case 3: Split the following string and store it in a string array.
//	       	 “I am learning Core Java”
//	Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division. Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.
//	Q16. Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
//	Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.
//	Interest = Principal* Rate* Time
//	Q18. Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
//	 
//	1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//	2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.
//	3.          	Convert the input string to integer and add 10, output the result to the console.
//	Create an appropriate class having a main method to test the above setup.
//	Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
//	Q20. Create a notepad file called Data.txt and enter the following:
//	Mickey:Mouse:35:Arizona
//	Hulk:Hogan:50:Virginia
//	Roger:Rabbit:22:California
//	Wonder:Woman:18:Montana
//	 
//	Write a program that would read from the file and print it out to the screen in the following format:
//	 
//	Name: Mickey Mouse
//	Age: 35 years
//	State: Arizona State


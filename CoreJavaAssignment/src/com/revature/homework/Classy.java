package com.revature.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
		konctete("goldfishY");					//Q18
		numbersAndSums(10);						//Q19
		dataReader();							//Q20
	}

	//Q1 bubble sort
	public static void bubbleSort(int ... list) {
		System.out.println("Q1. Bubble Sort");
		printArray(list);
		
		//sort the bubbles
		for(int i=0;i<list.length-1;i++) {
			for(int j=0;j<list.length-i-1;j++) {
				//switch if necessary
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
			//initalize the first two elements
			arr[0]=0;
			arr[1]=1;
			//build the fibonacci array
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
		//print string starting with the last char
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
		//print the first idx chars one by one
		for(int i=0;i<idx;i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println('\n');		
	}
	
	//Q6 Even 
	public static void evenOdd(int x) {
		System.out.println("Q6. Even or Odd?");
		System.out.print(x+" is ");

		//divide by 2 and multiply by 2 to see if its the same
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
		//sort by name
		Collections.sort(roster, new SortByName());
		System.out.println("\tSort by name");
		printEmployees(roster);
		//sort by department
		Collections.sort(roster, new SortByDepartment());
		System.out.println("\tSort by department");
		printEmployees(roster);
		//sort by age
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
				//compare first and last char, working inward
				if(test.charAt(i)!=test.charAt(test.length()-1-i)) {
					isPal=false;
					break;
				}
			}
			//add to list if still true
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
		printArray(getPrimes(x));
		System.out.println();
	}
	
	//return all the primes between 0 and x
	static ArrayList<Integer> getPrimes(int x){
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2;i<=x;i++) {
			boolean isPrime = true;
			//check if divisable by other primes
			for(int j:primes) {
				if(i%j==0) {
					isPrime=false;
					break;				
				}
			}
			//add to list of primes
			if(isPrime) {
				primes.add(i);
			}
		}
		return primes;
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
		//make array
		for(int i=0; i<x; i++) {
			numbers[i]=i+1;
		}
		for(int i:numbers) {
			//check if even
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
			//print the square root of pi
			case 0:
				System.out.println("the square root of PI is " + Math.sqrt(Math.PI));
				break;
			//print date
			case 1:
				LocalDate d = LocalDate.now();
				System.out.println(d);
				break;
			//splits string and prints it on sepperate lines
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
		//print a bunch of calculations
		System.out.println(a+ " + " + b + " = " +ti83.addition(a, b));
		System.out.println(a+ " - " + b + " = " +ti83.subtraction(a, b));
		System.out.println(a+ " x " + b + " = " +ti83.multiplication(a, b));
		System.out.println(a+ " / " + b + " = " +ti83.division(a, b));
		System.out.println();	
	}
	
	//Q16 String Count
	public static void countLetters(String ... s) {
		System.out.println("Q16. String Count");
		//checks if the first element has a length and prints it
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
		System.out.print("Enter the principal: ");
		principal=input.nextDouble();
		System.out.print("Enter the rate of interest: ");
		rate=input.nextDouble();
		System.out.print("Enter the numbers of years: ");
		time=input.nextDouble();
		
		input.close();
		
		//p*r*t
		System.out.println("Your interest will be $"+principal*rate*time);
		System.out.println();
	}
	
	//Q18 Test Concrete Class
	public static void konctete(String test) {
		System.out.println("Q18. Test Concrete Class");
		StringImplimentation si=new StringImplimentation();
		
		if(si.hasUpper(test)) {
			System.out.println(test + " is all lower case");
		}
		else {
			System.out.println(test + " has an upper case character");
			System.out.println(si.toUpper(test)+ " is now lower case");
		}
		si.addTen("1327");
		System.out.println();
	}
	
	//Q19 Add odds and evens
	public static void numbersAndSums(int max) {
		System.out.println("Q19 Add odds and evens");
		ArrayList<Integer> nums = new ArrayList<>();
		//fill the list
		for(int i =1;i<=max;i++) {
			nums.add(i);
		}
		printArray(nums);
		//calculate sums
		int [] sums = {0,0};
		for(int i:nums) {
			sums[i%2]+=i;
		}
		System.out.println("the odd sum is:  "+sums[1]);
		System.out.println("the even sum is: "+sums[0]);
		
		//remove primes
		ArrayList<Integer> primes = getPrimes(max);
		Iterator<Integer> idd=nums.iterator();
		while(idd.hasNext()) {
			int i=idd.next();
			if(primes.contains(i)) {
				idd.remove();
			}
		}
		System.out.print("non-primes are: ");
		printArray(nums);
		System.out.println();
	}
	
	//Q20 Read File
	public static void dataReader() {
		System.out.println("Q20. Read File");
		File file = new File("D:\\GIT\\BatchSource\\CoreJavaAssignment\\src\\com\\revature\\homework\\Data.txt");
		try {
			Scanner doc = new Scanner(file);
			//loop the doc
			while(doc.hasNextLine()) {
				//split the line
				String [] line = doc.nextLine().split(":");
				System.out.println("Name: "+line[0]+" "+line[1]);
				System.out.println("Age: "+line[2]+ " years");
				System.out.println("State: "+line[3]+" State\n");
			}
			
			doc.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
	}
	
	//prints an array of ints with spaces between
	public static void printArray(int ... a) {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//print an array list of ints
	static void printArray(ArrayList<Integer> a) {
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
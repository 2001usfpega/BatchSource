package com.revature.assignment;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.revature.employee.Employee;
import com.revature.problem11.Admin;
import com.revature.problem15.InterfaceImplementation;
import com.revatureproblem18sub.AbstractSubclass;

public class DriverClass {
	public static double[] inputArr1= {1.0,0.0,5.0,6.0,3.0,2.0,3.0,7.0,9.0,8.0,4.0};
	
	
	
	public static void main(String[] args) throws IOException {
		
		boolean run = true;
		do {
			System.out.println();
			System.out.println();
			System.out.println("The list of your choice:");
			System.out.println("0. Exit the program");
			System.out.println("1. Performing bubble sort");
			System.out.println("2. Find Fibonancy Sequence");
			System.out.println("3. Revese a string");
			System.out.println("4. Find N-Factorial");
			System.out.println("5. Find sub-string");
			System.out.println("6. Check if a number is even or not");
			System.out.println("7. Sorting Employee");
			System.out.println("8. Store strings into ArrayList and find palindromes");
			System.out.println("9. Finding prime numbers");
			System.out.println("10. Find smaller number between two input numbers");
			System.out.println("11. <--QUESTION???-->");
			System.out.println("12. Find even number from 1 to 100");
			System.out.println("13. Build a Binary Right Triangle");
			System.out.println("14. Switch Demonstration");
			System.out.println("15. ----------------------Having fun with Interface");
			System.out.println("16. Count character from input argument String");
			System.out.println("17. Find interest from Console input");
			System.out.println("18. ----------------------Have fun with Abstract Class and methods - CONVERT TO INT???");
			System.out.println("19. ArrayList multiple tasks");
			System.out.println("20. Read file and print");
			
			System.out.println("Please input the number of your choice:");
			
			Scanner scan = new Scanner(System.in);
			
			try {
				switch (scan.nextInt()) {
				case 1:	//Performing Bubble Sort
					System.out.println();
					double [] retArr = bubbleSort(inputArr1);
					for (double d : retArr) {
						System.out.print(d+" ");
					}
					//System.out.println(retArr);
					System.out.println();
					break;
				
				case 2: // Fibonancy printing
					System.out.println("Input the first number of the sequence:");
					double fNum = scan.nextDouble();
					System.out.println("Input the second number of the sequence:");
					double sNum = scan.nextDouble();
					double [] fibArr = new double[25];
					if (fNum>sNum) {
						fibArr=fibonancySequence(sNum, fNum,25);
					}else {
						fibArr=fibonancySequence(fNum, sNum,25);
					}	
					for (double d : fibArr) {
						System.out.println(d+" ");
					}
					System.out.println();
					break;
					
				case 3://String Reverse
					System.out.print("Type in the word or String to Reverse:");
					String str = scan.next();
					System.out.print("Input String is:" + str);
					String revString = stringReverse(str);	
					System.out.println("The result is: "+ revString);
				
					break;
					
				case 4://Q4: Compute N Factorial
					System.out.print("How many factorial that you want to find?");
					int n = scan.nextInt();
					System.out.println(nFactorial(n));				
					break;
					
				case 5://Q5: Substring
					System.out.print("Type in String: ");
					str = scan.next();
					System.out.print("Input the index for sub-string: ");
					n = scan.nextInt();
					subString(str, n);				
					break;
					
				case 6://Q6: even number checking
					System.out.println("What is the number for checking: ");
					double inNum = scan.nextInt();
					evenNumber(inNum);
					break;
					
				case 7:
					//Create 2 employee
					Employee emp1 = new Employee("Le", 1111, 25);
					Employee emp2 = new Employee("Le", 1111, 19);
					Employee emp3 = new Employee("Le", 1100, 19);
					Employee emp4 = new Employee("Dung", 1100, 25);
					
					ArrayList<Employee> empList = new ArrayList<>();

					empList.add(emp1);
					empList.add(emp2);
					empList.add(emp3);
					empList.add(emp4);
					
					Collections.sort(empList, new EmpComparator());
					
					for (Employee employee : empList) {
						System.out.println(employee); 
					} 
					 
					break;
					
				case 8://ArrayList and palindromes
					String [] arrInputStrings = {"karan", "madam", "tom", "civic", "radar", "jimmy",
							"kayak","john","refer", "billy", "did"};
					palindArr(arrInputStrings);
					break;
					
				case 9:
					//Find Prime number from 1 to 100
					ArrayList<Integer> primeList = primeNum(1,100);
					break;
					
				case 10://Q10: Find the minimum using ternary operator
					System.out.println("Input the first number:");
					fNum = scan.nextDouble();
					System.out.println("Input the second number:");
					sNum = scan.nextDouble();
					System.out.println("The smaller number is: " + ternaryOp(fNum, sNum));
					break;
					
				case 11://Employee getter and setter???
					Admin admin = new Admin();
					admin.accessingFloat();
					break;
					
				case 12://Q12: Print even number from 1 to 100
					System.out.println("Even numbers from 1 to 100 are:");
					evenPrint(100);
					break;
					
				case 13://Q13: Binary triangle
					System.out.println("How tall your triangle will be? ");
					n = scan.nextInt();
					triangleBin(4);
					break;
					
				case 14://Q14: Switch demo
					System.out.println("What is your choice (1-3):");
					n =scan.nextInt();
					switchDemo(n);
					break;
					
				case 15://Interface Implemetation
					InterfaceImplementation intImp = new InterfaceImplementation();
					intImp.setNum1(2);
					intImp.setNum2(4);
					System.out.println("Additon of 2 and 4 is "+intImp.addition());
					System.out.println("Multiplication of 2 and 4 is "+intImp.multiplication());
					System.out.println("Substraction of 2 by 4 is: "+intImp.substraction());
					System.out.println("Division of 2 by 4 is "+intImp.division());
					break;
				
				case 16:
					//Counts character from a String
					charCount("Tui bi dien roi", "Dung tin toi!!!");
					break;
					
				case 17://Calculate the interest
					intCal();
					break;
					
				case 18://Abstract classs
					AbstractSubclass sb = new AbstractSubclass();
					sb.setString("Hello World");
					sb.upperChecking();
					sb.upperConvert();
					break;
					
				case 19://ArrayLists Tasks
					arrListTasks();
					break;
					
				case 20:// File reading
					try {
						fileRead();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 0:
					run = false;
					break;
					
				default:
					System.out.println("Incorrect Choice. Please choose another numer!");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please input a number!!!");
			}
			
			
			//scan.close();
		} while (run);
	}
	
	/*	Q1
	 * 	This method perform bubble sort on the given String
	 */
	public static double[] bubbleSort(double[] inputArr2) {
		int i,j;
		double []inputArr = new double[inputArr2.length];
		inputArr = inputArr2.clone(); 
		for (i = 0; i < inputArr.length-1; i++) {
			double min = inputArr[i];
			for (j = i+1;  j< inputArr.length;j ++) {
				if (min > inputArr[j]) {
					double tmp = inputArr[j];
					inputArr[j]= inputArr[i];
					inputArr[i] = tmp;
					min = inputArr[i];
				}
			}			
		}
		
		return inputArr;
	}
	
	/* Q2
	 * This method will find and print (without storing) out 25 number of Fibonancy Sequence.
	 * The inputs are first two number of the sequence
	 */
	
	public static double[] fibonancySequence(double firstNum, double secNum, int length) {
		double [] fibArr = new double[length];
		fibArr[0] = firstNum;
		fibArr[1] = secNum;
		double i = firstNum;
		double j = secNum;
		System.out.print(i+" "+j);
		for (int k = 2; k < length; k++) {
			fibArr[k] = fibArr[k-1] + fibArr[k-2];
//			  double fibNum = i + j; 
//			  i = j; 
//			  j = fibNum; System.out.print(" "+fibNum);	
		}
		return fibArr;
	}
	
	/* Q3
	 * This method reverse the input string
	 */
	public static String stringReverse(String str) {
		System.out.println();
		  char [] c = new char[str.length()]; int length; 
		  //Determine if the number of  character in input String is even or odd. 
		  if(str.length()%2==0) 
			  length =  str.length()/2;
		  else { 
			  length = (int)str.length() + 1; 
			  } 
		  for (int i = 0; i < str.length(); i++) {
			  if (i<length) {
				  c[i] = str.charAt(str.length() - 1 - i); 
				  c[str.length() - 1 - i] =	  str.charAt(i);
				  if (i == length) { 
					  break; 
					  } 
				  }else { 
					  c[i] = str.charAt(i);
					  break; 
					  } 
			  }
		  
		  String out = new String(c); 
		  

		 return out;
	}
	
	/* Q4
	 * This method calculate manual N-Factorial
	 */
	public static int nFactorial(int n) {
		int tmp = 1;
		for (int i = 0; i < n; i++) {
			tmp*= (i+1);
		}
		return tmp;
	}
	
	/* Q5
	 * This method takes out sub-string from input String from location of 0 to input index
	 */
	public static String subString(String str, int idx) {
		char [] c = new char[idx];
		for (int i = 0; i < idx ; i++) {
			c[i] = str.charAt(i);
		}
		String subStr = new String(c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println();
		return subStr;
	}
	
	/* Q6
	 * This method checks if the input number is even or not without using modulo operation
	 */
	public static boolean evenNumber(double num) {
		double d = (double)num/2;
		int i = (int)num/2;
		if (d - i != 0) {
			System.out.println(num + " is NOT an even number");
			return false;
		}else {
			System.out.println(num+" is an even number");
			return true;
		}		
	}
	
	//-----Q7: Outside class-----
	
	/* Q8
	 * Store the input string into ArrayList and save all the palindromes 
	 * in another ArrayList.
	 */
	
	public static ArrayList<String> palindArr(String ...str) {
		ArrayList<String> arrList = new ArrayList<String>();
		Collections.addAll(arrList, str);
		ArrayList<String> palindArrayList = new ArrayList<>();
		
		//Take out each word from the String
		for (String string : arrList) {
			boolean palin = true;
			for (int i = 0; i < string.length(); i++) {
				if (Character.toUpperCase( string.charAt(i)) != Character.toUpperCase( string.charAt(string.length()-1 -i))) {
					palin = false;
					break;
				}
			}
			if (palin) {
				palindArrayList.add(string);
			}
		}
		
		System.out.println(palindArrayList);
		return palindArrayList;
	}
	
	
	/*
	 * Q9:Prime number finding
	 */
	public static ArrayList<Integer> primeNum(int start, int end) {
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Integer> primeList = new ArrayList<>();
		System.out.println();
		for (int i = start - 1; i < end; i++) {
			//Add number into ArrayList.
			numList.add(i+1); 
			//System.out.print(numList.get(i));
			//Find prime number.
			if (i+1<=2) {
				if (i+1 == 2) {
					primeList.add(i+1);
				}
				continue;
			}else {
				for (int j = 0; j < primeList.size(); j++) {
					if ((i+1) % primeList.get(j).intValue() == 0) {
						break;
					}else if (j+1 == primeList.size() && (i+1) % primeList.get(j).intValue() != 0) {
						primeList.add(i+1);
					}
				}
			}
		}
		
		System.out.println("Prime numbers from: "+ start+" to "+end+" are");
		for (Integer integer : primeList) {
			System.out.print(integer + " ");
		}
		System.out.println();
		return primeList;
	}
	
	/* Q10
	 * This method returns the smaller number between two input parameter in double type
	 */
	public static double ternaryOp(double a, double b) {
		return a<b?a:b;
	}
	
	/* Q12
	 * This method store 100 numbers into an array and print out even number only
	 */
	public static ArrayList<Integer> evenPrint(int length) {
		int [] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		ArrayList<Integer> evenNum = new ArrayList<>();
		for (int i : arr) {
			if(i%2 == 0)
			{
				System.out.print(i+" ");
				evenNum.add(i);
			}
				
		}
		
		System.out.println();
		return evenNum;
	}
	
	/* Q13
	 * This method draws out a Binary triangle as requesting
	 */
	public static void triangleBin(int high) {
		boolean flag = false;
		for (int i = 0; i < high; i++) {
			for (int j = 0; j <= i; j++) {
				if (!flag) {
					System.out.print(0);
					flag = true;
				}else {
					System.out.print(1);
					flag = false;
				}
				System.out.print(" ");
			}
			System.out.println();			
		}
	}
	
	/* Q14
	 * This method demonstrate the switch 
	 */
	public static void switchDemo(int choice) throws IOException {

		switch (choice) {
		case 1:
			//Find the square root of a number
			System.out.print("Input the number to find its square root: ");
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
	        String inputString = buffRead.readLine();
	        System.out.println("The quare root of "+ inputString+" is: " + Math.sqrt(Double.valueOf(inputString) ));
			break;
		case 2:
			//Display today day
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
			LocalDate localDate = LocalDate.now();
			DayOfWeek dayOfWeek = localDate.getDayOfWeek();
			System.out.println("Today is: "+dayOfWeek+" "+ localDate);
			break;
		case 3:
			//split String and store in String array
			String givString = "I am learning Core Java";
			String [] splitString = givString.split(" ");
			for (String string : splitString) {
				System.out.println(string);
			}
			break;
		default:
			break;
		}	
	}
	
	/*
	 * Q16: Count character from input String 
	 */
	
	public static int charCount(String ...str) {
		int count = 0;
		for (String string : str) {
			for (int i = 0; i < string.length(); i++) {
				if (Character.isAlphabetic( string.charAt(i))) {
					count++;
					//System.out.print(string.charAt(i));
				}
			}
		}
		
		
		System.out.println("The input argument string has "+count+" characters!");
		return count;
	}
	
	/*
	 * Q17
	 * Calculate the interest
	 */
	public static void intCal() {
		System.out.print("Input the pricipal: ");
		Scanner scanner = new Scanner(System.in);
		double prin = scanner.nextDouble();
		
		System.out.println("Input the rate: ");
		double rate = scanner.nextDouble();
		
		System.out.println("In put the time (year): ");
		double year = scanner.nextDouble();
		System.out.println("The interest will be: "+ prin*rate*year);
		
		scanner.close();
	}
	
	
	/*
	 * Q19
	 * ArrayList Multiple Tasks
	 */
	public static void arrListTasks() {
		int oddSum = 0;
		int evenSum = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> primeArrayList = primeNum(1, 10);
		
		//Insert from 1 to 10 to ArrayList
		for (int i = 0; i < 10; i++) {
			arrayList.add(i+1);
		}
		
		//Print array
		System.out.println("The ArrayList includes: ");
		for (Integer integer : arrayList) {
			System.out.print(integer+" ");
		}
		System.out.println();
		
		//Find sum
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) % 2 == 0) {
				evenSum+=arrayList.get(i);
			}else {
				oddSum+=arrayList.get(i);
			}
		}
		System.out.println("The sum of even numbers from 1 to 10 is: "+ evenSum);
		System.out.println("The sum of odd numbers from 1 to 10 is: "+ oddSum);
		
		//Remove prime number
		for (int i = 0; i < primeArrayList.size(); i++) {
			for (int j = 0; j < arrayList.size(); j++) {
				if (primeArrayList.get(i) == arrayList.get(j)) {
					arrayList.remove(j);
					break;
				}
			}
		}
		
		System.out.println("New array after removing prime numbers:");
		for (Integer integer : arrayList) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	
	
	/*
	 * Q20: Read file
	 */
	public static void fileRead() throws Exception {
		String path = System.getProperty("user.dir");
		//System.out.println(path);
		
		File file = new File(path + "\\Problem20.txt");
		
		if (!file.exists()) {
			System.out.println("Cannot find input file");
		}else {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String [] line = scanner.nextLine().split(":");
				System.out.println("Name: " + line[0] +" "+line[1]);
				System.out.println("Age: "+line[2]);
				System.out.println("State: "+line[3]);
				System.out.println();
			}
			scanner.close();
		}
	}
}

/*
 *  Q7: Sorting Empployee depending on Name, Department and Age
 */
class EmpComparator implements Comparator<Employee>{
	public int compare(Employee emp1, Employee emp2) {
		int nameCompare = emp1.getEmName().compareTo(emp2.getEmName());
		int depCompare = emp1.getEmDep().compareTo(emp2.getEmDep());
		int ageCompare = emp1.getEmAge().compareTo(emp2.getEmAge());
		
		if (nameCompare==0) {
			if (depCompare == 0) {
				if (ageCompare == 0) {
					return nameCompare;
				}else {
					return ageCompare;
				}
			}else {
				return depCompare;
			}
		}else {
			return nameCompare;
		}
	}
}

package com.revature.practiceAssn;

public class LoadingOver {
	
	
	static int firstInt = 43;
	static double firstDub = 3.1415926535;
	static Integer firstIntObj = 45;
	static Double firstDubObj = 2.771;
	static int secondInt  = 34;
	
	public static double multiplyEm(int a, double b){
		return a*b;
		
	}
	
	public static void printVarArgs(String ...v) {
		for(String x:v) {
			
		System.out.print(x);
		}
	}
	
	public static void main(String [] arrrrg) {
		
		
		System.out.println(multiplyEm(firstInt, firstDub));
		System.out.println(multiplyEm(firstInt, secondInt));
		System.out.println(multiplyEm(firstIntObj, firstDubObj));
		printVarArgs("Pam", "Jim", "Dwight", "Creed", "Toby");
		
	}

	
	
}

package com.revature.assignments;

import java.util.*;



public class Demo {
	
	public static void main(String[] args) {
	//Q6
	//isEven(-2);
	//Q10
	//minNums(40,8);
	//Q17
	//System.out.println(simpleInterest());
	//Q12
	//evenArray();
	//Q8
	//palindromeArray();
	//Q9
	//System.out.println(isPrime(3));
	//primeNums();
	//Q4
	//System.out.println(nFactorial(6));
	//Q2
	//fibonacci25();
	//Q14
	//switchDemo(4);
	//Q5
	//System.out.println(subString("hotdog", 3));
	//Q3
	//System.out.println(reverseString("hotdog"));
	//Q19
	//numbers();
	//Q18
	/*
	Concrete test = new Concrete();
	System.out.println(test.ifUpper("Lauren"));
	System.out.println(test.toUpper("lauren"));
	System.out.println(test.stringToInt("88"));
	*/
	//Q13
	triangle();

	}
	//decided to alter it a bit to be isEven method since another question deals with even
	public static void isEven(int num) {
	//check if INTEGER is even
	int quotient = num/2;
	//will have to be integer so if number is odd, quotient*2 won't return same number
	//System.out.println(quotient);
	if(quotient*2== num){
	System.out.println("Is an even number");}
	else {System.out.println("Is an odd number");}
	}
	public static void minNums(int a, int b) {
	int min;
	min = (a < b)
	? a //if a < b, then a
	: b; // if a not < b = b < a, then b
	System.out.println("The minimum of these numbers is " + min + ".");
	}
	public static double simpleInterest() {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter values for principal, rate, and time."); //tells user to input values
	double principal = input.nextDouble(); // principal value input - used double in case not rounded value
	double rate = input.nextDouble(); // rate input
	int time = input.nextInt(); //time input - integer years or months

	return principal * rate * time;
	}
	public static void evenArray() {
	int[] hundredArray = new int[100]; //creates array length 100
	for(int i = 0; i < hundredArray.length; i++) {
	hundredArray[i] = i + 1; //adds 1-100 to array
	}
	for(int i: hundredArray) {
	if(i % 2 == 0) {
	System.out.println(i); //prints number if even number
	}
	}
	}
	public static boolean isPalindrome(String word) { //COMMENT!!
	int c = 0;
	while(c <= word.length()/2) {
	if(word.charAt(c) != word.charAt(word.length() - 1 - c)) {
	return false;
	}
	c++;
	}
	return true;
	}
	public static void palindromeArray() {
	List<String> words = Arrays.asList("karan","madam","tom","civic","radar","jimmy","kayak","john","refer","billy","did");
	ArrayList<String> wordsList = new ArrayList<>(); // creates new ArrayList for given words
	wordsList.addAll(words); // adds all words from List words to ArrayList wordsList
	ArrayList<String> palindromes = new ArrayList<String>(); // creates new ArrayList for palindromes
	for(String i:words) {
	if(isPalindrome(i)) { // checks if word is palindrome
	palindromes.add(i); // adds word to palindrome ArrayList if true
	}
	}
	for(String i:palindromes) {
	System.out.println(i); // prints list element
	}
	}

	//should probably create a isPrime method since another question deals with prime
	public static boolean isPrime(int num) { //COMMENT!!
	if (num <= 1) {
	return false;
	}
	int i = 2;
	while(i < num) {
	if(num % i == 0) {
	return false;
	}
	i++;
	}
	return true;
	}
	public static void primeNums() {
	ArrayList<Integer> hundredArray = new ArrayList<Integer>(); // creates new Array List
	for(int i = 0; i < 100; i++) {
	hundredArray.add(i+1); // adds 1-100 to ArrayList
	}
	for(int i:hundredArray) {
	if(isPrime(i)) { // calls isPrime method
	System.out.println(i); // prints out number if prime
	}

	}
	}
	public static int nFactorial(int n) {
	int result = 1;
	int c = 0;// counter
	if(n == 0) {
	result = result; // 0! = 1
	}
	else if(n > 0) {
	while(c != n) { // for numbers > 0, multiply (n-c) result by previous result
	result *= (n - c);
	c++; // increment c until c = n
	}
	}
	return result;
	}
	public static void fibonacci25() {
	int[] fibArray = new int[25]; // creates array length 25
	fibArray[0] = 0;
	fibArray[1] = 1;
	for(int i = 2; i < 25; i++) { // definition of Fibonacci: x_n = x_(n-1)+x_(n-2)
	fibArray[i] = fibArray[i-1] + fibArray[i-2];
	}
	for(int i:fibArray) {
	System.out.println(i);// prints out array elements
	}
	}
	public static void triangle() {

	}

	public static void switchDemo(int num) { // COMMENT!!
	switch(num) {
	case 1:
	Scanner number = new Scanner(System.in);
	System.out.println("Enter a number to evaluate its square root.");
	double x = number.nextDouble();
	System.out.println(Math.sqrt(x));
	break;
	case 2:
	Date date = new Date();
	System.out.println(date);
	break;
	case 3:
	String str = "I am learning Core Java";
	String[] strArray = str.split(" ");
	for(String i:strArray) {
	System.out.println(i);
	}
	break;
	default:
	System.out.println("This is not one of the cases.");
	}
	}
	public static String subString(String str, int idx) { // COMMENT!!
	String finalStr = " ";
	int i = 0;
	while(i <= idx-1) {
	finalStr += str.charAt(i);
	i++;
	}
	return finalStr;
	}
	public static String reverseString(String str) { // COMMENT!!
	String finalStr = " ";
	for(int i = str.length()-1; i >= 0; i--) {
	finalStr += str.charAt(i);
	}
	return finalStr;
	}
	public static void numbers() { // COMMENT!!
	ArrayList<Integer> tenArray = new ArrayList<Integer>();
	for(int i = 0; i < 10; i++) {
	tenArray.add(i+1); //adds 1-10 to ArrayList
	}
	int evenSum = 0;
	int oddSum = 0;
	for(int i:tenArray) {
	System.out.println(i);
	if(i%2 == 0) {
	evenSum += i;
	}
	else if(i%2 != 0) {
	oddSum += i;
	}
	}
	System.out.println("The sum of all even numbers is " + evenSum + ".");
	System.out.println("The sum of all odd numbers is " + oddSum + ".");

	for(int i = 0; i < tenArray.size(); i++) {
	if(isPrime(tenArray.get(i))) {
	tenArray.remove(new Integer(tenArray.get(i)));
	}
	}
	for(int i:tenArray) {
	System.out.println(i);
	}
	}
	public static void diffPackage() {

	}






	}












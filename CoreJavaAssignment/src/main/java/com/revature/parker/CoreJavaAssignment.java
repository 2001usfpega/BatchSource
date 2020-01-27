package com.revature.parker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.revature.floats.Floats;

public class CoreJavaAssignment {

    // Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
    static void bubbleSort(int... nums) {
        for (int i = 0; i < nums.length; i++) { //Go through each index in the array
            for (int j = i; j < nums.length - 1; j++) { //Go through the current index to the end of the array
                int left = nums[j];
                int right = nums[j + 1];

                if (left > right) { //If the left index is greater than the right index, flip them
                    nums[j] = right;
                    nums[j + 1] = left;
                }
            }
        }
    }

    // Write a program to display the first 25 Fibonacci numbers beginning at 0.
    static String fibonacci() {
        int addend1 = 0;
        int addend2 = 1;
        StringBuilder builder = new StringBuilder(addend1 + " " + addend2);

        for (int i = 0; i < 25; i++) {
            int sum = addend1 + addend2;

            builder.append(" ").append(sum);
            addend1 = addend2;
            addend2 = sum;
        }

        return builder.toString();
    }

    // Reverse a string without using a temporary variable. Do NOT use reverse() in
    // the StringBuffer or the StringBuilder APIs.
    static String reverse(String str) {
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {//Counting down from the last character in the string, add each char to reverse
            reverse += str.charAt(i);
        }

        return reverse;
    }

    // Write a program to compute N factorial.
    static int factorial(int n) {
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    // Write a substring method that accepts a string str and an integer idx and
    // returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
    // of the existing substring methods in the String, StringBuilder, or
    // StringBuffer APIs.
    static String substring(String str, int idx) {
        String sub = "";

        for (int i = 0; i < idx && str.length() >= i; i++) { //from 0 to the supplied index or end of the string, add each character to sub
            sub += str.charAt(i);
        }

        return sub;
    }

    // Write a program to determine if an integer is even without using the modulus
    // operator (%)
    static boolean isEven(int n) {
        return (n & 1) == 0; //If the first bit is 0, it's even
    }

    // Sort two employees based on their name, department, and age using the
    // Comparator interface
    static List<Employee> sort(List<Employee> employees) {
        employees.sort((o1, o2) -> {
            int compare;

            if ((compare = o1.name.compareTo(o2.name)) != 0) { //Compare names
                return compare;
            }

            if ((compare = o1.department.compareTo(o2.department)) != 0) { //Compare departments
                return compare;
            }

            return Integer.compare(o1.age, o2.age); //Compare ages
        });
        return employees;
    }

    /**
     * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
     * "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"
     */
    static List<String> palindromes(List<String> list) {
        List<String> palindromes = new ArrayList<>(list.size());

        list.forEach(string -> {
            if (string.equalsIgnoreCase(reverse(string))) { //If the reversed string is equal to the original, add it to the palindromes list
                palindromes.add(string);
            }
        });

        return palindromes;
    }

    // Create an ArrayList which stores numbers from 1 to 100 and prints out all the
    // prime numbers to the console.
    static List<Integer> primes() {
        List<Integer> primes = new ArrayList<>();

        begin:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i / 2 + 1; j++) { //From 2 to half of the number, check if it's divisible, if not - add to primes list
                if (i % j == 0) {
                    continue begin;
                }
            }
            primes.add(i);
        }

        System.out.println(primes);
        return primes;
    }

    // Find the minimum of two numbers using ternary operators.
    static int min(int n1, int n2) {
        return n1 > n2 ? n2 : n1;
    }

    // Write a program that would access two float-variables from a class that
    // exists in another package. Note, you will need to create two packages to
    // demonstrate the solution.
    static float floats() {
        return Floats.FLOAT1 + Floats.FLOAT2;
    }

    // Write a program to store numbers from 1 to 100 in an array. Print out all the
    // even numbers from the array. Use the enhanced FOR loop for printing out the
    // numbers.
    static void even100() {
        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        for (int n : nums) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
    }

    //	Display the triangle on the console as follows using any type of loop.
//  Do NOT use a simple group of print statements to accomplish this.
//	0
//	1 0
//	1 0 1
//	0 1 0 1
    static void triangle() {
        for (int i = 0; i < 4; i++) { //4 rows
            boolean start1 = i == 1 || i == 2; // If the line starts with 1

            for (int j = 0; j <= i; j++) {
                System.out.print((start1 ? 1 : 0) + " "); // print 1 or 0
                start1 = !start1; //flip the boolean so the next number is 1 or 0
            }
            System.out.println();
        }
    }

    /*
     * Write a program that demonstrates the switch case. Implement the following
     * functionalities in the cases:java Case 1: Find the square root of a number
     * using the Math class method. Case 2: Display today�s date. Case 3: Split the
     * following string and store it in a string array. �I am learning Core Java�
     */
    static double switches(int c) {
        switch (c) {
        case 1:
            return Math.sqrt(c);
        case 2:
            System.out.println(new Date());
            break;
        case 3:
            String[] split = "I am learning Core Java".split(" ");
            System.out.println(Arrays.toString(split));
        }
        return c;
    }

    // Write a program that defines an interface having the following methods:
    // addition, subtraction, multiplication, and division. Create a class that
    // implements this interface and provides appropriate functionality to carry out
    // the required operations. Hard code two operands in a test class having a main
    // method that calls the implementing class.
    static void maths() {
        Maths maths = new Maths() {

            @Override
            public void add() {
                System.out.println(153 + 35235);
            }

            @Override
            public void subtraction() {
                System.out.println(8076 - 9887);
            }

            @Override
            public void multiplication() {
                System.out.println(537 * 3525235);
            }

            @Override
            public void division() {
                System.out.println(734673 / 5256);
            }
        };

        maths.add();
        maths.subtraction();
        maths.multiplication();
        maths.division();
    }

    // Write a program to display the number of characters for a string input. The
    // string should be entered as a command line argument using (String [ ] args).
    static int characters(String... strings) {
        int count = 0;

        for (String string : strings) {
            count += string.length();
        }

        System.out.println(count + " characters");
        return count;
    }

    // Write a program that calculates the simple interest on the principal, rate of
    // interest and number of years provided by the user. Enter principal, rate and
    // time through the console using the Scanner class.
    // Interest = Principal* Rate* Time
    static double interest() {
        Scanner scanner = new Scanner(System.in);
        double interest = 1;

        System.out.print("Enter the principal: ");

        interest *= scanner.nextDouble();

        System.out.print("Enter the rate of interest: ");

        interest *= scanner.nextDouble();

        System.out.print("Enter the years: ");

        interest *= scanner.nextDouble();

        System.out.println("Your interest is " + interest);
        return interest;
    }

    //	Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.
//  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
//
//		1. Check for uppercase characters in a string, and return �true� or �false� depending if any are found.
//		2. Convert all of the lower case characters to uppercase in the input string, and return the result.
//		3. Convert the input string to integer and add 10, output the result to the console.
//		Create an appropriate class having a main method to test the above setup.
    static void strings() {
        Parent abstr = new Sub();

        System.out.println(abstr.checkUppercase("test"));
        System.out.println(abstr.checkUppercase("teSt"));
        System.out.println(abstr.uppercase("string"));
        abstr.add10("35325");
    }

    // Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
    // Add all the even numbers up and display the result. Add all the odd numbers
    // up and display the result. Remove the prime numbers from the ArrayList and
    // print out the remaining ArrayList.
    static List<Integer> primes10() {
        List<Integer> ints = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ints.add(i);
        }

        System.out.println(ints);

        int evenTotal = 0;
        int oddTotal = 0;

        for (int num : ints) {
            if (num % 2 == 0) {
                evenTotal += num;
            } else {
                oddTotal += num;
            }
        }

        System.out.println("Even numbers total: " + evenTotal);
        System.out.println("Odd numbers total: " + oddTotal);

        ints.removeIf(num -> {
            if (num == 1) {
                return false;
            }

            for (int j = 2; j < num / 2 + 1; j++) {
                if (num % j == 0) {
                    return false;
                }
            }
            return true;
        });

        System.out.println(ints);
        return ints;
    }

    //	Create a notepad file called Data.txt and enter the following:
//		Mickey:Mouse:35:Arizona
//		Hulk:Hogan:50:Virginia
//		Roger:Rabbit:22:California
//		Wonder:Woman:18:Montana
//
//		Write a program that would read from the file and print it out to the screen in the following format:
//
//		Name: Mickey Mouse
//		Age: 35 years
//		State: Arizona State
    static void data() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(":");

                System.out.println("Name: " + split[0] + " " + split[1]);
                System.out.println("Age: " + split[2] + " years");
                System.out.println("State: " + split[3] + " State");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
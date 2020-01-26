package com.revature.q10;

public class MyClassFloat {
 static float num1=14; // i have declare two static variable , that way can be access for any other class whiting the program
 static float num2=23;
 
 
 
public static float getNum1() {
	return num1;
}
public static void setNum1(float num1) {
	MyClassFloat.num1 = num1;
}
public static float getNum2() {
	return num2;
}
public static void setNum2(float num2) {
	MyClassFloat.num2 = num2;
}
 
}

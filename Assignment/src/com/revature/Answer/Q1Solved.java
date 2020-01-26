package com.revature.Answer;



public  class Q1Solved {
	
	 public static  int[] bubbleSort( int[] array) {
		 int temp;// is a variable to store the current value in one position of my array
		 
		 while (true) {
			 boolean isTrue=false;// i declare a boolean  variable to know when i have to get out of the while statement

			for(int i=1; i<array.length;i++) {//this is a loop to go  my array 
				if(array[i]<array[i-1]) {//if statement is to compare two position of the array an see witch one is smaller than other
				  temp=array[i]; // and we switch those value organizing then upward
				  array[i]=array[i-1];
				  array[i-1]=temp;
				  isTrue=true;
				}
			}
		      if(isTrue== false) { //when my boolean variable get to this point is because this done organizing
			break;
		}
		 } 
		 return array;
	}

}

package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

    public static void main(String[] args) {

        // give it a size
        // int myArray[] = new int[7];
        // hardcode
        int myOtherArray[] = { 3, 2, 65, 5, 6, 6, 6, 5, 4, 12, 32 };
        // doesn't help
        System.out.println(myOtherArray.toString());
        // Arrays class!
        System.out.println(Arrays.toString(myOtherArray));
        System.out.println(myOtherArray[5]);
        for (int i = 0; i < myOtherArray.length; i++) {
            myOtherArray[i] = myOtherArray[i] * 7;
        }
        System.out.println(Arrays.toString(myOtherArray));
        for (int i : myOtherArray) {
            System.out.println(i);
        }
    }

}

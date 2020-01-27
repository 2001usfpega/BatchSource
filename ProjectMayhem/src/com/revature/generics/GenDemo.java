package com.revature.generics;

public class GenDemo {

    public static void main(String[] args) {

        // Create a GenOne reference for integers
        GenOne<Integer> i;
        i = new GenOne<Integer>(88);
        i.showType();
        // Get value of i
        int v = i.getOb();
        System.out.println("value: " + v);
        
        GenOne<String> s = new GenOne<String>("Generics Test");
        s.showType();
        String str = s.getOb();
        System.out.println("Value: " +str);
    }

}

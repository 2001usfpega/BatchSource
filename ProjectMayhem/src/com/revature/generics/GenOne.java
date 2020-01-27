package com.revature.generics;

public class GenOne <T> {
    
    /*
     * Generics
     * uses type as a parameter
     * write code that can handle diff types of objects
     * use angle brackets to denote that somethin is generic
     * allows us to ensure type safety
     * adds stability and reusability to our code
     * 
     */

    //Declare an object of type T
    T ob;
    //pass the constructor a reference to the object of type T
    GenOne(T o){
        ob =o;
        
    }
    //getter
    T getOb() {
        return ob;
    }
    //show the type of T
    void showType(){
        System.out.println("Type of T is: "+ ob.getClass().getName());
    }
}

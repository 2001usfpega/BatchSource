package com.revature.classtypes;

public class Shark extends Fish implements Hunt{

    @Override
    public void findPrey() {

        System.out.println("I ate fishees!");
    }

    @Override
    public void swim() {
        System.out.println("I swim in water and i'm terrifying.");
        
    }

    @Override
    public void breathe() {
       System.out.println("I breathe underwater, meeeeegh.");
        
    }
    

}

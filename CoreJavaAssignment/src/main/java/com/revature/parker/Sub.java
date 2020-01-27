package com.revature.parker;

public class Sub extends Parent {

    @Override
    boolean checkUppercase(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    @Override
    String uppercase(String string) {
        return string.toUpperCase();
    }

    @Override
    void add10(String input) {
        System.out.println(Integer.parseInt(input) + 10);
    }
}
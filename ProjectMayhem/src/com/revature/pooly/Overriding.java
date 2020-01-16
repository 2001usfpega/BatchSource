package com.revature.pooly;

public class Overriding {
/*overriding methods
 * parents-child class relationship	
 * methods have same signature(modifiers, name, parameters and any exception)
 * before java 1.5 , had to have the same return type
 * after 1.5 co-variant return type(inheritance chain)
 * parent must have higher level object than child
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Mammal m=new Mammal();
      //  m.eat();
        Pitbul p=new Pitbul();
       // p.eat();
        p.eat1();
        p.str="woo";
        p=new Pitbul();
        System.out.println(p.str);
	}

}

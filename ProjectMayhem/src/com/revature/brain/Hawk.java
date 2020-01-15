package com.revature.brain;

<<<<<<< HEAD
class Raptor extends Bird{
	static {System.out.println("R1");}
	
	public Raptor() {
		System.out.println("R2");
	}
	
	{ System.out.println("R3"); }
	
	static {System.out.println("R4");}
}

class Bird {
	{ System.out.println("b1"); }
	
	Bird(){
		System.out.println("b2");
	}
	
	static {System.out.println("b3");}
}

public class Hawk extends Raptor{
	public static void main(String[] args) {
		System.out.println("init");
		new Hawk();
		System.out.println("hawk");
	}
	
	public Hawk() {
		
	}
}

=======
class Bird{
    { System.out.println("b1"); } 
    Bird() {
   	 System.out.println("b2");
    }

    static { System.out.println("b3");  }  	 
}

class Raptor extends Bird {
    static { System.out.println("r1"); }
    
    public Raptor() {
   	 System.out.println("r2");
    }

    { System.out.println("r3"); }
    
    static { System.out.println("r4"); }
}
public class Hawk extends Raptor {

    public static void main(String[] args) {
   	 System.out.println("init");
   	 new Hawk();
   	 //new Hawk();
   	 System.out.println("hawk");
    }

    public Hawk() {
    }
}
>>>>>>> 82c807fee5556a70981fad981eefcd9f0edaf1f8

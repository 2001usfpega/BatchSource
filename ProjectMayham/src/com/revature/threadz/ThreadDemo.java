package com.revature.threadz;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread extendThread= new ExtendThread();
		Thread inpRun= new Thread(new ImpRunable());
		inpRun.setPriority(10);
		
		extendThread.start();
		inpRun.start();
		

		for(int i=0;i<100;i++) {
			System.out.println("Yeehaw - Driver");
		}
		

	}

}

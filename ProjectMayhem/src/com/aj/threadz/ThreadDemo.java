package com.aj.threadz;

public class ThreadDemo {
	
	/*
	 * Two ways to spin up a thread
	 * 1. Extend Thread class and override run()
	 * 2. Implement Runnable and override run()
	 */
	public static void main(String[] saraLance) {
		Thread extendThread = new ExtendThread();
		Thread running = new Thread(new ImplementRunnable());
		
		extendThread.setPriority(10);
		extendThread.start();
		running.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Yeehaw");
		}
	}
}

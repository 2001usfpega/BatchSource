package com.aj.threadz;

public class ImplementRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("\t\t\t\tWhat UP - ImplementRunnable");
		}
		
	}

}

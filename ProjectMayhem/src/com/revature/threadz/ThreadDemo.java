package com.revature.threadz;

public class ThreadDemo 
{

	public static void main(String[] args) 
	{
		Thread extendThread = new ExtendsThread();
		Thread implementRunnable = new Thread(new ImplementRunnable());
		implementRunnable.setPriorty(10);
		extendThread.start();
		implementRunnable.start();
			for(int i = 0; i < 100; i++) 
			{
			System.out.println("Yeehaw-Driver");
			}

	}

}

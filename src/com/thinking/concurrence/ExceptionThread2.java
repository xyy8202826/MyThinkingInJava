package com.thinking.concurrence;

public class ExceptionThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println( Thread.currentThread().getName() +" was cread");
		throw new RuntimeException();
		
	}

}

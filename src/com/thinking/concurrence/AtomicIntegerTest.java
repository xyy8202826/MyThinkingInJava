package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
	private AtomicInteger i=new AtomicInteger();
	public int getValue(){
		return i.get();
	}
	
	private synchronized void evenIncrement(){
		i.addAndGet(2);
	}

	@Override
	public void run() {

		while(true){
			evenIncrement();
		}
	}
	public static void main(String[] args) {
		ExecutorService exes=Executors.newCachedThreadPool();
		AtomicIntegerTest at=new AtomicIntegerTest();
		exes.execute(at);
		while(true){
			int b=at.getValue();
			if(b%2!=0){
				System.out.println(b);
				System.exit(0);
			}
		}
	}

}

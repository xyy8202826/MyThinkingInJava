package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	private int i=0;
	public int getValue(){
		return i;
	}
	
	private synchronized void evenIncrement(){
		i++;
		i++;
	}

	@Override
	public void run() {

		while(true){
			evenIncrement();
		}
	}
	public static void main(String[] args) {
		ExecutorService exes=Executors.newCachedThreadPool();
		AtomicityTest at=new AtomicityTest();
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

package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

	@Override
	public void run() {
		while(countDown-- >0){
			System.out.println(status());
			try {
				//old style
				//Thread.sleep(100);
				//java SE5+
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		ExecutorService excutor=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			excutor.execute(new Thread(new SleepingTask()));
		}
		excutor.shutdown();
	}

}

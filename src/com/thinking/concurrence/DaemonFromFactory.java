package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

	@Override
	public void run() {
		  while(true){
	    	  try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	  
	      }

	}
	public static void main(String[] args) throws Exception {
		ExecutorService excutor=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<5;i++){
			excutor.execute(new DaemonFromFactory());
		}
		System.out.println("all Thread has started");
		TimeUnit.MILLISECONDS.sleep(200);
		excutor.shutdown();
	}

}

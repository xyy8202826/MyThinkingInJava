package com.thinking.concurrence;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
      while(true){
    	  try {
			TimeUnit.MILLISECONDS.sleep(10);
			System.out.println(Thread.currentThread()+" "+this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	  
      }
	}

	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			Thread  daemon=new Thread( new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("all Thread has started");
		TimeUnit.MILLISECONDS.sleep(200);

	}

}

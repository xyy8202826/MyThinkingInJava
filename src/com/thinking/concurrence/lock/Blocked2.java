package com.thinking.concurrence.lock;

import java.util.concurrent.TimeUnit;

public class Blocked2 implements Runnable{
	private volatile double d=0.0;

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
				NeedCleanup n1=new NeedCleanup(1);
				try{
					System.out.println("sleep");
					TimeUnit.SECONDS.sleep(1);
					NeedCleanup n2=new NeedCleanup(2);
					try{
						System.out.println("Calculating");
						for(int i=1;i<250000;i++){
							d=d+(Math.PI+Math.E)/d;
						}
						System.out.println("finished time_consuming operation");
						
					}finally{
						n2.cleanup();
					}
				}finally{
					n1.cleanup();
				}
			}
			System.out.println("exiting while()");
		} catch (Exception e) {
			System.out.println(" exiting via interrupedException");
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Thread t=new Thread(new Blocked2() );
		t.start();
		TimeUnit.MILLISECONDS.sleep(1000);
		t.interrupt();

	}

}

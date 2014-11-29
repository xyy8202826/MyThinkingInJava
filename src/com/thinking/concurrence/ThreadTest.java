package com.thinking.concurrence;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
	public static void main(String[] args) {
		/*for(int i=0;i<5;i++){
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff");*/
		Thread t=	new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("i="+i);
					System.out.println("this.interrupted()= "+Thread.interrupted());
					if(i==60){
						this.interrupt();
						if(!Thread.interrupted()){
							try {
								TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
							return;
						}
						}
						
					}
				}
			}
		};
		t.start();
	}

}

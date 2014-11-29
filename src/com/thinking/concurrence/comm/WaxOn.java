package com.thinking.concurrence.comm;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {
	private Car car;
	public WaxOn(Car car){
		this.car=car;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
				System.out.println(" WaxOn ");
				TimeUnit.SECONDS.sleep(1);
				car.waxed();
				car.waitForBuffering();
			}
			
		} catch (Exception e) {
			System.out.println("interrupted");
		}
System.out.println("end waxon task");
	}

}

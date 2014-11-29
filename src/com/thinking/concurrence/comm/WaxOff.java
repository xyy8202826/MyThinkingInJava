package com.thinking.concurrence.comm;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;
	public WaxOff(Car car){
		this.car=car;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println(" WaxOff ");
				TimeUnit.SECONDS.sleep(1);
				car.buffed();
			}
			
		} catch (Exception e) {
			System.out.println("interrupted");
		}
                   System.out.println("end waxoff task");
	}

}

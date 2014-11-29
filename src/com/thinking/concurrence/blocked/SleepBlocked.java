package com.thinking.concurrence.blocked;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(" is interrupted "+Thread.interrupted());
			e.printStackTrace();
		}
		System.out.println(" Exiting SleepBlocked.run()");

	}

}

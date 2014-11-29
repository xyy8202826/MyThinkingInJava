package com.thinking.concurrence.comm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMtic {

	public static void main(String[] args) throws Exception {
		Car car=new Car();
		 ExecutorService exes=Executors.newCachedThreadPool(); 
		 exes.execute(new WaxOn(car));
		 exes.execute(new WaxOff(car));
		 TimeUnit.SECONDS.sleep(10);
		 exes.shutdownNow();

	}

}

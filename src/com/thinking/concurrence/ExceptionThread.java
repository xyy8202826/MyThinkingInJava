package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();

	}
	public static void main(String[] args) {
		//new Thread(new ExceptionThread()).start();
		ExecutorService exes=Executors.newCachedThreadPool();
		exes.execute(new ExceptionThread());
		exes.shutdown();
	}

}

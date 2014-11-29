package com.thinking.concurrence.blocked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Iterrupting {
	private static ExecutorService exes=Executors.newCachedThreadPool();
	static void test(Runnable r) throws InterruptedException{
		Future<?> future=exes.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println(" Iterrupting "+r.getClass().getName());
		future.cancel(true);
		System.out.println(" interrupt send to "+r.getClass().getName());
	}

	public static void main(String[] args) throws Exception {
		//test(new SleepBlocked());
		//test(new IoBlocked(System.in));//IO操作不会被打断
		test(new SynchronizedBlocked());
		TimeUnit.MILLISECONDS.sleep(3000);
		System.out.println(" Aborting with System.exit(0)");
		System.exit(0);

	}

}

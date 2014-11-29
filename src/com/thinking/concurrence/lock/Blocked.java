package com.thinking.concurrence.lock;

import java.util.concurrent.TimeUnit;

public class Blocked implements Runnable {
	BlockedMutex blockedMutex=new BlockedMutex();
	@Override
	public void run() {
		System.out.println(" waiting for f()");
		blockedMutex.f();
		System.out.println(" broken out of blocked call");

	}
	public static void main(String[] args) throws Exception {
		Thread t=new Thread( new Blocked());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(" issuing t.interrupt()");
		t.interrupt();
	}

}

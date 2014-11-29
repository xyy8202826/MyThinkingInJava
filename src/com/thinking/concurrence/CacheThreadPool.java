package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {

	public static void main(String[] args) {
		ExecutorService excutor=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			excutor.execute(new Thread(new LiftOff()));
		}
		excutor.shutdown();
	}

}

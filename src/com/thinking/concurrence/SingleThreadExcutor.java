package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExcutor {

	public static void main(String[] args) {
		ExecutorService excutor=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			excutor.execute(new Thread(new LiftOff()));
		}
		excutor.shutdown();
	}

}

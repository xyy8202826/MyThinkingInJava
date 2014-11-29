package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exes=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exes.execute(new Entrance(i) );
		}
		TimeUnit.SECONDS.sleep(4);
		Entrance.cancel();
		exes.shutdown();
		if(!exes.awaitTermination(250, TimeUnit.MILLISECONDS)){
			System.out.println(" some task were not end");
		}
		System.out.println("Total: "+Entrance.getTotal());
		System.out.println(" sum of Entrance :"+Entrance.sumEntrances());
	}

}

package com.thinking.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CiticalSection {
	static void testApproaches(PairManager pman1,PairManager pman2){
		ExecutorService exes=Executors.newCachedThreadPool();
		PairManipulator 
			pm1=new PairManipulator(pman1),
			pm2= new PairManipulator(pman2);
		PairChecker 
			pcheck1=new PairChecker(pman1),
			pcheck2=new PairChecker(pman2);
		exes.execute(pm1);
		exes.execute(pm2);
		exes.execute(pcheck1);
		exes.execute(pcheck2);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(" Sleep interrupted");
		}
		System.out.println("pm1:"+ pm1+"\n pm2:"+pm2);
		System.exit(0);
	}

	public static void main(String[] args) {
		PairManager pman1=new PairManager1();
		PairManager pman2=new PairManager2();
		testApproaches(pman1, pman2);

	}

}

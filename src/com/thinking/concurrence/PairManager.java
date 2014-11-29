package com.thinking.concurrence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManager {
	AtomicInteger checkCounter=new AtomicInteger(0);
	protected Pair pair=new Pair();
	private List<Pair> storage=Collections.synchronizedList(new ArrayList<Pair>());
	public synchronized Pair getPair(){
		return new Pair(pair.getX(),pair.getY());
	}
	protected void store(Pair p){
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		
	}
	public abstract void  increment();

}

package com.thinking.concurrence;

public class PairManager1 extends PairManager {

	@Override
	public synchronized void increment() {
		pair.incrementX();
		pair.incrementY();
		store(getPair());

	}

}

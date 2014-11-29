package com.thinking.concurrence;

public class PairManipulator implements Runnable {
	private PairManager pm;
	public PairManipulator(PairManager pm){
		this.pm=pm;
	}

	@Override
	public void run() {
		while(true){
			pm.increment();
		}

	}
	public String toString(){
		return "Pair "+pm.getPair()+" checkConuter="+ pm.checkCounter.get();
	}

}

package com.thinking.concurrence;

public class Joiner extends Thread {
	private Sleeper sleeper;
	public Joiner(Sleeper sleeper,String name){
		super(name);
		this.sleeper=sleeper;
		this.start();
	}
	public void run(){
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("interrupted ");
		}
		System.out.println(this.getName()+" join completed");
	}

}

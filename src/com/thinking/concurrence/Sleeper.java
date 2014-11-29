package com.thinking.concurrence;

public class Sleeper extends Thread {
	private int duration;
	public Sleeper(String name,int sleepTime){
		super(name);
		this.duration=sleepTime;
		this.start();
	}
	@Override
	public void run(){
		try {
			sleep(duration);
		} catch (InterruptedException e ) {
			System.out.println(this.getName()+" was interrupted  " + this.isInterrupted());
			return;
		}
		System.out.println(this.getName()+" has awakened");
	}

}

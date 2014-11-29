package com.thinking.concurrence;
public class Count {
	private int count=0;
	public synchronized int increment(){
		int temp=0;
		return temp=++count;
	}
	
	public synchronized int getValue(){
		return count;
	}

}

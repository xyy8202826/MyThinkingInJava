package com.thinking.concurrence.lock;

public class NeedCleanup {
	final int id;
	public NeedCleanup(int id){
		this.id=id;
		System.out.println("needsCleanup "+id);
	}
	public void cleanup(){
		System.out.println("cleanup "+id);
	}

}

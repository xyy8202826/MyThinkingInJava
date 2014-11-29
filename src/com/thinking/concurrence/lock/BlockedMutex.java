package com.thinking.concurrence.lock;

import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex{
	
	private ReentrantLock lock=new ReentrantLock();
	public BlockedMutex(){
		lock.lock();
	}

	public void f() {
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			System.out.println("interrupted from lock acquisition in f()");
		}

	}

}

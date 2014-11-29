package com.thinking.concurrence.lock;

public class MutiLock {
	
	public synchronized void f1(int count ){
		
		if(count-- >0){
			System.out.println(" f1() call f2() with count:"+count);
			f2(count);
		}
		
	}
    public synchronized void f2(int count ){
		
		if(count-- >0){
			System.out.println(" f2() call f1() with count:"+count);
			f1(count);
		}
		
	}
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				new MutiLock().f1(10);
			}
			
		}.start();

	}

}

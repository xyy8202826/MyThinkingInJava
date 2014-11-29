package com.thinking.innerclass;

public class Callee extends MyIncrementable {
	private int i=0;
	@Override
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	
	public Incrementable getCallBack(){
		return new Incrementable(){
			@Override
			public Incrementable increment() {
				Callee.this.increment();
				return this;
			}
			
		};
	}

}

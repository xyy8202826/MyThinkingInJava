package com.thinking.innerclass;

public class Main {

	public static void main(String[] args) {
		Incrementable incrementable=new Callee().getCallBack();
		incrementable.increment().increment().increment();
	}

}

package com.thinking.concurrence;

public class Joining {

	public static void main(String[] args) {
		Sleeper sleepy=new Sleeper("sleepy",2000),
				grumpy=new Sleeper("grumpy",2000);
		Joiner dopey=new Joiner(sleepy,"dopey"),
				doc=new Joiner(grumpy,"doc");
		grumpy.interrupt();

	}

}

package com.thinking.concurrence.blocked;

import java.io.IOException;
import java.io.InputStream;

public class IoBlocked implements Runnable {
	private InputStream is=null;
	public IoBlocked(InputStream is){
		this.is=is;
	}
	@Override
	public void run() {
		try {
			System.out.println("wait for read");
			is.read();
		} catch (IOException e) {
			if(Thread.interrupted()){
				System.out.println("Interrupted from blocked I/O ");
				
			}else{
				throw new RuntimeException();
			}
		}finally{
			try {
				if(is!=null)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(" exiting IoBlocked.run()");

	}

}

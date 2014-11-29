package com.thinking.concurrence.blocked;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {

	public static void main(String[] args) throws Exception {
		ExecutorService exes=Executors.newCachedThreadPool();
		ServerSocket ssk=new ServerSocket(8080);
		InputStream is=new Socket("localhost",8080).getInputStream();
		exes.execute(new IoBlocked(is));
		exes.execute(new IoBlocked(System.in));
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println(" shutdown all Thread");
		exes.shutdownNow();
		TimeUnit.SECONDS.sleep(2);
		System.out.println(" close "+is.getClass().getName());
		is.close();
		TimeUnit.SECONDS.sleep(2);
		System.out.println(" close "+System.in.getClass().getName());
		System.in.close();

	}

}

package com.thinking.concurrence.blocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIOBlocked implements Runnable {
	private final SocketChannel sc;
	public NIOBlocked(SocketChannel sc){
		this.sc=sc;
	}

	@Override
	public void run() {
		System.out.println(" waiting for read()"+this);
		try {
			sc.read(ByteBuffer.allocate(1));
		} catch (ClosedByInterruptException e) {
			System.out.println("ClosedByInterruptException");
		}catch(AsynchronousCloseException ae){
			System.out.println("AsynchronousCloseException");
		}catch(IOException ie){
			throw new RuntimeException();
		}
		System.out.println("exit NIOBlocked.run()"+this);

	}
	public static void main(String[] args) throws Exception {
		 ExecutorService exes=Executors.newCachedThreadPool();
		 ServerSocket ss=new ServerSocket(8080);
		 InetSocketAddress iA=new InetSocketAddress("localhost",8080);
		 SocketChannel sc1=SocketChannel.open(iA);
		 SocketChannel sc2=SocketChannel.open(iA);
		 Future<?> future= exes.submit(new NIOBlocked(sc1));
		 exes.execute(new NIOBlocked(sc2));
		exes.shutdownNow();
		 TimeUnit.SECONDS.sleep(1);
		 future.cancel(true);
		 TimeUnit.SECONDS.sleep(1);
		//sc2.close();
	}

}

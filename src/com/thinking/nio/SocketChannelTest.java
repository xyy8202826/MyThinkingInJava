package com.thinking.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {
	
	public static void main(String[] args) throws Exception {
		SocketChannel socketChannel=SocketChannel.open();
		socketChannel.connect(new InetSocketAddress(8080));
		socketChannel.write(ByteBuffer.wrap("¹þ¹þ¹þ".getBytes("UTF-8")));
		while(true){
			ByteBuffer buffer=ByteBuffer.allocate(1024);
			int count=socketChannel.read(buffer);
			if(count>0){
			    buffer.flip();
			    byte [] dst=new byte[buffer.limit()];
			    buffer.get(dst);
			    System.out.println(new String(dst,"UTF-8"));
			}
		}
		//socketChannel.close();
	}

}

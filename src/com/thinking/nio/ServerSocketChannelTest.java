package com.thinking.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {

	public static void main(String[] args) throws Exception {
		ServerSocketChannel serverSocketChannel =ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress(8080));
		while(true){  
		    SocketChannel socketChannel =  
		            serverSocketChannel.accept(); 
		    ByteBuffer buffer=ByteBuffer.allocate(1024);
		    socketChannel.read(buffer);
		    buffer.flip();
		    byte [] dst=new byte[buffer.limit()];
		    buffer.get(dst);
		    String str=new String(dst,"UTF-8");
		    System.out.println(str);
		    socketChannel.write(ByteBuffer.wrap(("收到你的消息："+str).getBytes("UTF-8")));
		}

	}

}

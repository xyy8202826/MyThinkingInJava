package com.thinking.io;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

	public static void main(String[] args) throws Exception {
		//System.getProperties().setProperty("sun.jnu.encoding", "UTF-8");
		//System.out.println(System.getProperties().getProperty("sun.jnu.encoding"));
		FileChannel fc=new FileOutputStream("a.txt").getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		fc.write(ByteBuffer.wrap("込込".getBytes("UTF-8")));
		fc.position(0);
		fc.write(ByteBuffer.wrap("最最".getBytes("UTF-8")));
		fc.close();
		//System.out.println("込込".getBytes());

	}

}

package com.thinking.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	public static void main(String[] args) throws Exception {
		readFileTest();
		writeFileTest();

	}

	public static void readFileTest() throws Exception {
		FileInputStream fin = new FileInputStream("a.txt");
		// ��ȡͨ��
		FileChannel fc = fin.getChannel();
		// ����������
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// ��ȡ���ݵ�������
		fc.read(buffer);
		buffer.flip();
		/*
		 * while (buffer.remaining()>0) { byte b = buffer.get();
		 * System.out.print(new String()); }
		 */
		byte[] dst = new byte[buffer.limit()];
		buffer.get(dst);
		System.out.print(new String(dst, "UTF-8"));
		fin.close();
	}

	public static void writeFileTest() throws Exception {
		FileOutputStream fout = new FileOutputStream("b.txt");
		FileChannel channel = fout.getChannel();
		channel.write(ByteBuffer.wrap("��������".getBytes("UTF-8")));
		channel.close();
		fout.close();
	}

}

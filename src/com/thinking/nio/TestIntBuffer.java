package com.thinking.nio;

import java.nio.IntBuffer;

public class TestIntBuffer {

	public static void main(String[] args) {
		 // �����µ�int������������Ϊ����������  
        // �»������ĵ�ǰλ�ý�Ϊ�㣬�����(����λ��)��Ϊ����������������һ���ײ�ʵ�����飬������ƫ������Ϊ�㡣 
		IntBuffer intBuffer=IntBuffer.allocate(10);
		
		for(int i=0;i<intBuffer.capacity();i++){
			intBuffer.put(i);
		}
		intBuffer.flip();
		while(intBuffer.hasRemaining()){
			System.out.println(intBuffer.get());
		}

	}

}

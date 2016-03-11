package com.thinking.nio;

import java.nio.IntBuffer;

public class TestIntBuffer {

	public static void main(String[] args) {
		 // 分配新的int缓冲区，参数为缓冲区容量  
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。 
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

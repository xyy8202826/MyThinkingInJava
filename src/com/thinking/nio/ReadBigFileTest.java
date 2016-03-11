package com.thinking.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadBigFileTest {

	public static void main(String[] args) {
		readFileByLine();
	}

	public static void readFileByLine() {
		String enterStr = "\n";
		FileInputStream fin=null;
		FileChannel channel=null;
		try {
			int bufSize = 1024 * 1024;
			fin = new FileInputStream("H:\\readBigFile.txt");
			channel= fin.getChannel();
			ByteBuffer rbuffer = ByteBuffer.allocate(bufSize);
			byte[] bs = new byte[bufSize];
			byte[] tempByteArray = new byte[1024];
			while (channel.read(rbuffer) != -1) {
				int rSize = rbuffer.position();// 获取总长度
				rbuffer.rewind();
				rbuffer.get(bs);
				rbuffer.clear();

				int length = 0;
				int startNum = 0;
				for (int i = 0; i < rSize; i++) {// 获取第一个换行符
					if (bs[i] == 10) {// 遇到换行
						startNum = i;
						for (int j = 0; j < 1024; j++) {
							if (tempByteArray[j] == 0) {
								length = j + i;
								for (int k = 0; k <= i; k++) {
									tempByteArray[j + k] = bs[k];
								}
								break;
							}
						}
						break;
					}
				}
				String tempString1 = new String(tempByteArray, 0, length + 1, "UTF-8");

				// 清空temp数组
				for (int i = 0; i < tempByteArray.length; i++) {
					tempByteArray[i] = 0;
				}

				// 获取最后一个换行符
				int k = 0;
				int endNum = 0;
				for (int i = rSize - 1; i > 0; i--) {
					if (bs[i] == 10) {// 遇到换行
						endNum = i;
						for (int j = i + 1; j < rSize; j++) {
							tempByteArray[k] = bs[j];
							k++;
						}
						break;
					}
				}
				String tempString2 = new String(bs, startNum + 1, endNum - startNum, "UTF-8");
				// 拼接两个字符串
				String tempString = tempString1 + tempString2;
				// System.out.println(tempString);
				int fromIndex = 0;
				int endIndex = 0;
				while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {
					String line = tempString.substring(fromIndex, endIndex) + enterStr;// 按行截取字符串
					System.out.print(line);
					
					fromIndex = endIndex + 1;
				}

			}
			int endLength=0;
			for(int i=0;i<tempByteArray.length;i++){
				if(tempByteArray[i]==0){
					endLength=i;
					break;
				}
			}
			if(endLength>0){
				String str3=new String (tempByteArray,0,endLength,"UTF-8");
				System.out.println(str3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				channel.close();
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

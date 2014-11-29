package com.thinking.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

public class PSPW {
	public static void  inputStreamTest() throws Exception{
		InputStream is=new ByteArrayInputStream("¹þ¹þ".getBytes("UTF-8"));
		InputStream is2=new StringBufferInputStream("¹þ¹þ");
		InputStream is3=new FileInputStream("a.txt");
			while(is3.available()>0){
				System.out.print(is3.read()+":");
		}
			is.close();
			is2.close();
			is3.close();
	}
	
	public static void PrintStreamTest(){
		PrintStream ps=new PrintStream(System.out);
		ps.write(97);
		ps.println("ggg");
		ps.flush();
		ps.close();
	}
	public static void BufferedReaderTest() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		while((str=br.readLine())!=null){
			if("end".equalsIgnoreCase(str)){
				System.out.println("ÍË³ö");
				br.close();
				break;
			}else{
				System.out.println(str);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		//inputStreamTest();
		//PrintStreamTest();
		BufferedReaderTest();

	}

}

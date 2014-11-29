package com.thinking.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
	
	public static void command(String command){
		boolean err=false;
		try {
			Process process=new ProcessBuilder(command.split(" +")).start();
			BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
			String str=null;
			while((str=br.readLine())!=null){
					System.out.println(str);
			}
			BufferedReader errs=new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((str=errs.readLine())!=null){
				System.err.println(str);
				err=true;
		}
		} catch (Exception e) {
		}
		if(err){
			throw new RuntimeException("OSExecuteException");
		}
		
	}

	public static void main(String[] args) {
		command("ipconfig");
	}

}

package com.thinking.concurrence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService excutor=Executors.newCachedThreadPool();
		List<Future<String>> futureList=new ArrayList<Future<String>>();
		for(int i=0;i<5;i++){
			futureList.add(excutor.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs:futureList){
			try {
				if(fs.isDone()){
					System.out.println(fs.get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally{
				excutor.shutdown();
			}
		}
		
	}

}

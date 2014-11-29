package com.thinking.concurrence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {
	private static Count count =new Count();
	private static List<Entrance> entrances=new ArrayList<Entrance>();
	private int number=0;
	private final int id;
	private static volatile boolean cancled=false;
	public static void cancel(){
		cancled=true;
	}
	public Entrance(int id){
		this.id=id;
		entrances.add(this);
	}

	@Override
	public void run() {
		while(!cancled){
				++number;
			System.out.println(this +"Total:"+count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
				e.printStackTrace();
			}
		}
		System.out.println(" stop Entrance "+id+":"+getValue());

	}
	
	public  int getValue(){
		return number;
	}
	public static int getTotal(){
		return count.getValue();
	}
	
	public static int sumEntrances(){
		int sum=0;
		for(Entrance entrance:entrances){
			sum+=entrance.getValue();
		}
		return sum;
	}
	
	public String toString(){
		return " Entrance "+id+":"+getValue();
	}

}

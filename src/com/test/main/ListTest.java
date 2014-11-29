package com.test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class ListTest {
	static List<String> strList=new ArrayList<String>(); 
	static{
		for(int i=0;i<10;i++){
			strList.add(i+"");
		}
	}
	public static void ListIteratorTest(){
		System.out.println("SIZE:"+strList.size());
		ListIterator<String> strListIterator=strList.listIterator();
		while(strListIterator.hasNext()){
			String str=strListIterator.next();
			strListIterator.set("set");
			strListIterator.add("add");
			System.out.println(str);
		}
		System.out.println(strList);
		System.out.println("SIZE:"+strList.size());
	}
public static void main(String[] args) {
	ListIteratorTest();
/*	List<String> strList=new ArrayList<String>(); 
	strList.add("1");strList.add("2");strList.add("3");
	List<String> strList2=new  ArrayList<String>(strList);
	strList2.remove(0);
	System.out.println(strList.size());
	System.out.println(strList2.size());*/
}
}

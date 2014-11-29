package com.thinking.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpTest {
	
	public static void match(){
		int count=0;
		String str="ddddddddddddadadadadadadadadadada";
		Pattern pa=Pattern.compile("ada*");
		System.out.println(pa.pattern());
		Matcher mc=pa.matcher(str);
		while(mc.find()){
			System.out.println(mc.start());
			mc=mc.region(mc.start()+1, str.length());
			count++;
		}
		System.out.println(count);
	}
	public static void group(){
		int count=0;
		String str="a2bbaaaaaddaaaaa2fddd";
		Pattern pa=Pattern.compile("(((a+)\\d+))");
		Matcher mc=pa.matcher(str);
		//System.out.println(mc.groupCount());
		while(mc.find()){
			count++;
			for(int i=0;i<=mc.groupCount();i++){
				System.out.println(mc.group(i));
			}
		}
		System.out.println(count);
		
	}

	public static void main(String[] args) {
		//match();
		group();
	}

}

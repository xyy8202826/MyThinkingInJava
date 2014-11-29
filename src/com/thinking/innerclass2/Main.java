package com.thinking.innerclass2;

import com.thinking.innerclass.OuterClass;
import com.thinking.innerclass.OuterClass.Inner;

public class Main {

	public static void main(String[] args) {
		OuterClass OuterClas=new OuterClass();
		Inner inner=OuterClas.new Inner("");
		System.out.println(inner);
	}

}

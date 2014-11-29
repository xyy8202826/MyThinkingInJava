package com.thinking.innerclass;

public class OuterClass {
	private int i=0;
	public class Inner{
		public Inner(String str){System.out.println(i);}
	}
	
	public AbsInnerClass getInnerAbsInnerClass(){
		return new AbsInnerClass(){

			@Override
			public void print() {
				AbsInnerClass.staticPrint();
				System.out.println("inner Print");
			}
			
		};
	}
	public AbsInnerClass getInnerAbsInnerClass(final String str){
		return new AbsInnerClass(){

			@Override
			public void print() {
				System.out.println(str);
				AbsInnerClass.staticPrint();
				System.out.println("inner Print");
			}
			
		};
	}
	public AbsInnerClass getInnerAbsInnerClass(final String str,final String str2){
		return new AbsInnerClass(){

			@Override
			public void print() {
				System.out.println(str);
				AbsInnerClass.staticPrint();
				System.out.println("inner Print");
			}
			
		};
	}
	public static void main(String[] args) {
		OuterClass OuterClas=new OuterClass();
		Inner inner=OuterClas.new Inner("");
		System.out.println(inner);
		AbsInnerClass absInnerClass=OuterClas.getInnerAbsInnerClass("str");
		absInnerClass.print();
	}

}

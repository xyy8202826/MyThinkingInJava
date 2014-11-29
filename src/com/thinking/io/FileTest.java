package com.thinking.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

public class FileTest {

	public static void main(String[] args) {
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);
		//normalMethod();
		//listMethod();
		//newFile();
		fileNamefilter(".*\\.txt");
	}

	public static void normalMethod() {
		File file = new File(".");
		System.out.println(file.isAbsolute());
		System.out.println(file.getName());
		System.out.println(file.list().length);
		System.out.println(file.getAbsolutePath());
	}

	public static void listMethod() {
		File file = new File(".");
		String[] fileNameArray = file.list();
		for (String str : fileNameArray) {
			System.out.println(str);
		}

	}
	
	public static  void newFile(){
		File file = new File("a.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void fileNamefilter(final String regex){
		File file = new File(".");
		String[] fileNameArray = file.list(new FilenameFilter(){
			private Pattern pattern=Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
			
		});
		for (String str : fileNameArray) {
			System.out.println(str);
		}
	}

}

package com.thinking.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
	public static File[] local(File dir,final String regex){
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern=Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
	}
	public static File[] local(String dirpath,final String regex){
		return local(new File(dirpath),regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		private List<File> fileList=new ArrayList<File>();
		private List<File> dirList=new ArrayList<File>();
		
		public List<File> getFileList() {
			return fileList;
		}

		public void setFileList(List<File> fileList) {
			this.fileList = fileList;
		}

		public List<File> getDirList() {
			return dirList;
		}

		public void setDirList(List<File> dirList) {
			this.dirList = dirList;
		}

		void addAll(TreeInfo other){
			fileList.addAll(other.fileList);
			dirList.addAll(other.dirList);
		}
		
		//递归添加文件和目录
		static TreeInfo resourceDirs(File startDir,String regex){
			TreeInfo result=new TreeInfo();
			if(startDir==null){
				return null;
			}
			for(File file:startDir.listFiles()){
				if(file.isDirectory()){
					result.dirList.add(file);
					result.addAll(resourceDirs(file,regex));
				}else{
					if(file.getName().matches(regex)){
						result.fileList.add(file);
					}
				}
			}
			return result;
		}
		
		@Override
		public Iterator<File> iterator() {
			return fileList.iterator();
		}
		
		public static TreeInfo walk(File file ,String regex){
			return resourceDirs(file,regex);
		}
		
		public static TreeInfo walk(String filePath ,String regex){
			return resourceDirs(new File(filePath),regex);
		}
		
		public static TreeInfo walk(String filePath){
			return resourceDirs(new File(filePath),".*");
		}
		
	}
	
	public static void main(String[] args) {
		TreeInfo treeInfo=TreeInfo.walk(".",".*\\.class");
		System.out.println(treeInfo.getDirList().size());
		System.out.println(treeInfo.getFileList().size());
		for(File file:treeInfo.getDirList()){
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("----------------------------------------");
		for(File file:treeInfo.getFileList()){
			System.out.println(file.getAbsolutePath());
		}
	}

}

package c1_3;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class FileList {
	
	public List<File> getAllFile(String path){
		List<File> fileList=new ArrayList<File>();
		return getAllFile(new File(path),fileList);
	}
	
	public List<File> getAllFile(File file,List<File> fileList){
		//如果文件存在
		if(file.exists()){
			//如果是文件夹
			if(file.isDirectory()){
				File[] f=file.listFiles();//获取文件夹里面的所有文件
				for(File ff:f){//进行递归
					getAllFile(ff, fileList);
				}
			}else{//如果是文件，则加入列表中
				fileList.add(file);
			}
		}
		return fileList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String path=sc.nextLine();
		FileList fileList=new FileList();
		Iterator<File> iterator=fileList.getAllFile(path).iterator();
		while(iterator.hasNext()){
			StdOut.println(iterator.next().getPath());		
		}
	}

}

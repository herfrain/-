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
		//����ļ�����
		if(file.exists()){
			//������ļ���
			if(file.isDirectory()){
				File[] f=file.listFiles();//��ȡ�ļ�������������ļ�
				for(File ff:f){//���еݹ�
					getAllFile(ff, fileList);
				}
			}else{//������ļ���������б���
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

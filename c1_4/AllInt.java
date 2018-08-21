package c1_4;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class AllInt {
	
	public static boolean noZero(int[] a){
		for(int i=0;i<a.length;i++){
			if(a[i]==0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
//		StdOut.println();
		int count=0;
		int[] a=new int[N];
		while(true){
			int r=StdRandom.uniform(0,N);//0~N-1随机数
			count++;
			if(a[r]==0)//若没有记录，则记录
				a[r]++;
			else continue;//若已经记录了，则跳过
			if(noZero(a)) break;//当全部整数都出现了，则退出 
		}
		StdOut.println(count);
	}

}

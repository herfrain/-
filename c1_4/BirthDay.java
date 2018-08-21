package c1_4;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class BirthDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		StdOut.println("~"+Math.sqrt(Math.PI*N/2));
		int C=0;
		for(int i=0;i<N;i++){
			int[] num=new int[N];
			int count=0;//计数
			while(true){
				int r=StdRandom.uniform(0,N);//0~N-1随机数
				num[r]++;
				if(num[r]==2) break;//当出现第一个重复的数，则退出
				count++;
			}
			C+=count;
//			StdOut.println(count);
		}
		StdOut.println("avg:"+C/N);
	
	}

}

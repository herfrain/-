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
			int r=StdRandom.uniform(0,N);//0~N-1�����
			count++;
			if(a[r]==0)//��û�м�¼�����¼
				a[r]++;
			else continue;//���Ѿ���¼�ˣ�������
			if(noZero(a)) break;//��ȫ�������������ˣ����˳� 
		}
		StdOut.println(count);
	}

}

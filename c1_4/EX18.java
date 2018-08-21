package c1_4;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class EX18 {
	
	public static void MinRegion(int[] a,int l,int r){
		int mid=(l+r)/2;
		if(l>r) return;
		if(mid!=0&&mid!=a.length-1&&a[mid]<a[mid+1]&&a[mid]<a[mid-1]){
			StdOut.println(a[mid]);
			return;
		}
		if(mid!=0&&mid!=a.length-1&&a[mid+1]>a[mid-1]){
			MinRegion(a, l, mid-1);
		}else{
			MinRegion(a, mid+1, r);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] a=new int[N];
		for(int i=0;i<N;i++){
			a[i]=StdRandom.uniform(-10, 10);
		}
		for(int i=0;i<N;i++){
			StdOut.print(a[i]+" ");
		}StdOut.println();
		MinRegion(a, 0, a.length-1);
	}

}

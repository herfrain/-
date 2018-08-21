package c1_4;

import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class EX16 {
	public static int access(int[] a){
		int min=Math.abs(a[0]-a[1]);
		for(int i=0;i<a.length-1;i++){
			int m=Math.abs(a[i]-a[i+1]);
			if(m<min) min=m;
		}
		return min;
	}
	
	public static int far(int[] a){
		Arrays.sort(a);
		return Math.abs(a[0]-a[a.length-1]);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] a=new int[N];
		for(int i=0;i<N;i++){
			a[i]=StdRandom.uniform(-10, 10);
		}
		for(int i=0;i<N;i++){
			StdOut.print(a[i]+" ");
		}StdOut.println();
		StdOut.println(access(a));
		
		StdOut.println(far(a));
		for(int i=0;i<N;i++){
			StdOut.print(a[i]+" ");
		}
	}
}

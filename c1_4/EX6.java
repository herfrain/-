package c1_4;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class EX6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int sum=0;
		for(int n=N;n>0;n/=2){
			for(int i=0;i<n;i++){
				sum++;
			}
		}
		StdOut.println(sum);
		
		sum=0;
		for(int i=1;i<N;i*=2){
			for(int j=0;j<i;j++){
				sum++;
			}
		}
		StdOut.println(sum);
		
		sum=0;
		for(int i=1;i<N;i*=2){
			for(int j=0;j<N;j++){
				sum++;
			}
		}
		StdOut.println(sum);
	}

}

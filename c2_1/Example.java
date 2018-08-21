package c2_1;

import c2_2.Merge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Example {
	
	public static void sort(Comparable[] a){
		
	}
	
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	private static void show(Comparable[] a){
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		In in=new In(args[0]);
		double[] a=in.readAllDoubles();//不能用readStrings()
		
		int num=Integer.parseInt(args[1]);
		StdDraw.setXscale(0, num);
		StdDraw.setYscale(-10, 1000);
		for(int i=1;i<num;i++){
			Double[] A=new Double[i];
			for(int j=0;j<i;j++)
				A[j]=(double) StdRandom.uniform(0, 100);
			Merge.sort(A);
//			show(A);
			//与6NlgN比较
			StdOut.print(Merge.N+" "+6*i*Math.log10(i)+" "+(int)(6*i*Math.log10(i)-Merge.N));
			StdOut.println();
			StdDraw.point(i, Merge.N);
		}
		//Insertion.drawSort(A);
		
//		Merge.merge(A, 0,(int)(A.length-1)/2, a.length-1);
		
	}

}

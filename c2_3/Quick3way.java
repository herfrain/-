package c2_3;

import edu.princeton.cs.algs4.StdRandom;


//三向切分的快速排序，适用于重复键多的情况
public class Quick3way {
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);//消除对输入的依赖，对数组随机排序
		sort(a, 0, a.length-1);
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int lt=lo,i=lo+1,gt=hi;
		Comparable v=a[lo];
		while(i<=gt){
			int cmp=a[i].compareTo(v);
			if(cmp<0) exch(a, lt++, i++);
			else if(cmp>0) exch(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
	
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

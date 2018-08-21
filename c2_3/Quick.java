package c2_3;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);//消除对输入的依赖
		sort(a, 0, a.length-1);
	}
	
	//快速排序，通过递归，一半一半地排
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	//切分，使得a[lo..j-1]<=a[j]<=a[j+1..hi]
	private static int partition(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		Comparable v=a[lo];//切分元素，一般以第一个为切分元素
		while(true){
			while(less(a[++i],v)) if(i==hi) break;//从左往右，找到一个比v大的
			while(less(v, a[--j])) if(j==lo) break;//从右往左，找到一个比v小的
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);//将v放入正确位置
		return j;//返回切分点
	}
	
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
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

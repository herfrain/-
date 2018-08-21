package c2_3;

import c2_1.Insertion;
import c2_1.SortCompare;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	
	static int M;//小数组个数
	static int num;
	static int depth;//递归深度
	
	public static void sort(Comparable[] a){
		depth=0;
		num=0;
		StdRandom.shuffle(a);//消除对输入的依赖，对数组随机排序
		//找到最大的数，放在数组末尾，当做哨兵
		Comparable max=a[0];
		int q=0;
		for(int i=1;i<a.length;i++){
			if(less(max, a[i])){
				max=a[i];
				q=i;
			}
		}
		exch(a, q, a.length-1);
		
		sort(a, 0, a.length-1);
	}
	
	//快速排序，通过递归，一半一半地排
	public static void sort(Comparable[] a,int lo,int hi){
		
		if(hi<=lo+M){//如果数组a的个数小于等于M，则用插入排序
			Insertion.sort(a);
			return;
		}
		depth++;
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	//
	public static void sort2(Comparable[] a,int lo,int hi){
		
		if(hi<=lo+M){//如果数组a的个数小于等于M，则用插入排序
			Insertion.sort(a);
			return;
		}
		depth++;
		int j=partition2(a, lo, hi);
		sort(a,lo,j);//用j当左子数组右边界的哨兵
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
	
	//哨兵
	private static int partition2(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		Comparable v=a[lo];//切分元素，一般以第一个为切分元素
		while(true){
			while(less(a[++i],v)) ;//从左往右，找到一个比v大的
			while(less(v, a[--j])) ;//左侧检查是多余的
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);//将v放入正确位置
		return j;//返回切分点
	}
	
	private static boolean less(Comparable a,Comparable b){
		num++;
		return a.compareTo(b)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static void paixu(Double[] d1,Double[] d2,Double[] d3){
		for(int i=0;i<d1.length;i++){
			d1[i]=(double)i;
			d2[i]=StdRandom.uniform();
			d3[i]=(double)(d1.length-i);
		}
	}
	
	private static void show(Comparable[] a){
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(args[0]);

		//2.3.8处理N个全部重复的元素
//		StdDraw.setXscale(0,1000);
//		StdDraw.setYscale(0,10000);
//		for(int N=2;N<1000;N++){
//			Double[] D=new Double[N];
//			for(int i=0;i<N;i++){
//				D[i]=2.2;
//			}
//			sort(D);
//			StdOut.println(N+" "+num);
//			StdDraw.point(N, num);
//		}
		
		
		Double[] d1=new Double[N];//有序
		Double[] d2=new Double[N];//平均
		Double[] d3=new Double[N];//逆序
		paixu(d1, d2, d3);
		show(d2);
//		StdOut.println(SortCompare.time("Quick", d1, 0));
//		StdOut.println(SortCompare.time("Quick", d2, 0));
//		StdOut.println(SortCompare.time("Quick", d3, 0));
//		sort(d1);
//		StdOut.println(depth);
//		sort(d2);
//		StdOut.println(depth);
//		sort(d3);
//		StdOut.println(depth);
		sort(d2);
		show(d2);
	}

}

package c2_2;

import edu.princeton.cs.algs4.StdOut;

public class Merge {
	
	public static Comparable[] aux;
	public static int N;
	
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	
	//归并，将a[lo..mid]和a[mid+1..hi]归并
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		int i=lo;
		int j=mid+1;
		//将a数组复制到aux中
//		aux=new Comparable[a.length];
		for(int k=lo;k<=hi;k++){
			N++;
			aux[k]=a[k];
		}
		//比较排序后再放入a数组中
		for(int k=lo;k<=hi;k++){
			N++;
			//如果左边用尽（取右边）
			if(i>mid) a[k]=aux[j++];
			//如果右边用尽（取左边）
			else if(j>hi) a[k]=aux[i++];
			//哪一边小则把哪边放进去
			else if(less(aux[j], aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	
	//归并，将a[lo..mid]和a[mid+1..hi]归并
	public static void merge2(Comparable[] a,int lo,int mid,int hi){
		int i=lo;
		int j=hi;
		//将a数组前半部复制到aux前半部
		for(int k=lo;k<=mid;k++){
			N++;
			aux[k]=a[k];
		}
		//将a后半部分逆序后放到aux后面
		for(int k=mid+1;k<=hi;k++){
			N++;
			aux[k]=a[hi+mid+1-k];
		}
		//这样可以省去两边是否用尽的判断
		for(int k=lo;k<=hi;k++){
			N++;
			if(less(aux[j], aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	
	//自顶向下的归并排序
	public static void sort(Comparable[] a){
		N=0;
		aux=new Comparable[a.length];
//		StdOut.println(a.length);
		sort(a, 0, a.length-1);
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		//如果a[mid]小于等于a[mid+1]，可以认为已经有序
//		if(mid<a.length-1)
		if(!less(a[mid], a[mid+1])){
//			StdOut.println("UB:"+(hi-lo));
			merge(a, lo, mid, hi);
		}
			
	}
	
	//自底向上的归并排序
	public static void sortBU(Comparable[] a){
		int N=a.length;
		for(int sz=1;sz<N;sz+=sz){
			for(int lo=0;lo<N-sz;lo+=sz+sz){
				StdOut.println("BU:"+(Math.min(lo+sz+sz-1, N-1)-lo));
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

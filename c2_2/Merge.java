package c2_2;

import edu.princeton.cs.algs4.StdOut;

public class Merge {
	
	public static Comparable[] aux;
	public static int N;
	
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	
	//�鲢����a[lo..mid]��a[mid+1..hi]�鲢
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		int i=lo;
		int j=mid+1;
		//��a���鸴�Ƶ�aux��
//		aux=new Comparable[a.length];
		for(int k=lo;k<=hi;k++){
			N++;
			aux[k]=a[k];
		}
		//�Ƚ�������ٷ���a������
		for(int k=lo;k<=hi;k++){
			N++;
			//�������þ���ȡ�ұߣ�
			if(i>mid) a[k]=aux[j++];
			//����ұ��þ���ȡ��ߣ�
			else if(j>hi) a[k]=aux[i++];
			//��һ��С����ı߷Ž�ȥ
			else if(less(aux[j], aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	
	//�鲢����a[lo..mid]��a[mid+1..hi]�鲢
	public static void merge2(Comparable[] a,int lo,int mid,int hi){
		int i=lo;
		int j=hi;
		//��a����ǰ�벿���Ƶ�auxǰ�벿
		for(int k=lo;k<=mid;k++){
			N++;
			aux[k]=a[k];
		}
		//��a��벿�������ŵ�aux����
		for(int k=mid+1;k<=hi;k++){
			N++;
			aux[k]=a[hi+mid+1-k];
		}
		//��������ʡȥ�����Ƿ��þ����ж�
		for(int k=lo;k<=hi;k++){
			N++;
			if(less(aux[j], aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	
	//�Զ����µĹ鲢����
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
		//���a[mid]С�ڵ���a[mid+1]��������Ϊ�Ѿ�����
//		if(mid<a.length-1)
		if(!less(a[mid], a[mid+1])){
//			StdOut.println("UB:"+(hi-lo));
			merge(a, lo, mid, hi);
		}
			
	}
	
	//�Ե����ϵĹ鲢����
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

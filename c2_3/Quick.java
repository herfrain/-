package c2_3;

import c2_1.Insertion;
import c2_1.SortCompare;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	
	static int M;//С�������
	static int num;
	static int depth;//�ݹ����
	
	public static void sort(Comparable[] a){
		depth=0;
		num=0;
		StdRandom.shuffle(a);//������������������������������
		//�ҵ�����������������ĩβ�������ڱ�
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
	
	//��������ͨ���ݹ飬һ��һ�����
	public static void sort(Comparable[] a,int lo,int hi){
		
		if(hi<=lo+M){//�������a�ĸ���С�ڵ���M�����ò�������
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
		
		if(hi<=lo+M){//�������a�ĸ���С�ڵ���M�����ò�������
			Insertion.sort(a);
			return;
		}
		depth++;
		int j=partition2(a, lo, hi);
		sort(a,lo,j);//��j�����������ұ߽���ڱ�
		sort(a,j+1,hi);
	}
	
	//�з֣�ʹ��a[lo..j-1]<=a[j]<=a[j+1..hi]
	private static int partition(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		Comparable v=a[lo];//�з�Ԫ�أ�һ���Ե�һ��Ϊ�з�Ԫ��
		while(true){
			while(less(a[++i],v)) if(i==hi) break;//�������ң��ҵ�һ����v���
			while(less(v, a[--j])) if(j==lo) break;//���������ҵ�һ����vС��
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);//��v������ȷλ��
		return j;//�����зֵ�
	}
	
	//�ڱ�
	private static int partition2(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		Comparable v=a[lo];//�з�Ԫ�أ�һ���Ե�һ��Ϊ�з�Ԫ��
		while(true){
			while(less(a[++i],v)) ;//�������ң��ҵ�һ����v���
			while(less(v, a[--j])) ;//������Ƕ����
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);//��v������ȷλ��
		return j;//�����зֵ�
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

		//2.3.8����N��ȫ���ظ���Ԫ��
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
		
		
		Double[] d1=new Double[N];//����
		Double[] d2=new Double[N];//ƽ��
		Double[] d3=new Double[N];//����
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

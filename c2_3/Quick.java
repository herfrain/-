package c2_3;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);//���������������
		sort(a, 0, a.length-1);
	}
	
	//��������ͨ���ݹ飬һ��һ�����
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
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

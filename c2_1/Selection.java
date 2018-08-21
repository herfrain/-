package c2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


//ѡ������
public class Selection{
	
	static double max;
	
	public static void sort(Comparable[] a){
		
		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(less(a[j], a[min])) min=j;
			}
			exch(a, i, min);
		}
	}
	
	//����
	public static void Dsort(Comparable[] a){
		//�ҵ�double�����е����ֵ��������ͼ�������ĸ
		max=(double) a[0];
		for(int i=1;i<a.length;i++){
			if(less(max, a[i])) max=(double)a[i];
		}
		
		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(less(a[j], a[min])) min=j;
			}
			
			//��ͼ������С�ĺͽ�Ҫ�滻�ı��Ϊ��ɫ
			show(a);
			StdDraw.setPenColor(StdDraw.RED);
			double h2=(double)a[i];
			double h3=(double)a[min];
			StdDraw.filledRectangle((i+0.1)/a.length, h2/max/2, 0.01, h2/max/2);
			StdDraw.filledRectangle((min+0.1)/a.length, h3/max/2, 0.01, h3/max/2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			exch(a, i, min);
		}
		show(a);
	}
	
	//�Ƚϣ�java��������඼ʵ����Comparable�ӿ�
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	
	//����
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	//���
	private static void show(Comparable[] a){
		StdDraw.clear();//�����Ļ
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int i=0;i<a.length;i++){
			double h=(double)a[i];
			StdDraw.filledRectangle((i+0.1)/a.length, h/max/2, 0.01, h/max/2);
		}
		StdOut.println();
	}
	
	//�ж��Ƿ�����
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in=new In(args[0]);
		String[] a=in.readAllStrings();//������readStrings()
		sort(a);
		assert isSorted(a);
		show(a);
	}

}

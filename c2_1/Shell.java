package c2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

//ϣ������
public class Shell {
	
	static double max;
	
	public static void sort(Comparable[] a,int t){
		
		//����
		int N=a.length;
		
		int h=1;
		while(h<N/t) h=t*h;//��������
		while(h>=1){
			for(int i=h;i<N;i++){
				for(int j=i;j>=h&&less(a[j], a[j-h]);j-=h){
					//����
					exch(a, j, j-h);
				}
			}
		h/=t;
		}
		
	}
	
	public static void Dsort(Comparable[] a){
		
		//�ҵ����ֵ
		max=(double) a[0];
		for(int i=1;i<a.length;i++){
			if(less(max, a[i])) max=(double)a[i];
		}
		
		//����
		int N=a.length;
		int h=1;
		while(h<N/3) h=3*h+1;
		while(h>=1){
			for(int i=h;i<N;i++){
				for(int j=i;j>=h&&less(a[j], a[j-h]);j-=h){
					//��ͼ���������С���򽫺�����ǰ���滻
					show(a);
					StdDraw.setPenColor(StdDraw.RED);
					double h2=(double)a[j];
					double h3=(double)a[j-h];
					StdDraw.filledRectangle((j+0.1)/a.length, h2/max/2, 0.01, h2/max/2);
					StdDraw.filledRectangle((j-h+0.1)/a.length, h3/max/2, 0.01, h3/max/2);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//����
					exch(a, j, j-h);
				}
					
			}
			h/=3;
			show(a);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
		StdDraw.clear();//�����Ļ
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int i=0;i<a.length;i++){
			double h=(double)a[i];
			StdDraw.filledRectangle((i+0.1)/a.length, h/max/2, 0.01, h/max/2);
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

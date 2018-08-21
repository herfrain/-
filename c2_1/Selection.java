package c2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


//选择排序
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
	
	//排序
	public static void Dsort(Comparable[] a){
		//找到double数组中的最大值，用作画图的坐标分母
		max=(double) a[0];
		for(int i=1;i<a.length;i++){
			if(less(max, a[i])) max=(double)a[i];
		}
		
		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(less(a[j], a[min])) min=j;
			}
			
			//画图，将最小的和将要替换的标记为红色
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
	
	//比较，java里面基本类都实现了Comparable接口
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	
	//交换
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	//输出
	private static void show(Comparable[] a){
		StdDraw.clear();//清空屏幕
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int i=0;i<a.length;i++){
			double h=(double)a[i];
			StdDraw.filledRectangle((i+0.1)/a.length, h/max/2, 0.01, h/max/2);
		}
		StdOut.println();
	}
	
	//判断是否正序
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in=new In(args[0]);
		String[] a=in.readAllStrings();//不能用readStrings()
		sort(a);
		assert isSorted(a);
		show(a);
	}

}

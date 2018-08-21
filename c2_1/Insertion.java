package c2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Insertion { 
	
	static double max;
	
	public static void sort(Comparable[] a){

		for(int i=1;i<a.length;i++){
			for(int j=i;j>0&&less(a[j], a[j-1]);j--){			
				exch(a, j, j-1);
			}
		}
		
	}
	
	public static void Dsort(Comparable[] a) throws InterruptedException{
		//找到最大值
		max=(double) a[0];
		for(int i=1;i<a.length;i++){
			if(less(max, a[i])) max=(double)a[i];
		}
		
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0&&less(a[j], a[j-1]);j--){
				//画图，如果后面小，则将后面与前面替换
				show(a);
				StdDraw.setPenColor(StdDraw.RED);
				double h2=(double)a[j];
				double h3=(double)a[j-1];
				StdDraw.filledRectangle((j+0.1)/a.length, h2/max/2, 0.01, h2/max/2);
				StdDraw.filledRectangle((j-1+0.1)/a.length, h3/max/2, 0.01, h3/max/2);
				Thread.sleep(500);
				
				exch(a, j, j-1);
			}
			show(a);
			Thread.sleep(2000);
		}
		
	}
	
	public static void sort2(Comparable[] a){
		
		for(int i=2;i<a.length;i++){
			a[0]=a[i];
			int j;
			for(j=i-1;less(a[0], a[j]);j--){		
				exch(a, j, j+1);
			}
			exch(a, j+1, 0);
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
	
	public static void show(Comparable[] a) throws InterruptedException{
		StdDraw.clear();//清空屏幕
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
	
	public static void drawSort(Comparable[] a) {
		int N = a.length;
		StdDraw.setYscale(N + 3, 0);
		StdDraw.setXscale(0, N + 3);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(3 + N / 2, 0.4, "a[ ]");
		StdDraw.text(1, 1, "i");
		StdDraw.text(2, 1, "j");
		for (int i = 0; i < N; i++) {
			StdDraw.text(3 + i, 1, i + "");
			StdDraw.text(3 + i, 2, a[i].toString());
		}
		StdDraw.line(0, 1.5, N + 3, 1.5);
		for (int i = 1; i < N; i++) {
			StdDraw.text(1, 2 + i, i + "");
			int red = i;
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
				red = j - 1;
				StdDraw.text(3 + j, 2 + i, a[j].toString());
			}
			StdDraw.text(2, 2 + i, red + "");
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(3 + red, 2 + i, a[red].toString());
			StdDraw.setPenColor(StdDraw.GRAY);
			for (int k = 0; k < N; k++) {
				if (k < red || k > i) {
					StdDraw.text(3 + k, 2 + i, a[k].toString());
				}
			}
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		for (int i = 0; i < N; i++) {
			StdDraw.text(3 + i, N + 2, a[i].toString());
		}
	}

}

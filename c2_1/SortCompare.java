package c2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
	
	static Double[] test1;//有序
	static Double[] test2;//逆序
	static Double[] test3;//主键相同
	static Double[] test4;//只有两种值
	
	static int[] frequencies={0,1};
	
	///初始化
	public static void test(int N){
		test1=new Double[N];
		test2=new Double[N];
		test3=new Double[N];
		test4=new Double[N];
		for(int i=0;i<N;i++){
			test1[i]=(double) i;
			test2[i]=(double) N-i;
			test3[i]=(double) 5;
			if(i%2==0)
				test4[i]=(double) 0;
			else test4[i]=1.0;
			StdOut.println(test1[i]+" "+test2[i]+" "+test3[i]+" "+test4[i]);
		}
	}
	
	public static double time(String alg,Double[] a,int t){
		Stopwatch stopwatch=new Stopwatch();
		switch (alg) {
		case "Insertion":
			StdDraw.setPenColor(StdDraw.BLUE);
			Insertion.sort(a);
			break;
		case "Selection":
			StdDraw.setPenColor(StdDraw.RED);
			Selection.sort(a);
			break;
		case "Shell":
			Shell.sort(a,t);
			//Shell.sort(a,2);
			break;
		default:
			break;
		}
		return stopwatch.elapsedTime();
	}
	
	public static double timeRandomInput(String alg,int N,int T,int t){
		double total=0.0;
		int time=0;
		StdDraw.setXscale(0, T);
		StdDraw.setYscale(-0.1,0.1);
		Double[] a=new Double[N];
		for(int q=0;q<T;q++){
			for(int i=0;i<N;i++){
				a[i]=StdRandom.uniform();
			}
			total+=time(alg, a,t);
			time++;
			
			StdDraw.point(time, total);
			StdDraw.point(time, total/time);
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alg1=args[0]; 
		String alg2=args[1];
		String alg3=args[2];
		int N=Integer.parseInt(args[3]);
		int T=Integer.parseInt(args[4]);
		
//		double t1=timeRandomInput(alg1, N, T);
//		double t2=timeRandomInput(alg2, N, T);
//		double t3 = 0;
//		for(int t=2;t<100;t++){
//			StdDraw.setPenColor(t,0,0);
//			t3=timeRandomInput(alg3, N, T,t);
//		}
		test(N);
		double a1t1=time(alg1, test1, 0);
		double a2t1=time(alg2, test1, 0);
		double a3t1=time(alg3, test1, 2);
		StdOut.println("a1t1:"+a1t1);
		StdOut.println("a2t1:"+a2t1);
		StdOut.println("a3t1:"+a3t1);
		StdOut.println();
		
		double a1t2=time(alg1, test2, 0);
		double a2t2=time(alg2, test2, 0);
		double a3t2=time(alg3, test2, 2);
		StdOut.println("a1t2:"+a1t2);
		StdOut.println("a2t2:"+a2t2);
		StdOut.println("a3t2:"+a3t2);
		StdOut.println();
		
		double a1t3=time(alg1, test3, 0);
		double a2t3=time(alg2, test3, 0);
		double a3t3=time(alg3, test3, 2);
		StdOut.println("a1t3:"+a1t3);
		StdOut.println("a2t3:"+a2t3);
		StdOut.println("a3t3:"+a3t3);
		StdOut.println();
		
		double a1t4=time(alg1, test4, 0);
		double a2t4=time(alg2, test4, 0);
		double a3t4=time(alg3, test4, 2);
		StdOut.println("a1t4:"+a1t4);
		StdOut.println("a2t4:"+a2t4);
		StdOut.println("a3t4:"+a3t4);
		StdOut.println();

		//StdOut.println("times:"+t1/t2);
	}

}

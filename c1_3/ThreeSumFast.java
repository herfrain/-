package c1_3;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumFast {
	
	public static int count(int[] a){
		Arrays.sort(a);
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				if(BinarySearch.rank(-a[i]-a[j], a)>j)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=In.readInts(args[0]);
		Stopwatch timer=new Stopwatch();
		StdOut.println(count(a));
		StdOut.println(timer.elapsedTime()+"s");
	}

}

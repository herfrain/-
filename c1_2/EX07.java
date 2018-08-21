package c1_2;

import edu.princeton.cs.algs4.StdIn;

public class EX07 {
	
	public static String mystery(String s,int num) {
		System.out.println(num);
		int N = s.length();
		if (N <= 1) {
			return s;
		}
		String a = s.substring(0, N / 2);
		String b = s.substring(N / 2, N);
		return mystery(b,++num) + mystery(a,++num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mystery(StdIn.readLine(),0));
		
	}

}

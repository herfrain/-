package c1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class EX06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=0;
		In in=new In(args[0]);//获取文件
		while(in.hasNextLine()&&!in.readLine().isEmpty()){
			N++;//计算文件中行数
		}
		System.out.println(N);
		
		in.close();
		in=new In(args[0]);
		
		for(int i=0;i<N;i++){
			
			String s1=in.readString();
			String s2=in.readString();
//			s1=s.split(" ")[0];
//			s2=s.split(" ")[1];
//			System.out.println(s1);
			if(s1.length()==s2.length()&&s1.concat(s1).contains(s2)){
				System.out.println(s1 + " is the circular rotation of " + s2);
			}else {
				System.out.println(s1 + " is not the circular rotation of " + s2);
			}
		}
		
	}

}

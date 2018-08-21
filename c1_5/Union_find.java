package c1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Union_find {
	
	int[] id;
	int count;
	
	int cost;//每次访问数组次数
	int total;//访问总次数
	
	public Union_find(int N){
		id=new int[N];
		count=N;
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}
	
	//quick-find，数组中有相同变量的则为同一个分量
	public void union1(int p,int q){
		cost=0;
		int pID=find1(p);
		int qID=find1(q);
		if(pID==qID) return;
		for(int i=0;i<id.length;i++){	
			if(id[i]==pID) {
				cost++;
				id[i]=qID;
			}
		}
		total+=cost;
		count--;
	}
	
	public int find1(int p){
		cost++;
		return id[p];
	}
	
	//一般情况下比上面的方法快
	//quick-union，用父链接的方式表示一片森林
	public void union2(int p,int q){
		cost=0;
		int pRoot=find2(p);
		int qRoot=find2(q);
		if(pRoot==qRoot) return;
		id[pRoot]=qRoot;
		cost++;
		total+=cost;
		count--;
	}
	
	public int find2(int p){
		while(p!=id[p]){
			cost++;
			p=id[p];
		}
		return p;
	}
	
	//判断是否连接
	public boolean connected1(int p,int q){
		return find1(p)==find1(q);
	}
	
	public boolean connected2(int p,int q){
		return find2(p)==find2(q);
	}
	
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in=new In(args[0]);
		int N=in.readInt();//触点个数
		StdOut.println(N);
		Union_find uf=new Union_find(N);
		
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(-300, 600);
		int i=0;//连接次数
		while(!in.isEmpty()){
			int p=in.readInt();
			int q=in.readInt();
			if(uf.connected1(p, q)) continue;//如果已经连通则忽略
			uf.union1(p, q);//没连通则归并分量
//			StdOut.println(p+" "+q);
			i++;
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(i, uf.cost);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, uf.total/i);
		}
		StdOut.println(uf.count()+" components");
	}

}

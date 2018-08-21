package c1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

//加权quick-union算法
public class WeightedQuickUnionUF {
	
	int[] id;//储存根节点
	int[] sz;//各个根节点对应的分量大小
	int count;//分量数
	
	int cost;//每次访问数组次数
	int total;//访问总次数
	
	//初始化
	public WeightedQuickUnionUF(int N){
		id=new int[N];
		sz=new int[N];
		count=N;
		for(int i=0;i<N;i++){
			id[i]=i;
			sz[i]=1;//初始化每个根节点的分量大小为1
		}
	}
	
	//连接
	public void union(int p,int q){
		cost=0;
		int pRoot=find(p);
		int qRoot=find(q);
		if(pRoot==qRoot){
			total+=cost;
			return;
		}
		
		//将小树连接到大树的根节点
		if(sz[pRoot]<sz[qRoot]){
			cost++;
			id[pRoot]=qRoot;
			sz[qRoot]+=sz[pRoot];
		}else{
			cost++;
			id[qRoot]=pRoot;
			sz[pRoot]+=sz[qRoot];
		}
		total+=cost;
		count--;
	}
	
	public void union2(int p,int q){
		int pRoot=find2(p);
		int qRoot=find2(q);
		if(pRoot==qRoot) return;
		
		//将小树连接到大树的根节点
		if(sz[pRoot]<sz[qRoot]){
			id[pRoot]=qRoot;
			sz[qRoot]+=sz[pRoot];
		}else{
			id[qRoot]=pRoot;
			sz[pRoot]+=sz[qRoot];
		}
		count--;
	}
	
	//寻找根节点
	public int find(int p){
		while(p!=id[p]){
			p=id[p];//循环结束后pp为根节点
			cost++;
		}
		return p;
	}
	
	//压缩路径的寻找
	public int find2(int p){
		int pp=p;
		while(pp!=id[pp]){
			pp=id[pp];//循环结束后pp为根节点
		}
		while(p!=id[p]){
			id[p]=pp;//直接连接到根节点
			p=id[p];
		}
		return pp;
	}
	
	//判断是否连接
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	
	public boolean connected2(int p,int q){
		return find2(p)==find2(q);
	}
	
	//返回分量数
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in=new In(args[0]);
		int N=in.readInt();//触点个数
		StdOut.println(N);
		WeightedQuickUnionUF uf=new WeightedQuickUnionUF(N);
		
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(-20, 20);
		
		int i=0;//连接次数
		Stopwatch stopwatch=new Stopwatch();
		while(!in.isEmpty()){
			int p=in.readInt();
			int q=in.readInt();
//			if(uf.connected(p, q)) continue;//如果已经连通则忽略
			
			uf.union(p, q);//没连通则归并分量
//			StdOut.println(p+" "+q);
			
			i++;
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(i, uf.cost);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, uf.total/i);
		}
		StdOut.println(uf.count()+" components");
		StdOut.println("Time "+stopwatch.elapsedTime()+"s");
	}

}

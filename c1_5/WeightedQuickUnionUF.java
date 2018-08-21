package c1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

//��Ȩquick-union�㷨
public class WeightedQuickUnionUF {
	
	int[] id;//������ڵ�
	int[] sz;//�������ڵ��Ӧ�ķ�����С
	int count;//������
	
	int cost;//ÿ�η����������
	int total;//�����ܴ���
	
	//��ʼ��
	public WeightedQuickUnionUF(int N){
		id=new int[N];
		sz=new int[N];
		count=N;
		for(int i=0;i<N;i++){
			id[i]=i;
			sz[i]=1;//��ʼ��ÿ�����ڵ�ķ�����СΪ1
		}
	}
	
	//����
	public void union(int p,int q){
		cost=0;
		int pRoot=find(p);
		int qRoot=find(q);
		if(pRoot==qRoot){
			total+=cost;
			return;
		}
		
		//��С�����ӵ������ĸ��ڵ�
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
		
		//��С�����ӵ������ĸ��ڵ�
		if(sz[pRoot]<sz[qRoot]){
			id[pRoot]=qRoot;
			sz[qRoot]+=sz[pRoot];
		}else{
			id[qRoot]=pRoot;
			sz[pRoot]+=sz[qRoot];
		}
		count--;
	}
	
	//Ѱ�Ҹ��ڵ�
	public int find(int p){
		while(p!=id[p]){
			p=id[p];//ѭ��������ppΪ���ڵ�
			cost++;
		}
		return p;
	}
	
	//ѹ��·����Ѱ��
	public int find2(int p){
		int pp=p;
		while(pp!=id[pp]){
			pp=id[pp];//ѭ��������ppΪ���ڵ�
		}
		while(p!=id[p]){
			id[p]=pp;//ֱ�����ӵ����ڵ�
			p=id[p];
		}
		return pp;
	}
	
	//�ж��Ƿ�����
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	
	public boolean connected2(int p,int q){
		return find2(p)==find2(q);
	}
	
	//���ط�����
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in=new In(args[0]);
		int N=in.readInt();//�������
		StdOut.println(N);
		WeightedQuickUnionUF uf=new WeightedQuickUnionUF(N);
		
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(-20, 20);
		
		int i=0;//���Ӵ���
		Stopwatch stopwatch=new Stopwatch();
		while(!in.isEmpty()){
			int p=in.readInt();
			int q=in.readInt();
//			if(uf.connected(p, q)) continue;//����Ѿ���ͨ�����
			
			uf.union(p, q);//û��ͨ��鲢����
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

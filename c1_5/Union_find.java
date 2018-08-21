package c1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Union_find {
	
	int[] id;
	int count;
	
	int cost;//ÿ�η����������
	int total;//�����ܴ���
	
	public Union_find(int N){
		id=new int[N];
		count=N;
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}
	
	//quick-find������������ͬ��������Ϊͬһ������
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
	
	//һ������±�����ķ�����
	//quick-union���ø����ӵķ�ʽ��ʾһƬɭ��
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
	
	//�ж��Ƿ�����
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
		int N=in.readInt();//�������
		StdOut.println(N);
		Union_find uf=new Union_find(N);
		
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(-300, 600);
		int i=0;//���Ӵ���
		while(!in.isEmpty()){
			int p=in.readInt();
			int q=in.readInt();
			if(uf.connected1(p, q)) continue;//����Ѿ���ͨ�����
			uf.union1(p, q);//û��ͨ��鲢����
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

package c1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item>{
	
	private Node first;
	private Node last;
	private int N;
	
	
	class Node{
		Item item;
		Node next;
	}
	
	public void enqueue(Item item){
		Node newlast=new Node();
		newlast.item=item;
		newlast.next=null;
		//环形队列
		//newlast.next=first;
		if(isEmpty()) {
			first=newlast;
		}else{
			last.next=newlast;
		}
		last=newlast;
		N++;
	}
	
	public Item dequeue(){
		Item item=first.item;
		first=first.next;
		if(isEmpty()) last=null;
		N--;
		return item;
	}
	
	//1.3.20 删除第k个元素
	public void delete(int k){
		int i=1;
		Node n=first;
		Node pn = null;
		while(i!=k){
			i++;
			pn=n;
			n=n.next;
		}
		StdOut.print(n.item+" ");
		if(pn!=null){
			pn.next=n.next;
		}
		else{
			first=first.next;
		}
		N--;
	}
	
	//1.3.21 寻找key
	public boolean find(Item key){
		Node n=first;
		while(n.next!=null){
			if(n.item.equals(key)) return true;
			n=n.next;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return N;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{
		private Node current=first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
	
	//N个人，数到M的死亡
	public void Josephus(int N,int M,Queue<String> queue){
		for(int i=0;i<N;i++){
			queue.enqueue(i+"");
		}
		int i=1;
		int q=1;
		while(this.N!=0){
			int m=M%this.N;
			if(m==0) m=this.N;
			if(q>this.N) q=1;
			if(i%M==0){
				delete(q);
				i=1;
				continue;
			}
			q++;
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int k=Integer.parseInt(args[0]);
//		In in=new In(args[2]);
		Queue<String> queue=new Queue<String>();
//		while(in.hasNextChar()){
//			queue.enqueue(in.readString());
//		}
		
		
//		int n=0;
//		for(String s:queue){
//			//1.3.15
////			if(n++==queue.size()-k) StdOut.println(s);
//			StdOut.print(s+" ");
//		}StdOut.println();
//		
//		queue.delete(k);
		
//		for(String s:queue){
//			StdOut.print(s+" ");
//		}StdOut.println();
//		//1.3.21
//		String key=args[1];
//		StdOut.println(queue.find(key));
		
		int N=Integer.parseInt(args[0]);
		int M=Integer.parseInt(args[1]);
		
		double t1=System.currentTimeMillis();
		queue.Josephus(N,M,queue);
		double t2=System.currentTimeMillis();
		System.out.println();
		System.out.println(t2-t1);
	}

}

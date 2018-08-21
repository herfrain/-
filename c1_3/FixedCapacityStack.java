package c1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> implements Iterable<Item> {
	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int n){
		a=(Item[])new Object[n];
	}
	
	public void push(Item item){
		if(N==a.length) resize(2*a.length);
		a[N++]=item;
	}
	
	public Item pop(){
		Item item=a[--N];
		a[N]=null;
		if(N>0&&N<=a.length/4) resize(a.length/2);
		return item;
	}
	
	public boolean isFull(){
		return N==a.length;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	private void resize(int max){
		Item[] newA=(Item[])new Object[max];
		for(int i=0;i<N;i++){
			newA[i]=a[i];
		}
		a=newA;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	public class ReverseArrayIterator implements Iterator<Item>{
		private int i=N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStack<String> s;
		s=new FixedCapacityStack<String>(1);
		In in=new In(args[0]);
		while(in.hasNextChar()){
			String item=in.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty()) StdOut.println("pop:"+s.pop()+" ");
		}
		
		for (String t : s) {
			StdOut.println("Stack:"+t);
		}
	}

	

}

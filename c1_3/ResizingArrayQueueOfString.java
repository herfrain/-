package c1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfString<Item> implements Iterable<Item>{
	
	private Item[] items;
	private int first;
	private int last;
	private int N;
	
	public ResizingArrayQueueOfString(int n){
		items=(Item [])new Object[n];
	}
	
	public void enqueue(Item item){
		if(isFull()) resize(2*items.length);
		items[last++]=item;
		N++;
	}
	
	public Item dequeue(){
		Item item=items[first];
		items[first]=null;
		first++;
		N--;
		if(N>0&&N<=items.length/4) resize(items.length/2);
		return item;
	}
	
	private boolean isFull(){
		return N==items.length;
	}
	
	private boolean isEmpty(){
		return N==0;
	}
	
	private void resize(int max){
		Item[] newItems=(Item[])new Object[max];
		for(int i=0,j=first;i<N;i++,j++){
			newItems[i]=items[j];
		}
		
		last=last-first;
		first=0;
		items=newItems;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	public class ReverseArrayIterator implements Iterator<Item>{
		private int i=first;
		private int n=N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return n>0;
		}
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			n--;
			return items[i++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayQueueOfString<String> q;
		q=new ResizingArrayQueueOfString<String>(1);
		In in=new In(args[0]);
		while(in.hasNextChar()){
			String item=in.readString();
			if(!item.equals("-"))
				q.enqueue(item);
			else if(!q.isEmpty()) StdOut.println("dequeue:"+q.dequeue()+" ");
		}
		
		for (String t : q) {
			StdOut.println("Stack:"+t);
		}
	}

}

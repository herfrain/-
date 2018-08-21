package c1_3;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//环形队列
public class RingBuffer<Item> {
	private Item[] items;
	private int N;
	private int first;
	private int last;
	
	public RingBuffer(int n){
		items=(Item[])new Object[n];
	}
	
	public void enqueue(Item item){
		if(isFull()) {
			StdOut.println("is full!");
			return ;
		}
		if(last>N) last=0;
		items[last++]=item;
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty()) {
			StdOut.println("is empty!");
			return null;
		}
		if(first>N) first=0;
		N--;
		return items[first++];
	}
	
	public boolean isFull(){
		return N==items.length;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void show(){
		for(int i=first,q=0;q<N;i++,q++){
			if(i>=N) i=0;
			StdOut.println(items[i]);
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		RingBuffer<String> ringBuffer=new RingBuffer<String>(n);
		String s="";
		while(!(s=sc.next()).equals("*")){
			if(s.equals("-")) ringBuffer.dequeue();
			else ringBuffer.enqueue(s);
		}
		
		ringBuffer.show();
		
	}

}

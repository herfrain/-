package c1_3;

import java.util.Iterator;


public class Bag<Item> implements Iterable<Item> {
	
	private Node first;
	private int N;
	
	class Node{
		Item item;
		Node next;
	}
	
	public void add(Item item){
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

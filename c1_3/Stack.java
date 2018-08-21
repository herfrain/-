package c1_3;

import java.util.Iterator;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item>{
	
	private Node first;
	private int N;
	
	
	class Node{
		Item item;
		Node next;
	}
	
	public void push(Item item){
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	
	public Item pop(){
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}
	
	public Item peek(){
		return first.item;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return N;
	}
	
	public Stack<String> copy(Stack<String> s){
		Stack<String> newS=new Stack<String>();
		for(String ss:s){
			newS.push(ss);
		}
		return newS;
	}
	
	//µü´úÆ÷
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
	
	//À¨ºÅÊÇ·ñÆ¥Åä
	public static boolean ParenthesesMatching(String s){
		Stack<Character> stack=new Stack<Character>();
		
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			switch (c) {
			case '(':
			case '[':	
			case '{':
				stack.push(c);
				break;
				
			case ')':
				if(stack.pop()=='('){
					break;
				}else return false;			
			case ']':
				if(stack.pop()=='['){
					break;
				}else return false;
			case '}':
				if(stack.pop()=='{'){
					break;
				}else return false;
			default:
				break;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.3.1
//		Stack<String> stack=new Stack<String>();
//		
//		Scanner sc=new Scanner(System.in);
//		String s=sc.nextLine();
//		String[] ss=s.split(" ");
//		for(int i=0;i<ss.length;i++){
//			if(!ss[i].equals("-")) stack.push(ss[i]);
//			else if(!stack.isEmpty()) StdOut.print(stack.pop()+" ");
//		}
		
		//1.3.4
		In in=new In(args[0]);
		String s = null;
		if(!in.isEmpty()){
			s=in.readAll();
		}
		StdOut.println(ParenthesesMatching(s));
	}

}

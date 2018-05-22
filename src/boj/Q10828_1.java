package boj;

import java.util.*;

public class Q10828_1 {			// 스택(Node)
	private static int size = 0;
	private static Node top;
	
	public static void main(String[] args) {
		input();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			
			if(str.equals("push")) {
				push(sc.nextInt());
			} else if(str.equals("pop")) {
				System.out.println(pop());
			} else if(str.equals("size")) {
				System.out.println(size());
			} else if(str.equals("empty")) {
				empty();
			} else if(str.equals("top")) {
				top();
			}
			
		}
//		testPrint();
	}
	
	public static void push(int num) {
		Node newNode = new Node();
		newNode.data = num;
		newNode.link = top;			// ?
		top = newNode;				// ?
		size++;

//		System.out.println("1. newNode.link : " + newNode.link);
//		System.out.println("1. top	        : " + top);
//		System.out.println("1. newNode      : " + newNode);
	}
	
	public static int pop() {
		if(top == null) {
			return -1;
		} else {
			int data = top.data;
			top = top.link;			// ?
			size--;
			return data;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static void empty() {
		if(top == null) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void top() {
		if(top == null) {
			System.out.println(-1);
		} else {
			System.out.println(top.data);
		}
	}
	
	public static void testPrint() {
		if(top == null) {
			System.out.println("생성된거 없음");
		} else {
			Node temp = top;
			
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.link;
			}
		}
	}
}

class Node {
	int data;
	Node link;
}
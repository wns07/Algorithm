package boj;

import java.util.*;

public class Q10845_1 {		// 큐(연결큐)
	private static int size = 0;
	
	private static Node front = null;
	private static Node back = null;
	
	private static class Node {
		private int data;
		private Node link;
	}
	
	public static void main(String[] args) {
		input();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			
			if(s.equals("push")) {
				push(sc.nextInt());
			} else if(s.equals("pop")) {
				System.out.println(pop());
			} else if(s.equals("size")) {
				System.out.println(size);
			} else if(s.equals("empty")) {
				empty();
			} else if(s.equals("front")) {
				front();
			} else if(s.equals("back")) {
				back();
			}
		}
		
//		testPrint();
	}
	
	public static void push(int num) {
		Node newNode = new Node();
		newNode.data = num;
		newNode.link = null;
		size++;
		
		if(front == null) {
			front = newNode;
			back = newNode;
		} else {
			back.link = newNode;
			back = newNode;
		}
	}
	
	public static int pop() {
		if(front == null) {
			return -1;
		} else {
			int data = front.data;
			front = front.link;
			size--;
			
			if(front == null) {
				back = null;
			}
			
			return data;
		}
	}
	
	public static void empty() {
		if(front == null) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void front() {
		if(front == null) {
			System.out.println(-1);
		} else {
			System.out.println(front.data);
		}
	}
	
	public static void back() {
		if(front == null) {
			System.out.println(-1);
		} else {
			System.out.println(back.data);
		}
	}
	
	public static void testPrint() {
		if(front == null) {
			System.out.println("생성된거 없음");
		} else {
			Node temp = front;
			
			while(temp != null) {
				System.out.println("값 : " + temp.data);
				temp = temp.link;
			}
		}
	}
}

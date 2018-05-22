package boj;

import java.util.*;

public class Q10828_0 { // 스택(array)
	private static int top = -1;
	private static int size = 0;
	private static int[] array = null, temp = null;

	public static void main(String[] args) {
		input();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String str = sc.next();

			if (str.equals("push")) {
				push(sc.nextInt());
			} else if (str.equals("pop")) {
				System.out.println(pop());
			} else if (str.equals("size")) {
				size();
			} else if (str.equals("empty")) {
				empty();
			} else if (str.equals("top")) {
				top();
			}
		}
//		testPrint();
	}

	public static void push(int num) {
		if (array == null) {
			array = new int[++size];
			array[++top] = num;
		} else {
			// 기존값 복사
			temp = new int[++size];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = new int[size];
			for (int i = 0; i < array.length; i++) {
				array[i] = temp[i];
			}
			
			// stack push
			array[++top] = num;
		}
	}

	public static int pop() {
		if (array == null || size == 0) {
			top = -1;
			return -1;
		} else {
			int data = array[top--];
			
			// 기존값 복사
			temp = new int[--size];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = array[i];
			}
			array = new int[size];
			for (int i = 0; i < array.length; i++) {
				array[i] = temp[i];
			}
			
			if(size == 0) {
				array = null;
			}

			return data;
		}
	}

	public static void size() {
		System.out.println(size);
	}

	public static void empty() {
		if (array == null) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void top() {
		if (array == null) {
			System.out.println(-1);
		} else {
			System.out.println(array[top]);
		}
	}
	
	public static void testPrint() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

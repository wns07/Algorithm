package boj;

import java.util.*;

public class Q2747 {			// 피보나치 수(메모이제이션)
	static int[] memoization;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memoization = new int[n+1];
		
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		} else if(memoization[n] != 0){
			return memoization[n];
		} else {
			return memoization[n] = fibonacci(n-1) + fibonacci(n-2);
		}
	}
}

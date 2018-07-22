package boj;

import java.util.*;

public class Q2748 {		// 피보나치 수2
	static long arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new long[n+1];
		sc.close();
		
		arr[1] = 1;
		
		for(int i=2; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[n]);
	}
}

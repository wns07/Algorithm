package boj;

import java.util.*;

public class Q1003 {			// 피보나치 함수
	static int t;
	static int[][] a;
	
	public static void main(String[] args) {
		input();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int num = sc.nextInt();
			fibonacci(num);
		}
		
		sc.close();
	}
	
	public static void fibonacci(int n) {
		if(n == 0) {
			System.out.println(1 + " " + 0);
			return;
		} else if(n == 1) {
			System.out.println(0 + " " + 1);
			return;
		}
		
		a = new int[n+1][2];
		a[0][0] = 1;
		a[1][1] = 1;
		
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<2; j++) {
				a[i][j] = a[i-1][j] + a[i-2][j];
			}
		}
		System.out.println(a[n][0] + " " + a[n][1]);
	}
}

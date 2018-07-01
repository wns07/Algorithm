package boj;

import java.util.*;

public class Q2839 {		// 설탕배달
	static int n = 0;
	static int a = 0, b = 0;		// a=3kg, b=5kg

	public static void main(String[] args) {
		input();
		solve(n);
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 18
		sc.close();
	}
	
	public static void solve(int k) {
		int p = 0, q = k/5;		// p=3kg, q=5kg
		
		while(q >= 0) {
			int temp = k;
			temp -= 5 * q;
			
			if(temp%3 == 0) {
				p = temp / 3;
				break;
			}
			
			q--;
		}
		
		if(q == -1) {
			System.out.println(-1);
		} else {
			System.out.println(p + q);
		}
		
	}
}

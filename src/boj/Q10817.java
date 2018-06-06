package boj;

import java.util.*;

public class Q10817 {			// 세 수
	static int[] a = new int[3];
	
	public static void main(String[] args) {
		input();
		solve();
		resultPrint();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
	}
	
	public static void resultPrint() {
		System.out.println(a[1]);
	}
	
	public static void solve() {
		Arrays.sort(a);
	}
}

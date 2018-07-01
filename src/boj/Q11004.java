package boj;

import java.util.*;

public class Q11004 {		// K번째 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		// 정렬
		Arrays.sort(a);

		System.out.println(a[k-1]);
	}
}

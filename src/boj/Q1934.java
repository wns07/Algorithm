package boj;

import java.util.*;

public class Q1934 {		// 최소공배수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] a = new int[t][2];
		int[] gcd = new int[t];
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		for(int i=0; i<a.length; i++) {
			int max = 0;
			
			if(a[i][0] > a[i][1]) {
				max = a[i][0];
			} else {
				max = a[i][1];
			}
			
			for(int j=max; j>0; j--) {
				if(a[i][0]%j==0 && a[i][1]%j==0) {
					gcd[i] = j;
					a[i][0] /= j;
					a[i][1] /= j;
					break;
				}
			}
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i][0] * a[i][1] * gcd[i]);
		}
	}
}

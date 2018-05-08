package boj;

import java.util.*;

public class Q1932 {		// 숫자삼각형
	static int[][] a;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 삼각형 크기
		a = new int[n][];
		
		for(int i=0; i<a.length; i++) {
			int cnt = 0;
			
			for(int j=0; j<i+1; j++) {
				cnt++;
			}
			a[i] = new int[cnt];
		}
		for(int i=0; i<a.length; i++) {		// i = 0 / 1	/ 2		/ 3			/ 4
			for(int j=0; j<i+1; j++) {		// j = 0 / 0,1	/ 0,1,2 / 0,1,2,3	/ 0,1,2,3,4
				a[i][j] = sc.nextInt();
			}
		}

//		System.out.println();
//		testPrint();
		solve();
//		System.out.println();
//		testPrint();
		System.out.println(resultPrint());
	}
	
	public static void solve() {
		for(int i=1; i<a.length; i++) {		// i = 1	/ 2		/ 3			/ 4
			for(int j=0; j<i+1; j++) {		// j = 0,1	/ 0,1,2 / 0,1,2,3	/ 0,1,2,3,4
				if(j==0) {
					a[i][j] += a[i-1][j];
				} else if(j == i) {
					a[i][j] += a[i-1][j-1];
				} else {
					a[i][j] += makeMax(i, j);
				}
			}
		}
	}
	
	public static int makeMax(int p, int q) {
		int max = 0;
		
		if(a[p-1][q-1] > a[p-1][q]) {
			max = a[p-1][q-1];
		} else {
			max = a[p-1][q];
		}
		
		return max;
	}
	
	public static int resultPrint() {
		int result = 0;
		int temp = a.length-1;
		
		for(int i=0; i<a[temp].length; i++) {		// i=0,1,2,3,4
			if(a[temp][i] > result) {
				result = a[temp][i];
			}
		}
		return result;
	}
	
	public static void testPrint() {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}

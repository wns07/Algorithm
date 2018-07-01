package boj;

import java.util.*;

public class Q1978 {		// 소수 찾기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int n = sc.nextInt();		// 수의 갯수
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=0; i<n; i++) {
			int num = a[i];
			int localCnt = 0;
			
			for(int j=1; j<=a[i]; j++) {
				if(num % j == 0) {
					localCnt++;
				}
			}
			
			if(localCnt == 2) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
